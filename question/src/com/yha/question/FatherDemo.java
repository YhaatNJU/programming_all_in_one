package com.yha.question;

/**
 * @author yha
 * @Description
 * @date 2017/11/13
 */
public class FatherDemo {

    public int get(){
        return 5;
    }

    public static void main(String[] args){

        FatherDemo demo = new FatherDemo(){
            @Override
            public int get(){
                return 6;
            }

            public int add(){
                return 234;
            }
        };

        System.out.println(demo.get());
    }
}
