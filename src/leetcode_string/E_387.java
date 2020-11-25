package leetcode_string;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。 如果不存在，则返回 -1。
 * 
 * @author jackjoily
 *
 */
public class E_387 {
	public static void main(String[] args) {
		System.out.println(firstUniqChar("cc"));
	}

	public static int firstUniqChar(String s) {
		if (s == null)
			return -1;
		if (s.equals(""))
			return -1;
		if (s.length() == 1)
			return 0;
		char[] charArray = s.toCharArray();
		Map<Character, Boolean> map = new LinkedHashMap<>();
		for (int i = 0; i < charArray.length; i++) {
			char c = charArray[i];
			if (map.containsKey(c)) {
				map.put(c, false);
			} else {
				map.put(c, true);
			}
		}
		Collection<Boolean> values = map.values();
		int k = 0;
		for (Entry<Character, Boolean> boolean1 : map.entrySet()) {
			if (boolean1.getValue()) {
				return s.indexOf(boolean1.getKey());
			}
		}
		return -1;
	}

}