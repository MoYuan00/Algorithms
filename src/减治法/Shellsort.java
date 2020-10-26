package ���η�;
/**
 * 
 * Shellsort��ϣ������
 * ����������Ż�
 * �������� �����Ÿ��Ӷ�ΪO(n)��������������ʱ�����ҵ����ݻ�������ʱ�����ӶȻ���n������n
 * Shell������ �����˶�β�������ÿ�β���������� �����ж����ø�����
 * ��˼���� ѡ��ŵ�ɲ������У���1��β���� ���Ų���Ϊ121��40��13��4��1����
 * ÿ�ζ���Щ�����������н��в�������
 */
public class Shellsort{
    /**
     * �Ը����������в�������
     * d:���� n:���鳤�ȣ�array:����
     */
    public static void stepInsertionSort(int d, int n, int[]array) {
        for(int i = d, j = 0; i <= n; i += d){
            array[0] = array[i];
            j = i - d;
            while(array[j] > array[0]){
                array[j + d] = array[j];
                j = j - d;
            }
            array[j + d] = array[0];
        }
    }
    /**
     * ϣ������
     */
    public static void shellsort(int[] array) {
        int n = array.length - 1;
        int[] ds = {0, 27904, 9301, 3100, 1033, 364, 121, 40, 13, 4, 1};
        for(int i = 1, dn = ds.length - 1; i <= dn; i++){
            System.out.println(ds[i]);
            stepInsertionSort(ds[i], n, array);
        }
    }
    public static void main(String[] args) {
        int len = 3339333;
        int array[] = new int[len + 1];
        for(int i = 1; i <= len; i++){
            array[i] = i * 17 % 3717;
        }
        // for(int i = 1; i <= len; i++){
        //     System.out.print(array[i] + ",");// = i * 17 % 31;
        // }
        // System.out.print("\n");
        shellsort(array);
        // for(int i = 1; i <= len; i++){
        //     System.out.print(array[i] + ",");// = i * 17 % 31;
        // }
    }
} 
