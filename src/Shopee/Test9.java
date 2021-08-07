package Shopee;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test9 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		str.replace("*", ".*");
		String str1 = sc.nextLine();
		Pattern p = Pattern.compile(str);
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; i < str.length() + 1; j++) {
				if (p.matcher(str1.substring(i, j)).matches()) {
					System.out.println(i + " " + (j - i));
				}
			}
		}
	}
}
