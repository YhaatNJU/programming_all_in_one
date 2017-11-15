package com.yha.question;

import java.util.ArrayList;

/**
 * @author yha
 * @Description 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * @date 2017/11/12
 */
public class PrintMatrixClockwise {

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
            if (row < top || row > bottom || col < left || col > right)
                break;
            list.add(matrix[row][col]);
            if (row == top && col < right){
                col ++;
                if (top == bottom && col == right){
                    list.add(matrix[row][col]);
                    break;
                }
            }else if (col == right && row < bottom){
                row ++;
                if (left == right && row == bottom){
                    list.add(matrix[row][col]);
                    break;
                }
            }else if (row == bottom && col > left){
                col --;
                if (top == bottom && col == left){
                    list.add(matrix[row][col]);
                    break;
                }
            }else if (col == left && row > top){
                row --;
                if (row == top){
                    if (left == right)
                        break;
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

    public static void main(String[] args){
        int[][] matrix = {
                {1,  2,  3,  4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14,  15,  16}};

        matrix = new int[1000][100];
        int temp = 1;
        for (int i = 0; i < 1000; i++){
            for (int j = 0; j < 100; j++)
                matrix[i][j] = ++temp;
        }

        PrintMatrixClockwise print = new PrintMatrixClockwise();
        for (int i : print.printMatrix(matrix)){
            System.out.print(i + ",");
        }

    }
}
