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
public class M_151 {
	public static void main(String[] args) {
		String s = "  hello world!  ";

		System.out.println(reverseWords(s));

	}

	public static String reverseWords(String s) {
		StringBuilder sb = new StringBuilder();
		String[] split = s.split("\\s+");
		String str = "";
		for (int i = split.length - 1; i >= 0; i--) {
			str = split[i].trim();
			if (!str .equals("") && !str .equals(" ")) {
				sb.append(str + "");
			}
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}
}
