package tools;

import java.util.Arrays;

/**
 * 
 * @author Rnti
 *
 */
public class ListTools {
	
	/**
	 * ��ȡ ����Ϊn��һ�������������������A
	 * ע�⣺��Ч���ݷ�ΧΪA[1..n]
	 * @param n ����
	 * @param floor ��Сֵ
	 * @param cell ���ֵ
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
	 * ���� ����array �±�Ϊa��b��Ԫ��
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
	 * ������ת���ɿ��ӻ����ַ���
	 * @param array
	 * @return
	 */
	public static String arrayToString(int[] array) {
		return Arrays.toString(array);
	}
	/**
	 * ������ת���ɿ��ӻ����ַ���
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
	 * ����2�����е����ֵ
	 * @param a
	 * @param b
	 * @return
	 */
	public static int max(int a, int b) {
		return a > b ? a : b;
	}
	/**
	 * ����3�����е����ֵ
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	public static int max(int a, int b, int c) {
		return max(a, max(b, c));
	}
	/**
	 * ����2�����е���Сֵ
	 * @param a
	 * @param b
	 * @return
	 */
	public static int min(int a, int b) {
		return a > b ? b : a;
	}
	/**
	 * ����3�����е���Сֵ
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	public static int min(int a, int b, int c) {
		return min(a, min(b, c));
	}
}
