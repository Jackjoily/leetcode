package leetcode_string;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * 
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 * 
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 * 
 * @author jackjoily
 *
 */
public class E_434 {
	public static void main(String[] args) {
		System.out.println(countSegments("    foo    bar"));
	}

	public static int countSegments(String s) {
		if(s.equals(""))return 0;
		String[] split = s.split("\\s+");
		int temp = 0;
		for (String string : split) {
			if (!string.trim().equals("")) {
				temp++;
			}
		}
		return temp;
	}
}
