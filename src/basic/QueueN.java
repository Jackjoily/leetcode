package basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueueN {
	static int n = 8;

	public static void main(String[] args) {
		f(0);
	}

	static int a[] = new int[n];

	public static void f(int j) {
		if (a.length == j) {
			printf(a);
			return;
		}

		for (int k = 0; k < a.length; k++) {
			// 选择路径
			a[j] = k;
			if (check(j)) {
				f(j + 1);
			}
		}
	}

	public static boolean check(int n) {
		for (int i = 0; i < n; i++) {
			if (a[n] == a[i] || Math.abs(n - i) == Math.abs(a[n] - a[i])) {
				return false;
			}
		}
		return true;
	}

	public static void printf(int a[]) {
		List<String> list = new ArrayList<>();
		StringBuilder sb = null;
		String str = "";
		for (int i = 0; i < a.length; i++) {
			str += ".";
		}
		for (int i = 0; i < a.length; i++) {
			sb = new StringBuilder(str);
			sb.replace(a[i], a[i]+1, "Q");
			list.add(sb.toString());
		}
		System.out.println(list);

	}
}
