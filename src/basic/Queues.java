package basic;

import java.util.Arrays;

public class Queues {
	int max = 8;
	int[] array = new int[8];

	public static void main(String[] args) {
		// 解决八皇后问题
        new Queues().solve(0);
	}

	public void solve(int n) {
		if (n == max) {
			System.out.println(Arrays.toString(array));
			return ;
		}
		for (int i = 0; i < 8; i++) {
			array[n] = i;
			if (check(n)) {
				solve(n + 1);
			}
		}
	}

	public boolean check(int n) {
		for (int i = 0; i < n; i++) {
			if (array[n] == array[i] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
				return false;
			}
		}
		return true;
	}

}
