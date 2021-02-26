package leetcode_dp;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import edu.princeton.cs.algs4.In;

/**
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * 
 * 返回 s 所有可能的分割方案。
 * 
 * @author jackjoily
 *
 */
public class M_131 {
	public static void main(String[] args) {
		M_131 m = new M_131();
		String str = "aab";
		Deque<String> path = new ArrayDeque<>();
		m.f(str, path, 0, 3);
	}

	List<List<String>> list = new ArrayList<>();

	public List<List<String>> partition(String s) {
		int length = s.length();
		if (length == 0)
			return list;
		Deque<String> path = new ArrayDeque<>();
		f(s, path, 0, length);
		return list;
	}

	public void f(String s, Deque<String> path, int start, int len) {
		if (start == len) {
			list.add(new ArrayList<>(path));
			System.out.println(path);
			return;
		}
		for (int i = start; i < len; i++) {
			if (!isHuiWen(s, start, i)) {
				continue;
			}
			path.add(s.substring(start, i + 1));
			f(s, path, start + 1, len);
			path.removeLast();
		}
	}

	public boolean isHuiWen(String s, int start, int end) {
		while (start < end) {
			if (s.charAt(start) != s.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}

}
