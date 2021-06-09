package Shopee;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

import jdk.nashorn.internal.runtime.regexp.joni.ScanEnvironment;

public class Test3 {
	public static void main(String[] args) {
		System.out.println(computeString("3*[a2*[c]]"));
	}

	public static String computeString(String str) {
		char[] c = str.toCharArray();
		Stack<String> s = new Stack<>();
		Stack<Integer> s1 = new Stack<>();
		int res = 0;
		for (int i = 0; i < c.length; i++) {
			if (Character.isDigit(c[i])) {
				res = res * 10 + c[i] - '0';
			} else if (c[i] == '[') {
				s.add(String.valueOf(c[i]));
			} else if (c[i] == ']') {
				int n = s1.pop();
				StringBuilder sb = new StringBuilder();
				while (!s.isEmpty() && !s.peek().equals("[")) {
					sb.append(s.pop());
				}
				s.pop();
				StringBuilder sb1 = new StringBuilder();
				for (int j = 0; j < n; j++) {
					sb1.append(sb.toString());
				}
				if (s1.size() == 1) {
					s.add(sb1.toString());
				}else {
					s.add(sb1.reverse().toString());
				}
			
			} else if (c[i] == '*') {
				s1.add(res);
				res = 0;
			} else {

				s.add(String.valueOf(c[i]));
			}
		}
		StringBuilder sb = new StringBuilder();
		while (!s.isEmpty()) {
			sb.append(s.pop());
		}
		return sb.toString();
	}
}
