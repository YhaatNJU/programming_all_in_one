package com.yha.question;

/**
 * @author yha
 * @Description 把只包含因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * @date 2017/11/16
 */
public class UglyNumber {

    private static int[] factors = {2, 3, 4, 5};

    public int GetUglyNumber_Solution(int index) {
        if (index < 1)
            return 0;
        if (index <= 5)
            return index;

        int[] numbers = new int[index];
        numbers[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        for (int i = 1; i < index; i++){
            int min = Math.min(numbers[i2] * 2, Math.min(numbers[i3] * 3, numbers[i5] * 5));
            numbers[i] = min;
            if (min == numbers[i2] * 2)
                i2++;
            if (min == numbers[i3] * 3)
                i3++;
            if (min == numbers[i5] * 5)
                i5++;
        }
        return numbers[index-1];
    }

    public static void main(String[] args){

        UglyNumber number = new UglyNumber();
        for (int i = 1; i < 20; i++){
            System.out.println(number.GetUglyNumber_Solution(i));
        }
    }
}
