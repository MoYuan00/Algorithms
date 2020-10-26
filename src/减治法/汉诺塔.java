package 减治法;

/**
 * 描述，有 A B C3个柱子，A上 放着n个盘子，底下的盘子大于上面，
 * 如何将A上的盘子移动到C，且移动过程和结果始终保证小盘子在大盘上方
 * 减治法，
 * 假设对于n层的汉诺塔，前n-1层已经从 A放到了B （ C辅助 ）
 * 那么接下来 只需将A[n] 从 A 放到 C 
 * 然后将 前 n-1 层 从 B 放到 C 即可 （A 辅助 ）
 * @author Rnti
 *
 */
public class 汉诺塔 {
	static int count = 0;// reword step of move in put
	public static void func(int n, char source, char temp, char target) {
		if(n == 0) {
			return;
		}
		// 将 前 n-1 层全部 由 a move to b, c is used temp
		func(n - 1, source, target, temp);
		count ++;
		System.out.println("将" + n + " 从" + source +"放到" + target);
		// move 1 to n-1 from B to C, A is used temp
		func(n - 1, temp, source, target);
		
	}
	
	public static void main(String[] args) {
		func(1, 'A', 'B', 'C');
		System.out.println("共需:" + count + "次");
	}
}
