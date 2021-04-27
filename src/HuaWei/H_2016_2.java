package HuaWei;

import java.util.*;

public class H_2016_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			System.out.println(f(sc.nextLine()));
		}

	}

	public  static String f(String text) {
		char[] c = text.toCharArray();
		Set<Character> set = new TreeSet<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < c.length; i++) {
			if (set.add(c[i])) {
				sb.append(c[i]);
			}
		}
		return sb.toString();
	}
}
