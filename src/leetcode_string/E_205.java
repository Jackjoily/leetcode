package leetcode_string;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 
 * 实现 strStr() 函数。 给定一个 haystack 字符串和一个 needle 字符串， 在 haystack 字符串中找出 needle
 * 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author jackjoily
 *
 */
public class E_205 {
	public static void main(String[] args) {
		System.out.println(isIsomorphic("egg", "add"));
	}
	public static boolean isIsomorphic(String s, String t) {
		for (int i = 0; i < s.length(); i++) {
			if (s.indexOf(s.charAt(i)) != t.indexOf(t.charAt(i)))
				return false;
		}
		return true;
	}

}
