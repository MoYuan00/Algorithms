package tools;

import java.util.Arrays;

/**
 * 
 * @author Rnti
 *
 */
public class ListTools {
	
	/**
	 * 获取 长度为n的一个乱序随机正整数数组A
	 * 注意：有效数据范围为A[1..n]
	 * @param n 长度
	 * @param floor 最小值
	 * @param cell 最大值
	 * @return 
	 */
	public static int[] getRandomsNumbers(int n, int floor, int cell) {
		int a[] = new int[n + 1];
		for(int i = 1; i <= n; i++) {
			a[i] = (int)(Math.random()* (cell - floor + 1)) + floor;
		}
		return a;
	}
	/**
	 * 交换 数组array 下标为a和b的元素
	 * @param array
	 * @param a
	 * @param b
	 */
	public static void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	/**
	 * 将数组转换成可视化的字符串
	 * @param array
	 * @return
	 */
	public static String arrayToString(int[] array) {
		return Arrays.toString(array);
	}
	/**
	 * 将数组转换成可视化的字符串
	 * @param array
	 * @return
	 */
	public static String arrayToString(int[][] array) {
		String s = "";
		for(int i = 0; i < array.length; i++) {
			s += Arrays.toString(array[i]) + "\n";
		}
		return s;
	}
	/**
	 * 返回2个数中的最大值
	 * @param a
	 * @param b
	 * @return
	 */
	public static int max(int a, int b) {
		return a > b ? a : b;
	}
	/**
	 * 返回3个数中的最大值
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	public static int max(int a, int b, int c) {
		return max(a, max(b, c));
	}
	/**
	 * 返回2个数中的最小值
	 * @param a
	 * @param b
	 * @return
	 */
	public static int min(int a, int b) {
		return a > b ? b : a;
	}
	/**
	 * 返回3个数中的最小值
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	public static int min(int a, int b, int c) {
		return min(a, min(b, c));
	}
}
