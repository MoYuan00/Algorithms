package ��̬�滮;

import tools.ListTools;

/**
 * ��������/�ֻ���������
 * ����: ��n��ߵ�¥����m���ֻ�����¥���������������£����ֻ���n��¥���˶�n-1�㲻�飬���ֻ�����ָ��Ϊn-1
 * �� ����m���ֻ�������£����������������Ҫ���ٴ˲��ܲ����俹ˤ���������ֻ����˾Ͳ����ڲ����ˣ�
 * @author Rnti
 *
 */
public class TestingForPhone {
	
	/**
	 * ����ֻ��һ���ֻ��������ֻ�ܴ�1¥��n¥һ�����ԣ���֤�ֻ������� F(i,1) = i;
	 * �����������ֻ���������� ��1���ֻ��� k¥���� k = 1..2...n
	 * 	1. ���ˣ���ô �ͻص���ֻ��һ���ֻ������, = F(k-1, 1) + 1
	 *  2. û�飬��ֻ��Ҫ����ʣ�µ� k+1...n��,Ҳ�����Բ��Ϊ(n-k)��¥ ������С = F(n-k, 2) + 1; 
	 *  ȡ��2�����(���ֵ ������)��Ȼ��ȡ����������С�ļ�Ϊ���
	 * �������ֻ����ԣ��������ֻ������ͬ�����˾ͻص���2���ֻ������
	 * @param n
	 * @param m
	 * @return
	 */
	public static int func(int N, int M) {
		int counts[][] = new int[N + 1][M + 1];
		for(int i = 1; i <= N; i++)// �����׾ͼ����ֻ��һ���ֻ������
			counts[i][1] = i;
		for(int m = 2; m <= M; m++) { // m���ֻ�
			for(int n = 1; n <= N; n++) {// n��¥
				int min = 999999;
				for(int k = 1; k <= n; k++) {
					int t = ListTools.max(counts[k - 1][m - 1], counts[n - k][m]);
					if(t < min) min = t;
				}
				counts[n][m] = min + 1;// ��Сֵ + 1 ���� ��+1����ȡ��Сֵ��ͬ��
			}
		}
		System.out.println(ListTools.arrayToString(counts));
		return counts[N][M];
	}
	
	public static void main(String[] args) {
		System.out.println(func(32, 4));
		
	}
}
