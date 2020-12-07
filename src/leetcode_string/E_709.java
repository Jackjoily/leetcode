package leetcode_string;

import java.util.HashMap;
import java.util.Map;

/**
 * 对于字符串 S 和 T，只有在 S = T + ... + T（T 与自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。 *
 * 
 * @author jackjoily
 *
 */
public class E_709 {
	public static void main(String[] args) {
		System.out.println(toLowerCase("Hello"));
	}

	public static String toLowerCase(String str) {
		if (str.length() == 0)
			return str;
		char[] charArray = str.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			if (charArray[i] >= 'A' && charArray[i] <= 'Z') {
				charArray[i] = (char) (str.charAt(i)+32);
			}
		}
		return new String(charArray);
	}
}
