package Shopee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

import jdk.nashorn.internal.runtime.regexp.joni.ScanEnvironment;
import leetcode_tree.TreeNode;

public class Test5 {
	public static void main(String[] args) {

	}

	// (((*())()*
	public boolean checkValidString(String s) {
		if (s.length() == 0)
			return true;
		if (s.length() == 1 && s.equals("*"))
			return true;
		if (s.length() == 1)
			return false;
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> stars = new Stack<>();
		char[] c = s.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (c[i] == '(') {
				stack.push(i);
			} else if (c[i] == '*') {
				stars.push(i);
			} else {
				if (stack.isEmpty() && stars.isEmpty())
					return false;
				else if (!stack.isEmpty()) {
					stack.pop();
				} else {
					stars.pop();
				}
			}
		}
		if (stack.size() > stars.size())
			return false;
		else {
			while (!stack.isEmpty() && !stars.isEmpty()) {
				int i = stack.pop();
				int j = stars.pop();
				if (i > j)
					return false;
			}
		}
		return stars.size() >= 0 ? true : false;
	}
}
