package com.yha.designPattern.behavioral.templateMethod;

/**
 * @author yha
 * @decription 加法实现类
 * @create 2017-09-26 17:54
 **/
public class Plus extends Calculation {

    public Plus(int firstNumber, int secondNumber) {
        super(firstNumber, secondNumber);
    }

    @Override
    public METHOD getMethod() {
        return METHOD.ADD;
    }
}
