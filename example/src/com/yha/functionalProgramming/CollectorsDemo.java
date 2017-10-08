package com.yha.functionalProgramming;

import com.yha.functionalProgramming.entity.Album;
import com.yha.functionalProgramming.entity.Artist;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

import java.util.function.IntFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author yha
 * @decription 使用收集器的一些示例
 * @create 2017-10-08 0:45
 **/
public class CollectorsDemo {

    //收集Stream中的元素，当调用toList或toSet，不需要指定具体的类型，Stream会自动选择合适的类型，这样更适合并行操作
    //当需要使用特定的集合收集元素时，可以调用toCollection，并传入一个函数，用来构造需要的集合
    public static void testToCollection(){
        Arrays.asList("abc","def","ghi").stream()
                .collect(toCollection(TreeSet::new));
    }

    //转换成值
    //让Stream生成一个值， maxBy 和 minBy 允许用户按某种特定的顺序生成一个值
    //找出成员最多的乐队
    public static Optional<Artist> testMaxBy(Stream<Artist> artists){

        Function<Artist, Long> getCount = artist -> artist.getMembers().count();

        return artists.collect(maxBy(comparing(getCount)));
    }
    //找出一组专辑的平均曲目数
    public double avarageNumberOfTracks(List<Album> albums){
        return albums.stream()
                .collect(averagingInt(album -> album.getTrackList().size()));
    }

    //使用partitionBy进行数据分块，需要一个Predicate函数，只能按照TRUE或FALSE分成两组
    //划分乐队和独唱歌手
    public Map<Boolean, List<Artist>> bandsAndSolo(Stream<Artist> artists){
        return artists.collect(partitioningBy(artist -> artist.isSolo()));
    }
    public Map<Boolean, List<Artist>> bandsAndSolo2(Stream<Artist> artists){
        return artists.collect(partitioningBy(Artist::isSolo));
    }

    //使用groupingBy对数据进行分组，可以多组
    //使用主唱对专辑分组
    public Map<Artist, List<Album>> albumByArtist(Stream<Album> albums){
        return albums.collect(groupingBy(Album::getMainMusician));
    }

    //使用joining从流生成一个字符串
    //获取参与创作一个专辑的艺术家的姓名列表
    public String formatAlbumArtists(Album album){
        return album.getMusicians()
                .map(Artist::getName)
                .collect(joining(", ", "[", "]"));
    }

    //使用counting计数
    //统计每个艺术家的专辑数
    public Map<Artist, Long> numberOfAlbums(Stream<Album> albums){
        return albums.collect(groupingBy(Album::getMainMusician, counting()));
    }

    //使用mapping在收集器上对数据进行操作
    //使用收集器获取每个艺术家的专辑名列表
    public Map<Artist, List<String>> nameOfAlbums(Stream<Album> albums){
        return albums.collect(groupingBy(Album::getMainMusician, mapping(Album::getName, toList())));
    }



    private static final int N = 2000000000;
    //使用Stream并行模拟两次投递色子的点数和的概率
    public Map<Integer, Double> parallelDiceRolls() {
        double fraction = 1.0 / N;
        return IntStream.range(0, N)                        // <1>
                .parallel()                         // <2>
                .mapToObj(twoDiceThrows())          // <3>
                .collect(groupingBy(side -> side,   // <4>
                        summingDouble(n -> fraction))); // <5>
    }
    private static IntFunction<Integer> twoDiceThrows() {
        return i -> {
            ThreadLocalRandom random = ThreadLocalRandom.current();
            int firstThrow = random.nextInt(1, 7);
            int secondThrow = random.nextInt(1, 7);
            return firstThrow + secondThrow;
        };
    }

    //使用Stream串行模拟两次投递色子的点数和的概率
    public Map<Integer, Double> serialDiceRolls() {
        double fraction = 1.0 / N;
        return IntStream.range(0, N)
                .mapToObj(twoDiceThrows())
                .collect(groupingBy(side -> side, summingDouble(n -> fraction)));
    }

    //并行Stream求和，基本类型比包装类型效率更高
    public int addIntegers(List<Integer> values){
        return values.parallelStream()
                .mapToInt(i -> i)
                .sum();
    }

    public static void main(String[] args){

        CollectorsDemo demo = new CollectorsDemo();

        long b = System.currentTimeMillis();
        Map<Integer, Double> map = demo.parallelDiceRolls();

        map.forEach((key, value) -> System.out.println(key + ":" + value));

        long e = System.currentTimeMillis();

        System.out.println((e - b) + "ms");
    }

}
