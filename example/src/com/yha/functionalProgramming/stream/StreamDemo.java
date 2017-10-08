package com.yha.functionalProgramming.stream;

import com.yha.functionalProgramming.entity.Album;
import com.yha.functionalProgramming.entity.Artist;
import com.yha.functionalProgramming.entity.Track;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author yha
 * @decription Stream的一些操作示例
 * @create 2017-10-07 17:20
 **/
public class StreamDemo {

    // collect方法用来在流上收集元素，生成一个list，是一个及早求值方法
    public static void testCollect(){
        List<String> collected = Stream.of("a","b","c").collect(Collectors.toList());

        collected.stream().forEach(System.out::println);
    }

    //map操作用来将流中的元素通过指定的方式转换成另一种类型的元素，是一个惰性求值方法
    //其中Lambda表达式必须是Function的一个实例
    public static void testMap(){
        List<String> collected = Stream.of("abc","dFc","maK").map(s -> s.toUpperCase())
                .collect(Collectors.toList());
        collected.stream().forEach(System.out::println);
    }

    //filter操作用来过滤流中的元素，是一个惰性求值方法
    //其中Lambda表达式必须是一个Predicate的实例
    public static void testFilter(){
        List<Integer> collected = Stream.of(134,23,45,12,33).filter(x -> x >= 33)
                .collect(Collectors.toList());
        collected.stream().forEach(System.out::println);
    }
    public static void testFilter2(){
        List<String> collected = Stream.of("1fasd","dad","dsa3","0dfasd","9dad").filter(value -> isDigit(value.charAt(0)))
                .collect(Collectors.toList());
        collected.stream().forEach(System.out::println);
    }

    //flatMap操作用来将stream中的元素转换为Stream，类似map操作，不过方法的返回类型是stream，是惰性求值方法
    public static void testFlatMap(){
        List<Integer> collected = Stream.of(Arrays.asList(1,2),Arrays.asList(3,4))
                .flatMap(numbers -> numbers.stream())
                .collect(Collectors.toList());
        System.out.println(Arrays.asList(1,2,3,4).equals(collected));
    }

    private static boolean isDigit(char c){
        if (c >= '0' && c <= '9')
            return true;
        return false;
    }

    //min和max操作用来找出stream中的最小或最大值，需要传递给它一个Comparator对象
    //返回一个Optional对象
    public static void testMaxAndMin(){
        List<Track> tracks = Arrays.asList(new Track("Bakai", 524),
                new Track("Violets for Your Furs.", 378),
                new Track("Time Was", 451));
        Track longestTrack = tracks.stream()
                .max(Comparator.comparing(track -> track.getLength()))
                .get();
        Track shortestTrack = tracks.stream()
                .min(Comparator.comparing(track -> track.getLength()))
                .get();
        System.out.println(longestTrack.equals(tracks.get(0)));
        System.out.println(shortestTrack.equals(tracks.get(1)));
    }

    //count操作用来统计stream中元素的个数
    public static void testCount(){
        long count = Arrays.asList(1,2,4,5,6,7).stream().count();
        System.out.println(count);
    }

    //reduce操作用来从一组值中生成一个值，具体如何生成根据传入的函数确定，以下是累加求和
    public static void testReduce(){
        int sum = Stream.of(1,2,3)
                .reduce(0, (acc, element) -> acc + element);
        System.out.println(sum);
    }
    public static void testReduce2(){
        BinaryOperator<Integer> accumulator = (acc, element) -> acc + element;
        int sum = accumulator.apply(
                accumulator.apply(
                        accumulator.apply(0,1),2
                ),3);
        System.out.println(sum);
    }



    public static void wrongExample(){
        ActionEvent localEvent = null;
        Button button = new Button();
        button.addActionListener(event -> {
            //无法通过编译
           // localEvent = event;
        });
    }

    //求stream中所有数之和
    public static int addUp(Stream<Integer> numbers){
        return numbers.reduce(0, (acc, element) -> acc + element);
    }

    public static List<String> getNameOrigin(Stream<Artist> artists){
        return artists.flatMap(element -> Stream.of(element.getName(), element.getNationality()))
                .collect(Collectors.toList());
    }

    //统计字符串中小写字符个数
    public static long lowerChars(String string){
        return string.chars().filter(x -> x >= 'a' && x <= 'z').count();
    }

    //获取字符串列表中小写字符最多的字符串
    public static String maxLowerChars(List<String> strings){
        return strings.stream().max(Comparator.comparing(x -> lowerChars(x))).get();
    }

    //使用reduce实现map
    public static <I, O> List<O> map(Stream<I> stream, Function<I, O> mapper){
        return stream.reduce(new ArrayList<O>(), (acc, x) -> {
            // We are copying data from acc to new list instance. It is very inefficient,
            // but contract of Stream.reduce method requires that accumulator function does
            // not mutate its arguments.
            // Stream.collect method could be used to implement more efficient mutable reduction,
            // but this exercise asks to use reduce method.
            List<O> newAcc = new ArrayList<>(acc);
            newAcc.add(mapper.apply(x));
            return newAcc;
        }, (List<O> left, List<O> right) -> {
            // We are copying left to new list to avoid mutating it.
            List<O> newLeft = new ArrayList<>(left);
            newLeft.addAll(right);
            return newLeft;
        });
    }

    //只使用reduce实现filter
    public static <I> List<I> filter(Stream<I> stream, Predicate<I> predicate) {
        List<I> initial = new ArrayList<>();
        return stream.reduce(initial,
                (List<I> acc, I x) -> {
                    if (predicate.test(x)) {
                        // We are copying data from acc to new list instance. It is very inefficient,
                        // but contract of Stream.reduce method requires that accumulator function does
                        // not mutate its arguments.
                        // Stream.collect method could be used to implement more efficient mutable reduction,
                        // but this exercise asks to use reduce method explicitly.
                        List<I> newAcc = new ArrayList<>(acc);
                        newAcc.add(x);
                        return newAcc;
                    } else {
                        return acc;
                    }
                },
                StreamDemo::combineLists);
    }
    private static <I> List<I> combineLists(List<I> left, List<I> right) {
        // We are copying left to new list to avoid mutating it.
        List<I> newLeft = new ArrayList<>(left);
        newLeft.addAll(right);
        return newLeft;
    }


    public static void main(String[] args){

        //testCollect();
        //testMap();
        //testFilter();
        //testFilter2();
        //testFlatMap();
        //testMaxAndMin();
        //testCount();
        //testReduce();
        //testReduce2();
        //integration();
        //System.out.println(addUp(Arrays.asList(1,2,3,4,5).stream()));

        /*Stream<Artist> artists = Arrays.asList(new Artist("abc",null, "ABC"),
                new Artist("def",null, "DEF")).stream();
        getNameOrigin(artists).stream().forEach(System.out::println);*/
        //System.out.println(lowerChars("fasdlAfaLBBBmada"));
        System.out.println(maxLowerChars(Arrays.asList("adfFadD","faiDaLadfLiLL","FFLadasDEag")));

    }

}
