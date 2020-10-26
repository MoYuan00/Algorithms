package ���η�;

import tools.ListTools;

public class �������� {
	
	/**
	 * �Ӻ���ǰ��������
	 * ������η�
	 */
	static int count = 0;
	public static void ���η���������(int n, int k, int A[]){
		if(n == k) {
			count++;
			return;
		}
		for(int i = k; i <= n; i++) {//���� ����k-n������ �� k��Ԫ�أ����Է�k...n�У�������һ�����ֵ�������У���Ϊ�����������ɣ� ������123,132 ..
			ListTools.swap(A, i, k);
			���η���������(n, k + 1, A);
			ListTools.swap(A, k, i);
		}
	}
	/**
	 * ��ǰ�����������
	 * ���η�
	 */
	static int count2 = 0;
	public static void ���η���������2(int n, int A[]){
		if(n == 1) {
			count2++;
			return;
		}
		for(int i = 1; i <= n; i++) {// ����1-n������ ���ڵ�n��Ԫ�أ� ���Էŵ� 1....n��
			ListTools.swap(A, i, n);
			���η���������2(n - 1, A);
			ListTools.swap(A, n, i);
		}
	}
	
	static int count3 = 0;
	/**
	 * Heap ���������㷨
	 * Ŀǰ��3����������죨���û��ݣ�
	 */
	public static void HeapPermute(int n, int A[]) {
		if(n == 1) {
			count3++;
			return;
		}else {
			for(int i = 1; i <= n; i++) {
				HeapPermute(n - 1, A);
				if((n&1) == 1) // ���������
					ListTools.swap(A, 1, n);
				else 			// �����ż��
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
		// n = 12ʱ time=3318��3098��3312
//		long time1 = System.currentTimeMillis();
//		���η���������(n, 1, A);
//		System.out.println("���и���" + count);
//		System.out.println((System.currentTimeMillis() - time1));
		
		// n = 12ʱ time=3080��3033��3083
//		long time2 = System.currentTimeMillis();
//		���η���������2(n, A);
//		System.out.println("���и���" + count2);
//		System.out.println((System.currentTimeMillis() - time2));
		
		// n = 12ʱ time=2658��2744��2736��2690
//		long time3 = System.currentTimeMillis();
//		HeapPermute(n, A);
//		System.out.println("���и���" + count3);
//		System.out.println((System.currentTimeMillis() - time3));
	}
}
