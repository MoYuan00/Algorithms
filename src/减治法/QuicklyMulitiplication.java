package 减治法;
/**
    减治法
    俄式乘法
    n*m = (n/2) * (2 *m)  n为偶数时
    n*m = ((n - 1)/2) * (2 *m) + m  当n为奇数时
 */
public class QuicklyMulitiplication{
    /**
        俄式乘法
        n,m，计算n*m
     */
    static int QuicklyMuli(int n, int m){
        if(n == 0) return 0;
        if(n == 1) return m;
        if(n == -1) return -m;// 这里处理负数的情况
        if((n & 1) == 1) {// n为奇数时
            return QuicklyMuli((n - 1) >> 1, m << 1) + m;
        } else {// n为偶数
            return QuicklyMuli(n >> 1, m << 1);
        }
    }

    public static void main(String[] args){
        System.out.println(QuicklyMuli(25, 25));
        System.out.println(QuicklyMuli(-27, 5));
        System.out.println(QuicklyMuli(8, -9));
        System.out.println(QuicklyMuli(-25, -3));
        System.out.println(QuicklyMuli(0, 90));
    }
}