package leetcode_string;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * URL化。编写一种方法，将字符串中的空格全部替换为%20。
 * 假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。（注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
 * 
 * @author jackjoily
 *
 */
public class MianShi0103 {
	public static void main(String[] args) {
		System.out.println(replaceSpaces("Mr John Smith    ", 13));
	}

	public static String replaceSpaces(String s, int length) {
		String substring = s.substring(0, length);
		return substring.replace(" ", "%20");
	}
}
