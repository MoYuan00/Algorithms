package 减治法;
/**
    俄式乘法
    利用减治法 其中的 减常因子的思想 每次将问题 减小到一半
    如 对于
    n*m = (n/2) * (2 *m)  n 为偶数时
    n*m = ((n - 1)/2) * (2 *m) + m n 为奇数时
 */
public class QuicklyMulitiplication{
    /**
        俄式乘法的递归实现
        n,m均为整数
     */
    static int QuicklyMuli(int n, int m){
        if(n == 0) return 0;
        if(n == -1) return -m;// 当 n为负数时， 位移运算 对于负数来说 由于最高位为1，永远也到不了0
       // 将 >> 替换成 >>> 无符号右移也可(就很奇怪)（最高位补0 ）
        if((n & 1) == 1) {// 为 奇数
            return QuicklyMuli((n - 1) >> 1, m << 1) + m;    
        } else {// 为偶数
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