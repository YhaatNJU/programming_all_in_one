package com.yha.question;

/**
 * @author yha
 * @Description 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * @date 2017/11/12
 */
public class NumberOf1 {

    public int NumberOf1(int n) {
        int i = 0;
        int n2 = n;
        boolean isNegative = n < 0;
        int time = 0;
        while (n2 != 0){
            int temp = n >> 1;
            if ((temp << 1) != n)
                i++;
            n = temp;
            n2 /= 2;
            time++;
        }

        if (isNegative)
            return 32 - time + i;
        return i;
    }

    public static void main(String[] args){

        NumberOf1 number = new NumberOf1();
        System.out.println(number.NumberOf1(-1));
    }
}
