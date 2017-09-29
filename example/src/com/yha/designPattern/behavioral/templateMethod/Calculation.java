package com.yha.designPattern.behavioral.templateMethod;

/**
 * @author yha
 * @decription 计算基类，包含一些未实现的抽象方法，但是本身的逻辑包括对这些抽象方法的调用。
 * 子类实现后就可以正常使用了
 * @create 2017-09-26 17:42
 **/
public abstract class Calculation {

    protected enum METHOD{ADD, MINUS, MULTIPLY, DIVIDE}

    private int firstNumber;
    private int secondNumber;

    public Calculation(int firstNumber, int secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }


    public int calculate(){
        switch (getMethod()){
            case ADD:
                return firstNumber + secondNumber;
            case MINUS:
                return firstNumber - secondNumber;
            case MULTIPLY:
                return firstNumber * secondNumber;
            case DIVIDE:
                if (secondNumber == 0)
                    throw new Error("The divisor can't be zero.");
                return firstNumber / secondNumber;
            default:
                throw new Error("Wrong type of calculation method.");
        }

    }


    public abstract METHOD getMethod();
}
