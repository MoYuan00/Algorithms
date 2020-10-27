package 减治法;

import tools.ListTools;

public class QuickSelection {
	/**
	 * 给定无序数组A[l...r]，在数组中选出第k小的元素
	 * @param k
	 * @param A
	 * @param l 数组其实
	 * @param r 数组长度
	 * @return 第k小的元素
	 */
	public static int quickSelection(int k, int[] A, int l, int r) {
		int s = loumtoPartition(A, l, r);
		if(s == k) return A[s];
		else if(k < s) {// 如果k在划分取间 的左边
			return quickSelection(k, A, l, s - 1);
		}else {
			return quickSelection(k, A, s + 1, r);
		}
	}
	/**
	 * 对给定A[l..r]数组进行loumto划分，将数组用A[l]作为中轴进行划分，划分成两部分，一边小于另一边
	 * 时间: O(r-l)
	 * @param A
	 * @param l
	 * @param r
	 * @return 两部分 分界点的下标
	 */
	public static int loumtoPartition(int A[], int l, int r) {
		int k = A[l];// 用A[l]做基准值
		int s = l;// 左边部分的最后一个元素的指针, 最开始没有值
		for(int j = l + 1; j <= r; j++) {
			if(A[j] < k) {// 如果 A[j]小于 基准值，划分到左边
				s++;// 左区间加1
				ListTools.swap(A, s, j);
			}
		}
		ListTools.swap(A, s, l);// 将基准值放到左区间最后一个，划分完成
		return s;
	}
	public static void main(String[] args) {
		int k = 6;
		int n = 40;
		int A[] = ListTools.getRandomsNumbers(n, 3, 40);
		System.out.println(ListTools.arrayToString(A));
		System.out.println(quickSelection(k, A, 1, n));
		System.out.println(ListTools.arrayToString(A));
	}
}
