package com.yha.question;

/**
 * @author www
 * @Description: 用最少的数量的纸币数合成目标金额，输出纸币数量
 * @create 2017/10/26
 */
public class MinAmountBanknote {

    private static int[] banknotes = {2,4,5};

    private static final int MAX_INT = 1999999999;




    public static int minAmount(int target){

        int[] min = new int[target + 1];
        for (int i = 0; i < min.length; i++)
            min[i] = MAX_INT;
        min[0] = 0;

        for (int i = 1; i <= target; i++){
            for (int j = 0; j < banknotes.length; j++){
                int banknote = banknotes[j];
                if (banknotes[j] <= i && min[i-banknote] + 1 < min[i])
                    min[i] = min[i-banknote] + 1;
            }
        }

        return min[target] == MAX_INT ? -1 : min[target];


    }

    public static void main(String[] args){

        System.out.println(minAmount(111));
    }

}
