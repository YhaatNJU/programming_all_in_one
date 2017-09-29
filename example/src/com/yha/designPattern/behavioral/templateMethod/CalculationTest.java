package com.yha.designPattern.behavioral.templateMethod;

/**
 * @author yha
 * @decription
 * @create 2017-09-26 17:57
 **/
public class CalculationTest {

    public static void main(String[] args){
        Calculation calculation = new Multiply(5 , 2);

        System.out.println(calculation.calculate());
    }

}
