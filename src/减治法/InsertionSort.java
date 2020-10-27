package 减治法;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 
 * 插入排序
 * 减治法的应用
 * 对于n 个元素的数组A[1...n]，
 * 假设前n-1个已经有序，接下来只需将第n个插入到 1-n中第一个比A[n]大/小（正确）的位置上
 * n=1时，有序退出
 */
public class InsertionSort{
    /**
     * 插入排序(递归版)
     */
    public static void insertionSort(int [] array, int n) {
        if(n == 1) return;
        else{
            insertionSort(array, n - 1);// 对前 n-1个排序
            // 将第n个插入到正确位置
            int i = n - 1;
            array[0] = array[n]; // 将 多余的0 号下标，当作哨兵，防止越界，也做了临时变量
            while(array[i] > array[0]){
                array[i + 1] = array[i];
                i--;
            }
            array[i + 1] = array[0];// 放到正确位置上
        }
    }

    public static void main(String[] args) {
        int len = 33;
        int array[] = new int[len + 1];
        for(int i = 1; i <= len; i++){
            array[i] = i * 17 % 31;
        }
        for(int i = 1; i <= len; i++){
            System.out.print(array[i] + ",");// = i * 17 % 31;
        }
        System.out.print("\n");
        insertionSort(array, len);
        for(int i = 1; i <= len; i++){
            System.out.print(array[i] + ",");// = i * 17 % 31;
        }
    } 
 }