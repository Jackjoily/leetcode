package leetcode_array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 
 * @author jackjoily
 *
 */
public class M_17 {
	public static void main(String[] args) {
		M_17 m = new M_17();
		m.letterCombinations("23");
	}

	Map<Character, String> map = new HashMap<>();
	List<String> list = new ArrayList<>();

	public List<String> letterCombinations(String digits) {
		if (digits == null || digits.equals("") || digits.equals(" "))
			return list;
		map.put('2', "abc");
		map.put('3', "def");
		map.put('4', "ghi");
		map.put('5', "jkl");
		map.put('6', "mno");
		map.put('7', "pqrs");
		map.put('8', "tuv");
		map.put('9', "wxyz");
		StringBuilder sb = new StringBuilder();
		f(digits, 0, sb, map);
		return list;
	}

	public void f(String str, int i, StringBuilder sb, Map<Character, String> map) {
		if (i == str.length()) {
			list.add(sb.toString());
			return;
		} else if (i > str.length())
			return;
		else {
			String strings = map.get(str.charAt(i));
			for (int l = 0; l < strings.length(); l++) {
				// 挑选
				sb.append(strings.charAt(l));
				f(str, i + 1, sb, map);
				sb.deleteCharAt(sb.length() - 1);
			}
		}
	}
}
