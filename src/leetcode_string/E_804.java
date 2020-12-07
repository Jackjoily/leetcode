package leetcode_string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 * 国际摩尔斯密码定义一种标准编码方式，将每个字母对应于一个由一系列点和短线组成的字符串， 比如: "a" 对应 ".-", "b" 对应 "-...",
 * "c" 对应 "-.-.", 等等。
 * 
 * 为了方便，所有26个英文字母对应摩尔斯密码表如下：
 * 
 * [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
 * 
 * @author jackjoily
 *
 */
public class E_804 {
	public static void main(String[] args) {
	}

	public int uniqueMorseRepresentations(String[] words) {
		if (words.length == 1)
			return 1;

		String a[] = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.",
				"---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.." };
		Set<String> set = new HashSet<>();
		StringBuilder sb;
		for (int i = 0; i < words.length; i++) {
			sb = new StringBuilder();
			for (int k = 0; k < words[i].length(); k++) {
				sb.append(a[words[i].charAt(k) - 'a']);
			}
			set.add(sb.toString());
		}
		return set.size();
	}
}
