package leetcode_string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s1 和 s2，请编写一个程序， 确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 * 
 * @author jackjoily
 *
 */
public class MianShi0104 {
	public static void main(String[] args) {
	System.out.println(canPermutePalindrome("abcdabc"));
	}

	public  static boolean canPermutePalindrome(String s) {
		if (s.length() == 0)
			return true;
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				map.remove(s.charAt(i));
			} else {
				map.put(s.charAt(i), 1);
			}
		}
		if (s.length() % 2 == 0) {
			if (map.keySet().size() > 0)
				return false;
			else {
				return true;
			}
		} else {
			if (map.keySet().size() == 1)
				return true;
			else {
				return false;
			}
		}
	}
}
