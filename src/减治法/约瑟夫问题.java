package 减治法;
/**
 * n个人站成一圈，从1开始，消灭他后方的人，知道只剩一个人
 * 求出幸存者的编号
 * @author Rnti
 *
 */
public class 约瑟夫问题 {
	public static int func(int n) {
		if(n == 1) return 1;
		// 如果是偶数，问题减少一半，只是剩下的人的编号和位置发生了改变，换算一下编号, 那么接下来处理问题的方式就相同了
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
