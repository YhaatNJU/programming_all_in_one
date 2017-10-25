package com.yha.question;

/**
 * @author yha
 * @decription 将一个int数反转，如果溢出则返回0
 * @create 2017-10-25 20:28
 **/
public class ReverseInt {


    public static int reverse(int source){

        if (source == 0)
            return 0;

        int result = 0;
        boolean isNegative = false;
        if (source < 0){
            source = -source;
            isNegative = true;
        }

        while (source > 0){
            int temp = result;
            for (int i = 1; i <= 9; i++){
                result += temp;
                if (result < 0)
                    return 0;
            }

            result += source % 10;
            if (result < 0)
                return 0;

            source /= 10;
        }

        if (isNegative)
            return -result;

        return result;
    }

    public static void main(String[] args){

        System.out.println(reverse(1234123419));
    }
}
