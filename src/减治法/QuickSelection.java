package ���η�;

import tools.ListTools;

public class QuickSelection {
	/**
	 * ������������A[l...r]����������ѡ����kС��Ԫ��
	 * @param k
	 * @param A
	 * @param l ������ʵ
	 * @param r ���鳤��
	 * @return ��kС��Ԫ��
	 */
	public static int quickSelection(int k, int[] A, int l, int r) {
		int s = loumtoPartition(A, l, r);
		if(s == k) return A[s];
		else if(k < s) {// ���k�ڻ���ȡ�� �����
			return quickSelection(k, A, l, s - 1);
		}else {
			return quickSelection(k, A, s + 1, r);
		}
	}
	/**
	 * �Ը���A[l..r]�������loumto���֣���������A[l]��Ϊ������л��֣����ֳ������֣�һ��С����һ��
	 * ʱ��: O(r-l)
	 * @param A
	 * @param l
	 * @param r
	 * @return ������ �ֽ����±�
	 */
	public static int loumtoPartition(int A[], int l, int r) {
		int k = A[l];// ��A[l]����׼ֵ
		int s = l;// ��߲��ֵ����һ��Ԫ�ص�ָ��, �ʼû��ֵ
		for(int j = l + 1; j <= r; j++) {
			if(A[j] < k) {// ��� A[j]С�� ��׼ֵ�����ֵ����
				s++;// �������1
				ListTools.swap(A, s, j);
			}
		}
		ListTools.swap(A, s, l);// ����׼ֵ�ŵ����������һ�����������
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
