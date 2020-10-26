package 分治法;
/**
 * 
 * 快速排序
 */
public class QuickSort{
    public static void swap(int[] array, int a, int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
    /**
     * 划分
     * 返回划分点的值
     */
    public static int partion(int[] array, int l, int r) {
        int k = array[l];// 以第一个为基准值
        int i = l; int j = r;
        while(i < j){
            while(array[j] >= k && i < j) j--;
            array[i] = array[j];
            while(array[i] <= k && i < j) i++;
            array[j] = array[i];
        }
        array[i] = k;
        return i;
    }
    public static void quickSort(int[] array, int l, int r) {
        if(l < r){
            int m = partion(array, l, r);
            quickSort(array, l, m - 1);
            quickSort(array, m + 1, r);
        }
    }
    public static void main(String[] args) {
        int len = 339333;
        int array[] = new int[len + 1];
        for(int i = 1; i <= len; i++){
            array[i] = i * 17 % 3717;
        }
        // for(int i = 1; i <= len; i++){
        //     System.out.print(array[i] + ",");// = i * 17 % 31;
        // }
        // System.out.print("\n");
        quickSort(array, 1, len);
        // for(int i = 1; i <= len; i++){
        //     System.out.print(array[i] + ",");// = i * 17 % 31;
        // }
    }
}