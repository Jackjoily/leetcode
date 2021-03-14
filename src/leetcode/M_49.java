package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 
 * @author jackjoily
 *
 */
public class M_49 {
	public static void main(String[] args) {
		M_49 m = new M_49();
		String strs[] = { "eat", "tea", "tan", "ate", "nat", "bat" };
		System.out.println(m.f("eat", "tan"));
	}

	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> list1 = new ArrayList<>();
		int j = strs.length;
		boolean used[] = new boolean[j];
		while (j != 0) {
			for (int i = 0; i < strs.length; i++) {
				if (!used[i]) {
					List<String> list = new ArrayList<>();
					list.add(strs[i]);
					used[i] = true;
					j--;
					for (int l = i + 1; l < strs.length; l++) {
						if(!used[l]) {
							if (f(strs[i], strs[l])) {
								used[l] = true;
								list.add(strs[l]);
								j--;
							}
						}
					}
					list1.add(list);
				}
			}
		}
		return list1;
	}

	public boolean f(String str, String str1) {
		if (str.length() != str1.length())
			return false;
		int c[] = new int[26];
		for (int i = 0; i < str.length(); i++) {
			c[str.charAt(i) - 'a']++;
			c[str1.charAt(i) - 'a']--;
		}
		for (int i = 0; i < 26; i++) {
			if (c[i] != 0)
				return false;
		}
		return true;
	}

}
