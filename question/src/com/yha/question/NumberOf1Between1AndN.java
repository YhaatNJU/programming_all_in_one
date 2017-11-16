package com.yha.question;

/**
 * @author yha
 * @Description 统计从1到n之间所有的数中1出现的次数
 * @date 2017/11/15
 */
public class NumberOf1Between1AndN {

    public int NumberOf1Between1AndN_Solution(int n) {
        return numberOfX(n, 1);
    }

    /**
     * 链接：https://www.nowcoder.com/questionTerminal/bd7f978302044eee894445e244c7eee6
     * 来源：牛客网

     * X的数目
     * 这里的  X∈[1,9] ，因为  X=0  不符合下列规律，需要单独计算。
     * 首先要知道以下的规律：
     * 从 1 至 10，在它们的个位数中，任意的 X 都出现了 1 次。
     * 从 1 至 100，在它们的十位数中，任意的 X 都出现了 10 次。
     * 从 1 至 1000，在它们的百位数中，任意的 X 都出现了 100 次。
     * 依此类推，从 1 至  10 i ，在它们的左数第二位（右数第  i  位）中，任意的 X 都出现了  10 i−1  次。
     * @param n
     * @param x
     * @return
     */
    private int numberOfX(int n, int x){
        if (n < 0 || x < 1 || x > 9)
            return 0;

        int high, low, cur, tmp, i = 1;
        high = n;
        int total = 0;
        while (high != 0){
            high = n / (int)Math.pow(10, i); //获取第i位的高位
            tmp = n % (int)Math.pow(10, i);
            cur = tmp / (int)Math.pow(10, i-1); //获取第i位
            low = tmp % (int)Math.pow(10, i-1); //获取第i位的低位
            if (cur == x){
                total += high * (int)Math.pow(10, i-1) + low + 1; //比如2593中百位上5出现的次数是2 * 100 + 93 + 1  (i=3)
            }else if (cur < x){
                total += high * (int)Math.pow(10, i-1); //比如2493中百位上5出现的次数是2 * 100  (i=3)
            }else {
                total += (high + 1) * (int)Math.pow(10, i-1); //比如2693中百位上5出现的次数是(2 + 1) * 100 (i=3);
            }
            i++;

        }

        return total;
    }

    public static void main(String[] args){

        NumberOf1Between1AndN number = new NumberOf1Between1AndN();
        System.out.println(number.numberOfX(21,1));
    }

}
