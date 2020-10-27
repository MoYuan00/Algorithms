package 减治法;

import tools.ListTools;

public class 生成排列 {
	
	/**
	 * 从后向前生成排列
	 * 逆向减治法
	 */
	static int count = 0;
	public static void 减治法生成排列(int n, int k, int A[]){
		if(n == k) {
			count++;
			return;
		}
		for(int i = k; i <= n; i++) {//反向 对于k-n的排列 第 k个元素，可以放k...n中（会生成一个按字典序的排列，因为最后面的先生成） 先生成123,132 ..
			ListTools.swap(A, i, k);
			减治法生成排列(n, k + 1, A);
			ListTools.swap(A, k, i);
		}
	}
	/**
	 * 从前向后生成排列
	 * 减治法
	 */
	static int count2 = 0;
	public static void 减治法生成排列2(int n, int A[]){
		if(n == 1) {
			count2++;
			return;
		}
		for(int i = 1; i <= n; i++) {// 对于1-n的排列 对于第n个元素， 可以放到 1....n上
			ListTools.swap(A, i, n);
			减治法生成排列2(n - 1, A);
			ListTools.swap(A, n, i);
		}
	}
	
	static int count3 = 0;
	/**
	 * Heap 生成排列算法
	 * 目前在3者中运行最快（不用回溯）
	 */
	public static void HeapPermute(int n, int A[]) {
		if(n == 1) {
			count3++;
			return;
		}else {
			for(int i = 1; i <= n; i++) {
				HeapPermute(n - 1, A);
				if((n&1) == 1) // 如果是奇数
					ListTools.swap(A, 1, n);
				else 			// 如果是偶数
					ListTools.swap(A, i, n);
			}
		}
	}
	public static void main(String[] args) {
		int n = 12;
		int A[] = new int[n + 1];
		for(int i = 1; i <= n; i ++) {
			A[i] = i;
		}
		// n = 12时 time=3318，3098，3312
//		long time1 = System.currentTimeMillis();
//		减治法生成排列(n, 1, A);
//		System.out.println("排列个数" + count);
//		System.out.println((System.currentTimeMillis() - time1));
		
		// n = 12时 time=3080，3033，3083
//		long time2 = System.currentTimeMillis();
//		减治法生成排列2(n, A);
//		System.out.println("排列个数" + count2);
//		System.out.println((System.currentTimeMillis() - time2));
		
		// n = 12时 time=2658，2744，2736，2690
//		long time3 = System.currentTimeMillis();
//		HeapPermute(n, A);
//		System.out.println("排列个数" + count3);
//		System.out.println((System.currentTimeMillis() - time3));
	}
}