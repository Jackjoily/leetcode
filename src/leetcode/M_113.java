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
public class M_113 {
	static char c[] = {};

	public static void main(String[] args) {
		M_113 m = new M_113();
		String str = "a";
		c = str.toCharArray();
		LinkedList<String> list = new LinkedList<>();
	System.out.println(m.partition(str));
	}

	List<List<String>> list1 = new ArrayList<>();

	public List<List<String>> partition(String s) {
		c = s.toCharArray();
		LinkedList<String> list = new LinkedList<>();
		f(s, list, 0, s.length());
		return list1;
	}

	public void f(String s, LinkedList<String> list, int i, int len) {
		if (i == len) {
			list1.add(new ArrayList<>(list));
			return;
		}
		for (int j = 1; j <=len; j++) {
			int endIndex = i + j;
			if (endIndex > len)
				break;
			if (isHuiWen(c, i, endIndex - 1)) {
				list.add(s.substring(i, endIndex));
				f(s, list, endIndex, len);
				list.removeLast();
			}
		}
	}

	public boolean isHuiWen(char c[], int start, int end) {
		while (start < end) {
			if (c[start] != c[end]) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}

}
