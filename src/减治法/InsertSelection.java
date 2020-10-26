package ���η�;

import java.util.Arrays;

import tools.ListTools;
import ���η�.MergeSort;
import ���η�.QuickSort;

/**
 * ��ֵ����
 * @author Rnti
 *
 */
public class InsertSelection {
	
	/**
	 * ��ȡ ��һ�����ܵ��±�, ���ܻᳬ������ֵ��l..r��
	 * �������A[l...r]��Ԫ�������������
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
	 * �Էǽ������� A[l...r]���в��ң�����ֵΪv���±꣬����з��أ�û�з���-1
	 * @param k
	 * @param A
	 * @param l
	 * @param r
	 * @return
	 */
	public static int insertSelection(int v, int A[], int l, int r) {
		if(l > r) return -1;// ����A�в�����v
		int x = getIndex(v, A, l, r);
		if(x < l || x > r) return -1;// ��ֹx�������䣬��������������û�� ���ֵ
		if(A[x] == v) return x;
		if(v < A[x]) // ���x���ˣ� ����vֵ��x���
			return insertSelection(v, A, l, x - 1);
		else // ���xС�ˣ� ����vֵ��x�ұ�
			return insertSelection(v, A, x + 1, r);
	}
	
	public static void main(String[] args) {
		int n = 441100;
		int A[] = ListTools.getRandomsNumbers(n, 3, 46431);
		QuickSort.quickSort(A, 1, n);// ����
		for(int k = 323; k <= n; ) {
			int x = insertSelection(k, A, 1, n);
			if(x > 0)
				System.out.println("x: " + x + " A[x]:" + A[x]);// ����
			int y = Arrays.binarySearch(A, k);
			if(y > 0)
				System.out.println("y: " + y + " A[y]:" + A[y]);// ����
			System.out.println("----");
			k = k + k/2;
		}
		
	}
}
