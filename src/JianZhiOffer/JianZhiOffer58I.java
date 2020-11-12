package JianZhiOffer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 找出数组中重复的数字。
 * 
 * 
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。 为简单起见，标点符号和普通字母一样处理。 例如输入字符串"I am a student.
 * "，则输出"student. a am I"。
 * 
 * 
 * @author jackjoily
 *
 */
public class JianZhiOffer58I {
	public static void main(String[] args) {
		System.out.println(reverseWords("  hello world!  "));
	}

	public static String reverseWords(String s) {
		if (s.equals(""))
			return "";
		if (s.matches(" +"))
			return "";
		String[] split = s.split(" +");
		StringBuilder sb = new StringBuilder();
		for (int i = split.length - 1; i >= 0; i--) {
			if (!split[i].equals("") && !split[i].equals(" ")) {
				if (i != 0) {
					sb.append(split[i].trim()).append(" ");
				} else {
					sb.append(split[i].trim());
				}
			}
		}
		String string = sb.toString();
		if (string.substring(string.length() - 1, string.length()).equals(" ")) {
			return string.substring(0, string.length() - 1);
		} else {
			return string;
		}
	}
}
