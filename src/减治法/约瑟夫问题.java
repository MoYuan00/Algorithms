package ���η�;
/**
 * n����վ��һȦ����1��ʼ���������󷽵��ˣ�֪��ֻʣһ����
 * ����Ҵ��ߵı��
 * @author Rnti
 *
 */
public class Լɪ������ {
	public static int func(int n) {
		if(n == 1) return 1;
		// �����ż�����������һ�룬ֻ��ʣ�µ��˵ı�ź�λ�÷����˸ı䣬����һ�±��, ��ô��������������ķ�ʽ����ͬ��
		if((n & 1) == 0) {
			return 2 * func(n >> 1) - 1;
		}else {
			return 2 * func(n >> 1) + 1;
		}
	}
	public static void main(String[] args) {
		System.out.println(func(2));
	}
}
