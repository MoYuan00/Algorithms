package ������;

import java.util.Arrays;

import tools.ListTools;

/**
 * ѡ������
 * ����n��Ԫ�ص�A[1..n]���У��ǽ�������
 * ÿ�ν���iС��Ԫ�طŵ���i����i = 1.����n-1
 * ֱ��i= n-1����
 * @author Rnti
 *
 */
public class SelectionSort {
	/**
	 * ѡ������
	 * @param a ����������A[1...n]
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
		// �����㷨��ȷ��
		Arrays.sort(a, 1, a.length);
		System.out.println(ListTools.arrayToString(a));
	}
}
