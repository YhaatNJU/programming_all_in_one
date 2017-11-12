package com.yha.question;

import java.util.ArrayList;

/**
 * @author yha
 * @Description 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * @date 2017/11/12
 */
public class PrintMatrixClokcwise {

    public ArrayList<Integer> printMatrix(int [][] matrix) {
        if (matrix == null || matrix.length == 0)
            return null;

        int left = 0;
        int top = 0;
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;
        int row = 0;
        int col = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while (left <= right && top <= bottom){
            list.add(matrix[row][col]);
            if (row == top && col < right){
                col ++;
                if (col == right){
                    right --;
                }
            }else if (col == right && row < bottom){
                row ++;
                if (row == bottom){
                    bottom --;
                }
            }else if (row == bottom && col > left){
                col --;
                if (col == left){
                    left ++;
                }
            }else if (col == left && row > top){
                row --;
                if (row == top){
                    left++;
                    top++;
                    right--;
                    bottom--;
                    row = top;
                    col = left;
                }
            }
        }

        return list;
    }
}
