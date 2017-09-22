package com.yha.algorithm.adt.symbolTable;

/**
 * @author yha
 * @decription
 * @create 2017-09-22 18:39
 **/
public class STTest {

    public static void main(String[] args){

        BinarySearchTreeST<Integer, String> table = new BinarySearchTreeST<>();
        table.put(1, "A");
        table.put(5, "B");
        table.put(3, "C");
        table.show();
        System.out.println("size:" + table.size());
        System.out.println();

        table.put(3, "D");
        table.show();
        System.out.println("size:" + table.size());
        System.out.println(table.get(3));
        table.deleteMax();
        table.show();
        table.put(4,"M");
        table.show();
        table.put(7, "J");
        table.put(8, "Q");
        System.out.println(table.floor(6));
        System.out.println(table.ceiling(6));
        System.out.println(table.floor(0));
        System.out.println(table.floor(1));
        System.out.println(table.ceiling(8));
        System.out.println(table.ceiling(9));


    }

}
