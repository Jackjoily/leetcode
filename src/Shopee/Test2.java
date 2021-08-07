package Shopee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		if (str.contains("-")) {
			System.out.println(str(str.split("-")));
		} else if (str.contains("_")) {
			System.out.println(str(str.split("_")));
		} else {
			System.out.println(str(str1(str)));
		}

	}

	public static String[] str1(String str) {
		List<String> list = new ArrayList<>();
		int len = str.length();
		int pre = 0;
		for (int i = 1; i < len;) {
			while (i < len && Character.isLowerCase(str.charAt(i))) {
				i++;
			}
			list.add(str.substring(pre, i).toLowerCase());
			pre = i;
			i++;
		}
		String s[] = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			s[i] = list.get(i);
		}
		return s;
	}

	public static String str(String str[]) {
		StringBuilder sb = new StringBuilder();
		for (String s : str) {
			char[] c = s.toCharArray();
			char lowerCase = Character.toUpperCase(c[0]);
			c[0] = lowerCase;
			sb.append(c);
		}
		sb.append(" ");
		int i = 0;
		for (String s : str) {
			if (i == 0) {
				sb.append(s);
				i++;
			} else {
				char[] c = s.toCharArray();
				char lowerCase = Character.toUpperCase(c[0]);
				c[0] = lowerCase;
				sb.append(c);
			}
		}
		sb.append(" ");
		String join = String.join("_", str);
		sb.append(join);
		sb.append(" ");
		String join1 = String.join("-", str);
		sb.append(join1);
		return sb.toString();
	}
}
