package 蛮力法;

import java.util.Arrays;

import tools.ListTools;

/**
 * 选择排序
 * 对于n个元素的A[1..n]进行，非降序排序，
 * 每次将第i小的元素放到第i个，i = 1.。。n-1
 * 直到i= n-1结束
 * @author Rnti
 *
 */
public class SelectionSort {
	/**
	 * 选择排序
	 * @param a 待排序数组A[1...n]
	 */
	public static void selectionSort(int a[]) {
		int n = a.length - 1;
		for(int i = 1; i <= n - 1; i++) {
			a[0] = i;
			for(int j = i + 1; j <= n; j++) 
				if(a[j] < a[a[0]]) a[0] = j;
			ListTools.swap(a, i, a[0]);
		}
	}
	public static void main(String[] args) {
		int a[] = ListTools.getRandomsNumbers(100, 1, 45);
		System.out.println(ListTools.arrayToString(a));
		selectionSort(a);
		System.out.println(ListTools.arrayToString(a));
		// 检验算法正确性
		Arrays.sort(a, 1, a.length);
		System.out.println(ListTools.arrayToString(a));
	}
}
