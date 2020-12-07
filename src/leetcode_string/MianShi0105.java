package leetcode_string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author jackjoily
 *
 */
public class MianShi0105 {
	public static void main(String[] args) {
		System.out.println(oneEditAway("mart", "karma"));
	}

	public static boolean oneEditAway(String first, String second) {
		if (first.equals(second))
			return true;
		else {
			if (Math.abs(first.length() - second.length()) >= 2)
				return false;
			else {
				if (first.length() > second.length()) {
					for (int i = 0; i < second.length(); i++) {
						if (first.charAt(i) != second.charAt(i)) {
							// abcde acde
							if (first.substring(i + 1, first.length()).equals(second.substring(i, second.length()))) {
								return true;
							} else {
								return false;
							}
						}

					}
				} else if (first.length() == second.length()) {
					int k = 0;
					for (int i = 0; i < second.length(); i++) {
						if (first.charAt(i) != second.charAt(i)) {
							k++;
						}
					}
					if (k > 1)
						return false;
					return true;
				} else {
					for (int i = 0; i < first.length(); i++) {
						if (second.charAt(i) != first.charAt(i)) {
							// acde abcde
							if (second.substring(i + 1, second.length()).equals(first.substring(i, first.length()))) {
								return true;
							} else {
								return false;
							}
						}

					}
				}

			}
		}
		return true;
	}
}
