package Shopee;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import jdk.nashorn.internal.runtime.regexp.joni.ScanEnvironment;

public class Test2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		StringBuilder sb = new StringBuilder();
		if (str.contains("-")) {
			String[] split = str.split("-");
			sb.append(get3(split)).append(" ").append(get2(split)).append(" ").append(get(split)).append(" ")
					.append(str);
			System.out.println(sb.toString());
		} else if (str.contains("_")) {
			String[] split = str.split("_");
			sb.append(get3(split)).append(" ").append(get2(split)).append(" ").append(str).append(" ")
					.append(get1(split));
			System.out.println(sb.toString());
		} else if (Character.isLowerCase(str.charAt(0))) {
			List<String> list = new ArrayList<>();
			int k = 0;
			for (int i = 0; i < str.length(); i++) {
				if (Character.isLowerCase(str.charAt(i))) {

				} else {
					list.add(str.substring(k, i).toLowerCase());
					k = i;
				}
			}
			list.add(str.substring(k, str.length()).toLowerCase());
			String[] split = new String[list.size()];
			for (int i = 0; i < list.size(); i++) {
				split[i] = list.get(i);
			}
			sb.append(get3(split)).append(" ").append(str).append(" ").append(get(split)).append(" ")
					.append(get1(split)).append(" ");
			System.out.println(sb.toString());
		} else {
			List<String> list = new ArrayList<>();
			int k = 0;
			for (int i = 0; i < str.length(); i++) {
				if (Character.isLowerCase(str.charAt(i))) {

				} else {
					list.add(str.substring(k, i).toLowerCase());
					k = i;
				}
			}
			list.add(str.substring(k, str.length()).toLowerCase());
			list.remove(0);
			String[] split = new String[list.size()];
			for (int i = 0; i < list.size(); i++) {
				split[i] = list.get(i);
			}
			sb.append(str).append(" ").append(get2(split)).append(" ").append(get(split)).append(" ")
					.append(get1(split)).append(" ");
			System.out.println(sb.toString());
		}
	}

	// PascalCaseTest
	public static String get3(String[] c) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < c.length; i++) {
			char[] charArray = c[i].toCharArray();
			charArray[0] = Character.toUpperCase(charArray[0]);
			sb.append(charArray);
		}
		return sb.toString();
	}

	// pascalCaseTest
	public static String get2(String[] c) {
		StringBuilder sb = new StringBuilder();
		sb.append(c[0]);
		for (int i = 1; i < c.length; i++) {
			char[] charArray = c[i].toCharArray();
			charArray[0] = Character.toUpperCase(charArray[0]);
			sb.append(charArray);
		}
		return sb.toString();
	}

	// _
	public static String get(String[] c) {
		StringBuilder sb = new StringBuilder();
		for (String s : c) {
			sb.append(s).append("_");
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}

	// -
	public static String get1(String[] c) {
		StringBuilder sb = new StringBuilder();
		for (String s : c) {
			sb.append(s).append("-");
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}
}
