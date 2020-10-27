package 动态规划;

import tools.ListTools;

/**
 * 仪器测试/手机测试问题
 * 描述: 有n层高的楼，有m部手机，在楼层上自由落体向下，若手机在n层楼碎了而n-1层不碎，则手机质量指数为n-1
 * 则 给定m部手机的情况下，在最差的情况下至少要多少此才能测数其抗摔能力。（手机碎了就不能在测试了）
 * @author Rnti
 *
 */
public class TestingForPhone {
	
	/**
	 * 对于只有一个手机的情况，只能从1楼向n楼一层层测试（保证手机不坏） F(i,1) = i;
	 * 对于有两个手机的情况，若 第1个手机在 k楼扔下 k = 1..2...n
	 * 	1. 碎了，那么 就回到了只有一个手机的情况, = F(k-1, 1) + 1
	 *  2. 没碎，则只需要测试剩下的 k+1...n层,也即测试层变为(n-k)层楼 区间缩小 = F(n-k, 2) + 1; 
	 *  取其2种情况(最大值 最差情况)，然后取最差情况中最小的即为题解
	 * 有三个手机可以，和两个手机情况相同，碎了就回到了2个手机的情况
	 * @param n
	 * @param m
	 * @return
	 */
	public static int func(int N, int M) {
		int counts[][] = new int[N + 1][M + 1];
		for(int i = 1; i <= N; i++)// 很容易就计算出只有一部手机的情况
			counts[i][1] = i;
		for(int m = 2; m <= M; m++) { // m部手机
			for(int n = 1; n <= N; n++) {// n层楼
				int min = 999999;
				for(int k = 1; k <= n; k++) {
					int t = ListTools.max(counts[k - 1][m - 1], counts[n - k][m]);
					if(t < min) min = t;
				}
				counts[n][m] = min + 1;// 最小值 + 1 （和 加+1后再取最小值相同）
			}
		}
		System.out.println(ListTools.arrayToString(counts));
		return counts[N][M];
	}
	
	public static void main(String[] args) {
		System.out.println(func(32, 4));
	}
}