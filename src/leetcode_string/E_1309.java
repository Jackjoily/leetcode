package leetcode_string;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 
 * 给你一个字符串 s，它由数字（'0' - '9'）和 '#' 组成。我们希望按下述规则将 s 映射为一些小写英文字符：
 * 
 * 字符（'a' - 'i'）分别用（'1' - '9'）表示。 字符（'j' - 'z'）分别用（'10#' - '26#'）表示。 
 * 返回映射之后形成的新字符串。
 * 
 * 题目数据保证映射始终唯一。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decrypt-string-from-alphabet-to-integer-mapping
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 * 
 * @author jackjoily
 *
 */
public class E_1309 {
	public static void main(String[] args) {
		E_1309 e = new E_1309();

		String str = "10#11#12";
		System.out.println(freqAlphabets(str));
	}

	public static String freqAlphabets(String s) {
		char a[] = { ' ', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
				't', 'u', 'v', 'w', 'x', 'y', 'z' };
		StringBuilder sb = new StringBuilder();
		for (int i = s.length() - 1; i >= 0;) {
			if (s.charAt(i) != '#') {
				sb.append(a[s.charAt(i) - '0']);
				i--;
			} else {
				sb.append(a[Integer.valueOf(s.substring(i - 2, i))]);
				i -= 3;
			}
		}
		return sb.reverse().toString();
	}
}
