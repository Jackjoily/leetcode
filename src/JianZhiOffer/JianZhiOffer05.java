package JianZhiOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 */
public class JianZhiOffer05 {
	public static void main(String[] args) {
		System.out.println(replaceSpace("    "));
	}

	public static String replaceSpace(String s) {
		if (s.length() == 0)
			return s;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == ' ') {
				sb.append("%20");
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}

}
