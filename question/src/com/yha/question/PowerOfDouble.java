package com.yha.question;

import java.math.BigDecimal;


/**
 * @author yha
 * @Description 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * @date 2017/11/12
 */
public class PowerOfDouble {
    public double Power(double base, int exponent) {

        if (base == 0)
            return 0;
        if (exponent == 0)
            return 1;

        boolean isNegative = exponent < 0;
        if (isNegative)
            exponent = -exponent;
        double result = 1.0;
        while (exponent > 0){
            result *= base;
            exponent--;
        }

        if (isNegative)
            return 1.0 / result;

        return result;

    }
}
