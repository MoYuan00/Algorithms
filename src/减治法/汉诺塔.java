package ���η�;

/**
 * �������� A B C3�����ӣ�A�� ����n�����ӣ����µ����Ӵ������棬
 * ��ν�A�ϵ������ƶ���C�����ƶ����̺ͽ��ʼ�ձ�֤С�����ڴ����Ϸ�
 * ���η���
 * �������n��ĺ�ŵ����ǰn-1���Ѿ��� A�ŵ���B �� C���� ��
 * ��ô������ ֻ�轫A[n] �� A �ŵ� C 
 * Ȼ�� ǰ n-1 �� �� B �ŵ� C ���� ��A ���� ��
 * @author Rnti
 *
 */
public class ��ŵ�� {
	static int count = 0;// reword step of move in put
	public static void func(int n, char source, char temp, char target) {
		if(n == 0) {
			return;
		}
		// �� ǰ n-1 ��ȫ�� �� a move to b, c is used temp
		func(n - 1, source, target, temp);
		count ++;
		System.out.println("��" + n + " ��" + source +"�ŵ�" + target);
		// move 1 to n-1 from B to C, A is used temp
		func(n - 1, temp, source, target);
		
	}
	
	public static void main(String[] args) {
		func(1, 'A', 'B', 'C');
		System.out.println("����:" + count + "��");
	}
}
