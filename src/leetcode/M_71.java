package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

import javafx.scene.shape.Line;
import leetcode_list.ListNode;
import leetcode_tree.TreeNode;

/**
 * 
 * @author jackjoily
 *
 */
public class M_71 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString("/a//b////c/d//././/..".split("/")));
	System.out.println(simplifyPath("/a//b////c/d//././/.."));
	}

	public static String simplifyPath(String path) {
		ArrayDeque<String> s = new ArrayDeque<>();
		String[] split = path.split("/");
		for (int i = 0; i < split.length; i++) {
			if (!split[i].trim().equals("")) {
				if (split[i].equals("..")) {
					if (s.size() > 0) {
						s.pollLast();
					}
				} else if (split[i].equals(".")) {

				} else {
					s.add(split[i]);
				}
			}
		}
		if (s.size() == 0)
			return "/";
		StringBuilder sb = new StringBuilder();
		while (s.size() > 0) {
			sb.append("/").append(s.poll());
		}
		return sb.toString();
	}
}
