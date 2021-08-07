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
		System.out.println(multiply("123", "456"));
	}

	public static String multiply(String num1, String num2) {
		if (num1.equals("0") || num2.equals("0")) {
			return "0";
		}
		char[] n = num1.toCharArray();
		char[] n1 = num2.toCharArray();
		int len = n.length + n1.length;
		int a[] = new int[len];
		int val = 0;
		for (int j = n1.length - 1; j >= 0; j--) {
			int c = n1[j] - '0';
			for (int i = n.length - 1; i >= 0; i--) {
				int c1 = n[i] - '0';
				int p1 = len - 2 - i - j, p2 = p1 + 1;
				int q = (c1 * c + a[p1]);
				a[p1] = q % 10;
				a[p2] += q / 10;
			}
		}
		StringBuilder sb = new StringBuilder();
		int i = len - 1;
		while (i >= 0) {
			while (i >= 0 && a[i] == 0)
				i--;
			while (i >= 0) {
				sb.append(a[i--]);
			}
		}
		return sb.toString();
	}
}
