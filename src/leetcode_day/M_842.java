package leetcode_day;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import leetcode_list.ListNode;

public class M_842 {
	/**
	 * 给定一个数字字符串 S，比如 S = "123456579"，我们可以将它分成斐波那契式的序列 [123, 456, 579]。
	 * 
	 * 形式上，斐波那契式序列是一个非负整数列表 F，且满足：
	 * 
	 * 0 <= F[i] <= 2^31 - 1，（也就是说，每个整数都符合 32 位有符号整数类型）； F.length >= 3； 对于所有的0 <= i
	 * < F.length - 2，都有 F[i] + F[i+1] = F[i+2] 成立。
	 * 另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。
	 * 
	 * 返回从 S 拆分出来的任意一组斐波那契式的序列块，如果不能拆分则返回 []。
	 * 
	 * @param head
	 * @param n
	 * @return
	 */
	public static void main(String[] args) {
		M_842 m = new M_842();
		// System.out.println(m.splitIntoFibonacci());
		m.f("1101111", 7, 0, 0, 0);
		System.out.println(m.list);
	}
	List<Integer> list = new ArrayList<Integer>();
	public List<Integer> splitIntoFibonacci(String S) {
		f(S, S.length(), 0, 0, 0);
		return list;
	}
	public boolean f(String s, int len, int start, int sum, int prev) {
		if (start == len) {
			return list.size() > 2;
		}
		long currlong = 0;
		for (int i = start; i < len; i++) {
			if (i > start && s.charAt(start) == '0') {
				break;
			}
			currlong = currlong * 10 + s.charAt(i) - '0';
			if (currlong > Integer.MAX_VALUE)
				break;
			int cur = (int) currlong;
			if (list.size() >= 2) {
				if (sum > cur) {
					continue;
				} else if (sum < cur) {
					break;
				}
			}
			list.add(cur);
			if (f(s, len, i + 1, cur + prev, cur)) {
				return true;
			} else {
				list.remove(list.size() - 1);
			}
		}
		return false;
	}

}
