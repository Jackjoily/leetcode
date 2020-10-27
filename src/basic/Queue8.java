package basic;

import java.util.Arrays;

/**
 * 解决八皇后问题
 * 
 * @author jackjoily
 *
 */
public class Queue8 {

	int max = 8;
	int[] array = new int[max];

	static int count = 0;

	public static void main(String[] args) {
		Queue8 queue8 = new Queue8();
		queue8.check(0);
	}

	// 放置第n个皇后
	private void check(int n) {
		if (n == max) {
			System.out.println(Arrays.toString(array));
			return;
		}
		for (int i = 0; i < max; i++) {
			// 先把当前这个皇后n,放到该行的第一列
			array[n] = i;
			if (judge(n)) {
				// 接着放第n+1
				check(n + 1);
			}
			// 冲突了则换下一个位置
		}

	}

	// 查看放置第n个皇后，就去检测该皇后是否和前面的已经摆放的有冲突
	private boolean judge(int n) {
		
		for (int i = 0; i < n; i++) {
			// 处于同一列或者处于同一斜线上
			if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
				return false;
			}
		}
		return true;
	}
}
