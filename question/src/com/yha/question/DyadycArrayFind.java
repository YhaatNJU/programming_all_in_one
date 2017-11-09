package com.yha.question;

/**
 * @author yha
 * @Description 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @date 2017/11/9
 */
public class DyadycArrayFind {

    public boolean find(int target, int [][] array) {
        int row = array.length;
        int col = array[0].length;
        int curRow = row - 1;
        int curCol = 0;
        while (curRow >= 0 && curCol < col){
            int cur = array[curRow][curCol];

            if (target == cur)
                return true;

            if (target > cur){
                curCol ++;
            }else
                curRow --;
        }

        return false;
    }
}
