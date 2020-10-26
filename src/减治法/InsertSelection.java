package 减治法;

import java.util.Arrays;

import tools.ListTools;
import 分治法.MergeSort;
import 分治法.QuickSort;

/**
 * 插值查找
 * @author Rnti
 *
 */
public class InsertSelection {
	
	/**
	 * 获取 下一个可能的下标, 可能会超过区间值（l..r）
	 * 这里假设A[l...r]的元素是线性有序的
	 * @param v
	 * @param A
	 * @param l
	 * @param r
	 * @return
	 */
	public static int getIndex(int v, int A[], int l, int r) {
		return (int)(((double)((r - l)) / (double)(A[r] - A[l])) * (v - A[l]) + l);
	}
	/**
	 * 对非降序数组 A[l...r]进行查找，查找值为v的下标，如果有返回，没有返回-1
	 * @param k
	 * @param A
	 * @param l
	 * @param r
	 * @return
	 */
	public static int insertSelection(int v, int A[], int l, int r) {
		if(l > r) return -1;// 数组A中不包含v
		int x = getIndex(v, A, l, r);
		if(x < l || x > r) return -1;// 防止x超过区间，如果超过区间表面没有 这个值
		if(A[x] == v) return x;
		if(v < A[x]) // 如果x大了， 表面v值在x左边
			return insertSelection(v, A, l, x - 1);
		else // 如果x小了， 表面v值在x右边
			return insertSelection(v, A, x + 1, r);
	}
	
	public static void main(String[] args) {
		int n = 441100;
		int A[] = ListTools.getRandomsNumbers(n, 3, 46431);
		QuickSort.quickSort(A, 1, n);// 排序
		for(int k = 323; k <= n; ) {
			int x = insertSelection(k, A, 1, n);
			if(x > 0)
				System.out.println("x: " + x + " A[x]:" + A[x]);// 查找
			int y = Arrays.binarySearch(A, k);
			if(y > 0)
				System.out.println("y: " + y + " A[y]:" + A[y]);// 查找
			System.out.println("----");
			k = k + k/2;
		}
		
	}
}
