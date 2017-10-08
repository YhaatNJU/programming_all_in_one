package com.yha.functionalProgramming;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

/**
 * @author yha
 * @decription Java中Lambda表达式的几种写法
 * @create 2017-10-07 16:11
 **/
public class StyleOfLambda {

    //不含参数，使用()表示
    Runnable noArguments = () -> System.out.println("Hello World!");
    Runnable noArguments2 = new Runnable() {
        @Override
        public void run() {
            System.out.println("Hello World!");
        }
    };

    //含一个参数，可以省略参数的括号
    ActionListener oneArgument = event -> System.out.println("button clicked.");
    ActionListener oneArgument2 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("button clicked.");
        }
    };

    //包含多条语句，需要用{}扩起来
    Runnable multiStatement = () -> {
        System.out.print("Hello");
        System.out.println(" World!");
    };
    Runnable muultStatement2 = new Runnable() {
        @Override
        public void run() {
            System.out.print("Hello");
            System.out.println(" World!");
        }
    };

    //包含多个参数，没有参数类型，用英文逗号分隔，
    BinaryOperator<Long> add = (x, y) -> x + y;
    BinaryOperator<Long> add2 = new BinaryOperator<Long>() {
        @Override
        public Long apply(Long aLong, Long aLong2) {
            return aLong + aLong2;
        }
    };

    //包含多个参数，指定了参数类型，用英文逗号分隔
    BinaryOperator<Long> addExplicit = (Long x, Long y) -> x + y;
    BinaryOperator<Long> addExplicit2 = new BinaryOperator<Long>() {
        @Override
        public Long apply(Long aLong, Long aLong2) {
            return aLong + aLong2;
        }
    };

    public static void main(String[] args){
        StyleOfLambda lambda = new StyleOfLambda();
        //new Thread(lambda.noArguments).start();
        //new Thread(lambda.multiStatement).start();
        //System.out.println(lambda.add.apply(111L,222L));
        System.out.println(lambda.addExplicit.apply(111L,222L));


    }

}
