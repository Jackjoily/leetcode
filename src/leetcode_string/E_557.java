package leetcode_string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import com.sun.xml.internal.fastinfoset.util.CharArray;

/**
 * 给定一个字符串，验证它是否是回文串， 只考虑字母和数字字符，可以忽略字母的大小写。
 * 
 * @author jackjoily
 *
 */
public class E_557 {
	public static void main(String[] args) {
		System.out.println(reverseWords("Let's take LeetCode contest"));
	}

	public static String reverseWords(String s) {
		String[] split = s.split("\\s+");
		int n = 0;
		char c = ' ';
		for (int i = 0; i < split.length; i++) {
			char[] charArray = split[i].toCharArray();
			n = charArray.length / 2;
			for (int j = 0; j < n; j++) {
				c = charArray[j];
				charArray[j] = charArray[charArray.length-1 - j];
				charArray[charArray.length-1 -  j] = c;
			}
			split[i] = new String(charArray);
		}
		return String.join(" ", split);
	}
}
