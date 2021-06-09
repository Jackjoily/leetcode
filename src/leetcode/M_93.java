package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import javafx.scene.shape.Line;
import leetcode_list.ListNode;
import leetcode_tree.TreeNode;

/**
 * 
 * @author jackjoily
 *
 */
public class M_93 {
	public static void main(String[] args) {
		M_93 m = new M_93();
		String s = "172162541";
		int n = s.length();
		LinkedList<String> list = new LinkedList<>();
		System.out.println(m.restoreIpAddresses(s));
	}

	static List<String> list2 = new ArrayList<>();

	public List<String> restoreIpAddresses(String s) {
		int n = s.length();
		if (n < 4 || n > 12)
			return list2;
		LinkedList<String> list1 = new LinkedList<>();
		f(s, 0, n, 0, list1);
		return list2;
	}

	public static void f(String s, int i, int n, int flag, LinkedList<String> list) {
		if (flag == 4 && i == n) {
			list2.add(String.join(".", list));
			return;
		}
		if (i < n) {
			char c = s.charAt(i);
			if (c == '0') {
				list.add("0");
				flag++;
				f(s, i + 1, n, flag, list);
				list.removeLast();
				flag--;
			} else {
				for (int j = 1; j <= 3; j++) {
					if (i + j <= n) {
						if (i + j == n) {
							if (flag != 3)
								break;
						}
						String substring = s.substring(i, i + j);
						if (isOkay(substring)) {
							flag++;
							if (flag == 4 && i + j < n) {
								flag--;
								continue;
							} else {
								list.add(substring);
								f(s, i + j, n, flag, list);
								list.removeLast();
								flag--;
							}
						}
					} else {
						break;
					}
				}
			}
		}
	}

	public static boolean isOkay(String s) {
		int n = s.length();
		if (n == 1) {
			return true;
		} else if (n == 2) {
			char c = s.charAt(0);
			if (c == '0')
				return false;
		} else {
			char c = s.charAt(0);
			char d = s.charAt(1);
			char e = s.charAt(2);
			if (c == '0' || c > '2')
				return false;
			if (c == '2') {
				if (d > '5')
					return false;

				if (d == '5' & e > '5')
					return false;
			}
		}
		return true;
	}
}
