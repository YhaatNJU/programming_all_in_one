package com.yha.designPattern.behavioral.templateMethod;

/**
 * @author yha
 * @decription 乘法实现类
 * @create 2017-09-26 17:56
 **/
public class Multiply extends Calculation {

    public Multiply(int firstNumber, int secondNumber) {
        super(firstNumber, secondNumber);
    }

    @Override
    public METHOD getMethod() {
        return METHOD.MULTIPLY;
    }
}
