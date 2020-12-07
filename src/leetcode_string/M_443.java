package leetcode_string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class M_443 {

	public static void main(String[] args) {
		M_443 m = new M_443();
		char a[] = { 'a', 'a', 'b', 'b', 'c', 'c', 'c' };
		System.out.println(compress(a));
	}

	public static int compress(char[] chars) {
		char[] clone = chars.clone();
		if (chars.length == 1)
			return chars.length;
		int count = 0;
		char ch = chars[0];
		int temp = 1;
		int j = 1;
		for (int i = 1; i < chars.length; i++) {
			if (chars[i] != ch) {
				if (j < chars.length) {

					if (temp < chars.length) {
						if (temp != 1) {
							String str = temp + "";
							if (temp >= 10) {
								for (int k = 0; k < str.length(); k++) {
									chars[j] = str.charAt(k);
									j++;
								}
							} else {
								chars[j] = str.charAt(0);
								j++;
							}
							chars[j] = chars[i];
							ch = chars[i];
							j++;
							temp = 1;
						} else {
							chars[j] = chars[i];
							j++;
							ch = chars[i];
							temp = 1;
						}
					} else {
						return chars.length;
					}
				} else {
					return chars.length;
				}
			} else {
				temp++;
			}
		}
		if (temp > 1) {
			String str = temp + "";
			if (temp >= 10) {
				for (int k = 0; k < str.length(); k++) {
					if (j < chars.length) {
						chars[j] = str.charAt(k);
						j++;
					} else {
						return chars.length;
					}

				}
			} else {
				if (j < chars.length) {
					chars[j] = str.charAt(0);
					j++;
				} else {
					return chars.length;
				}
			}
		}
		System.out.println(Arrays.toString(chars));
		return j-1;
	}
}
