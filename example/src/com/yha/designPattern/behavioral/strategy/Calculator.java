package com.yha.designPattern.behavioral.strategy;

/**
 * @author yha
 * @decription 计算器（上下文类）
 * @create 2017-09-26 17:33
 **/
public class Calculator {

    private ICalculation calculation;

    public int calculate(int a, int b){
        return calculation.calculate(a, b);
    }

    public void setCalculation(ICalculation calculation) {
        this.calculation = calculation;
    }

    public static void main(String[] args){

        int a = 2, b = 5;

        Calculator calculator = new Calculator();
        ICalculation calculation = new Plus();
        calculator.setCalculation(calculation);
        System.out.println(calculator.calculate(a, b));

        calculation = new Minus();
        calculator.setCalculation(calculation);
        System.out.println(calculator.calculate(a, b));

        calculation = new Multiply();
        calculator.setCalculation(calculation);
        System.out.println(calculator.calculate(a, b));

    }
}
