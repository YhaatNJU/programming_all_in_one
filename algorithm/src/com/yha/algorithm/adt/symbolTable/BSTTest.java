package com.yha.algorithm.adt.symbolTable;

/**
 * @author yha
 * @decription 二叉搜索树实现的符号表的测试类
 * @create 2017-09-22 23:24
 **/
public class BSTTest {

    public static void main(String[] args){

        BinarySearchTreeST<Integer,String> st = new BinarySearchTreeST<>();

        st.put(3, "M");
        st.put(1, "J");
        st.put(5, "H");
        st.put(4, "O");
        st.show();
        st.delete(2);
        st.show();
        st.delete(3);
        st.show();
        System.out.println(st.rank(5));
        System.out.println(st.floor(0));
        System.out.println(st.floor(1));
        System.out.println(st.ceiling(6));
        System.out.println(st.ceiling(5));
        st.deleteMax();
        st.show();
        st.deleteMin();
        st.show();




    }

}
