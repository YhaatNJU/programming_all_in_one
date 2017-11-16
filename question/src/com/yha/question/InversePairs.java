package com.yha.question;

/**
 * @author yha
 * @Description 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 * @date 2017/11/16
 */
public class InversePairs {

    private static int count = 0;
    private static int[] aux;
    public int InversePairs(int [] array) {
        if (array == null || array.length < 2)
            return 0;
        count = 0;
        aux = new int[array.length];
        mergeSort(array, 0, array.length - 1);
        return count/2%1000000007;
    }




    private void mergeSort(int[] array, int low, int high){
        if (low >= high)
            return;
        int mid = low + (high - low) / 2;
        mergeSort(array, low, mid);
        mergeSort(array, mid + 1, high);
        merge(array, low, mid, high);
    }

    private void merge(int[] array, int low, int mid, int high){

        for (int i = low; i <= high; i++)
            aux[i] = array[i];

        int i = low, j = mid + 1;
        for (int k = low; k <= high; k++){
            if (i > mid){
                array[k] = aux[j++];
            }else if (j > high){
                array[k] = aux[i];
                count += k - i;
                i++;
            }else if (aux[i] > aux[j]){
                array[k] = aux[j];
                count += j - k;
                j++;
            }else {
                array[k] = aux[i];
                count += k - i;
                i++;
            }
        }
    }


    public static void main(String[] args){
        InversePairs pairs = new InversePairs();
        int[] array = {1,2,3,4,5,6,7,0};
        System.out.println(pairs.InversePairs(array));
        for (int i : array)
            System.out.print(i + " ");
    }

}
