package leetcode_dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 编写一个程序，找出第 n 个丑数。
 * 
 * 丑数就是质因数只包含 2, 3, 5 的正整数。
 * 
 * @author jackjoily
 *
 */
class M_264 {
	public static void main(String[] args) {
		new M_264().nthUglyNumber(1690);
	}

	public int nthUglyNumber(int n) {
		int a[] = new int[1690];
		a[0] = 1;
		int f1 = 0;
		int f2 = 0;
		int f3 = 0;
		for (int i = 1; i < 1690; i++) {
			int b = a[f1] * 2;
			int c = a[f2] * 3;
			int d = a[f3] * 5;
			int min = Math.min(Math.min(b, c), d);
			a[i] = min;
			if (min == a[f1] * 2)
				++f1;
			if (min == a[f2] * 3)
				++f2;
			if (min == a[f3] * 5)
				++f3;

		}
		return a[n - 1];
	}
}
