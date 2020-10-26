package ���η�;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 
 * ��������
 * ���η���Ӧ��
 * ����n ��Ԫ�ص�����A[1...n]��
 * ����ǰn-1���Ѿ����򣬽�����ֻ�轫��n�����뵽 1-n�е�һ����A[n]��/С����ȷ����λ����
 * n=1ʱ�������˳�
 */
public class InsertionSort{
    /**
     * ��������(�ݹ��)
     */
    public static void insertionSort(int [] array, int n) {
        if(n == 1) return;
        else{
            insertionSort(array, n - 1);// ��ǰ n-1������
            // ����n�����뵽��ȷλ��
            int i = n - 1;
            array[0] = array[n]; // �� �����0 ���±꣬�����ڱ�����ֹԽ�磬Ҳ������ʱ����
            while(array[i] > array[0]){
                array[i + 1] = array[i];
                i--;
            }
            array[i + 1] = array[0];// �ŵ���ȷλ����
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