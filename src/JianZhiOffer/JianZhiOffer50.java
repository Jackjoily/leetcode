package JianZhiOffer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 
 * 在字符串 s 中找出第一个只出现一次的字符。 如果没有，返回一个单空格。 s 只包含小写字母
 * 
 * @author jackjoily
 *
 */
public class JianZhiOffer50 {
	public char firstUniqChar(String s) {
		if (s.length() == 0)
			return ' ';
		if (s.length() == 1)
			return s.charAt(0);
		Map<Character, Boolean> map = new LinkedHashMap<>();
		for (int i = 0; i < s.length(); i++) {
			if (!map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), true);
			} else {
				map.put(s.charAt(i), false);
			}
		}
		Set<Entry<Character, Boolean>> entrySet = map.entrySet();
		for (Entry<Character, Boolean> entry : entrySet) {
			if (entry.getValue())
				return entry.getKey();
		}
		return ' ';
	}
}
