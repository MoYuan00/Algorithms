package ���η�;
/**
    ��ʽ�˷�
    ���ü��η� ���е� �������ӵ�˼�� ÿ�ν����� ��С��һ��
    �� ����
    n*m = (n/2) * (2 *m)  n Ϊż��ʱ
    n*m = ((n - 1)/2) * (2 *m) + m n Ϊ����ʱ
 */
public class QuicklyMulitiplication{
    /**
        ��ʽ�˷��ĵݹ�ʵ��
        n,m��Ϊ����
     */
    static int QuicklyMuli(int n, int m){
        if(n == 0) return 0;
        if(n == -1) return -m;// �� nΪ����ʱ�� λ������ ���ڸ�����˵ �������λΪ1����ԶҲ������0
       // �� >> �滻�� >>> �޷�������Ҳ��(�ͺ����)�����λ��0 ��
        if((n & 1) == 1) {// Ϊ ����
            return QuicklyMuli((n - 1) >> 1, m << 1) + m;    
        } else {// Ϊż��
            return QuicklyMuli(n >> 1, m << 1);
        }
    }

    public static void main(String[] args){
        System.out.println(QuicklyMuli(25, 25));
        System.out.println(QuicklyMuli(1, 5));
        System.out.println(QuicklyMuli(8, 9));
        System.out.println(QuicklyMuli(-80, -3));
        System.out.println(QuicklyMuli(0, 90));
    }


}