package leetcode_array;

import java.util.ArrayList;
import java.util.List;

/**
 * 设计一种算法，打印 N 皇后在 N × N
 * 棋盘上的各种摆法，其中每个皇后都不同行、不同列，也不在对角线上。这里的“对角线”指的是所有的对角线，不只是平分整个棋盘的那两条对角线。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/eight-queens-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author jackjoily
 *
 */
public class MianShi0812 {

	int n;
	int a[];
	List<List<String>> list = new ArrayList<>();

	public List<List<String>> solveNQueens(int n) {
		if (n <= 0) {
			return list;
		}
		this.n = n;
		this.a = new int[n];
		f(0);
		return list;
	}

	public void f(int j) {
		if (a.length == j) {
			list.add(printf(a));
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

	public List<String> printf(int a[]) {
		List<String> list = new ArrayList<>();
		StringBuilder sb = null;
		String str = "";
		for (int i = 0; i < a.length; i++) {
			str += ".";
		}
		for (int i = 0; i < a.length; i++) {
			sb = new StringBuilder(str);
			sb.replace(a[i], a[i] + 1, "Q");
			list.add(sb.toString());
		}
		return list;
	}

	public boolean check(int n) {
		for (int i = 0; i < n; i++) {
			if (a[n] == a[i] || Math.abs(n - i) == Math.abs(a[n] - a[i])) {
				return false;
			}
		}
		return true;
	}
}
