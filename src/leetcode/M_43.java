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

public class M_43 {
	public static void main(String[] args) {
		System.out.println(multiply("9", "99"));
	}

	public static String multiply(String num1, String num2) {
		if (num1.equals("0") || num2.equals("0"))
			return "0";
		int n = num1.length();
		int m = num2.length();
		int c[] = new int[m + n];
		for (int i = n - 1; i >= 0; i--) {
			int n1 = num1.charAt(i) - '0';
			for (int j = m - 1; j >= 0; j--) {
				int p1 = m+n - 2 - i - j, p2 = p1 + 1;
				int n2 = num2.charAt(j) - '0';
				int q = (n1 * n2 + c[p1]);
				c[p1] = q % 10;
				c[p2] += q / 10;
			}

		}
		StringBuilder sb = new StringBuilder();
		for (int i = c.length - 1; i >= 0; i--) {
			if (sb.length() == 0 && c[i] == 0) {
				continue;
			} else {
				sb.append(c[i]);
			}
		}
		return sb.toString();
	}
}
