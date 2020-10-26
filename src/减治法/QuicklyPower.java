package ���η�;
/**
    ������
    ���η� �������ӷ�������a^n ��˵
    ��nΪż��ʱ�� a^n = (a^(n/2))^2
    ��nΪ����ʱ�� a^n = (a^((n-1)/2)^2 * a
 */
public class QuicklyPower{
    /**
     * �����ݵĵݹ�ʵ�� (n >= 0 ��Ϊ����)
     */
     static int quicklyPower(int a, int n){
         if(n == 0) return 1;
         if((n & 1) == 1){// ��nΪ����ʱ
            int k = quicklyPower(a, (n - 1) >> 1);
            return k * k * a; 
         }else{// ��nΪż��ʱ
            int k = quicklyPower(a, n >> 1);
            return k * k; 
         }
     }

     public static void main(String[] args){
        System.out.println(quicklyPower(3, 3));
        System.out.println(quicklyPower(2, 10));
        System.out.println(quicklyPower(8, 0));
        System.out.println(quicklyPower(11, 8));
     }

 }