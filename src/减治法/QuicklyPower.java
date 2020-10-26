package 减治法;
/**
    快速幂
    减治法 减常因子法，对于a^n 来说
    当n为偶数时， a^n = (a^(n/2))^2
    当n为奇数时， a^n = (a^((n-1)/2)^2 * a
 */
public class QuicklyPower{
    /**
     * 快速幂的递归实现 (n >= 0 且为整数)
     */
     static int quicklyPower(int a, int n){
         if(n == 0) return 1;
         if((n & 1) == 1){// 当n为奇数时
            int k = quicklyPower(a, (n - 1) >> 1);
            return k * k * a; 
         }else{// 当n为偶数时
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