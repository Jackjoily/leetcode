package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
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
		String str = "101023";
		System.out.println(restoreIpAddresses(str));
	}

	static List<String> list = new ArrayList<>();

	public static List<String> restoreIpAddresses(String s) {
		if (s.length() < 4 || s.length() > 12) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		f(s, sb, 0, s.length(), 0);
		return list;
	}

	public static void f(String str, StringBuilder sb, int begin, int len, int count) {
		if (count > 4 || count == 4 && sb.length() < len + 4)
			return;
		if (sb.length() == len + 4 && count == 4) {
			list.add(sb.deleteCharAt(sb.length() - 1).toString());
			sb.append(".");
			return;
		}
		for (int i = begin; i < len; i++) {
			for (int j = 1; j <= 3; j++) {
				if (i + j <= len) {
					String substring = str.substring(i, i + j);
					if (j == 1) {
						sb.append(substring);
						sb.append(".");
						f(str, sb, i + j, len, count + 1);
						sb.deleteCharAt(sb.length() - 1);
						sb.delete(sb.length() - j, sb.length());
					} else if (j > 1 && isOkay(substring)) {
						sb.append(substring);
						sb.append(".");
						f(str, sb, i + j, len, count + 1);
						sb.deleteCharAt(sb.length() - 1);
						sb.delete(sb.length() - j, sb.length());
					}
				}
			}
		}
	}

	public static boolean isOkay(String str) {
		if (str.length() > 1) {
			if (str.charAt(0) == '0')
				return false;
			if (Integer.valueOf(str) > 255)
				return false;
		}
		return true;
	}

}
