package com.yha.designPattern.behavioral.strategy;

/**
 * @author yha
 * @decription 计算策略的加法算法
 * @create 2017-09-26 17:30
 **/
public class Plus implements ICalculation {

    @Override
    public int calculate(int first, int second) {
        return first + second;
    }
}
