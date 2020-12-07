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
public class MianShi0102 {
	public static void main(String[] args) {
	}

	public static boolean CheckPermutation(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		char[] charArray = s1.toCharArray();
		char[] charArray2 = s2.toCharArray();
		Arrays.sort(charArray);
		Arrays.sort(charArray2);
		for (int i = 0; i < charArray.length; i++) {
			if (charArray[i] != charArray2[i])
				return false;
		}
		return true;
	}
}
