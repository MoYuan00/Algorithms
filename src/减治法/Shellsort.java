package 减治法;
/**
 * 
 * Shellsort（希尔排序）
 * 插入排序的优化
 * 插入排序 的最优复杂度为O(n)，（当数据有序时），且当数据基本有序时，复杂度会由n方趋向n
 * Shell排序是 进行了多次插入排序，每次插入排序过后 新序列都会变得更有序
 * 其思想是 选定诺干步长序列（以1结尾即可 最优步长为121，40，13，4，1），
 * 每次对这些步长的子序列进行插入排序
 */
public class Shellsort{
    /**
     * 对给定步长进行插入排序
     * d:步长 n:数组长度，array:数组
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
     * 希尔排序
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
