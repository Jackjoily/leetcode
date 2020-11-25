package leetcode_string;

import java.util.ArrayList;
import java.util.List;

public class M_49 {

	public static void main(String[] args) {
		M_49 m = new M_49();
		String a[] = { "eat", "tea", "tan", "ate", "nat", "bat" };
		List<List<String>> groupAnagrams = m.groupAnagrams(a);
		System.out.println(groupAnagrams);
	}

	/**
	 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
	 * 
	 * @param s
	 * @return
	 */
	List<List<String>> list = new ArrayList<>();

	public List<List<String>> groupAnagrams(String[] strs) {
		if (strs.length == 0)
			return list;
		if (strs.length == 1) {
			ArrayList<String> arrayList = new ArrayList<String>();
			list.add(arrayList);
			return list;
		}
		int i = 0, j = 0;
		boolean flag[] = new boolean[strs.length];
		for (; i < strs.length - 1; i++) {
			if (!flag[i]) {
				List<String> list1 = new ArrayList<>();
				list1.add(strs[i]);
				flag[i] = true;
				for (j = i + 1; j < strs.length; j++) {
					if (!flag[j]) {
						if (isAnagram(strs[i], strs[j])) {
							list1.add(strs[j]);
							flag[j] = true;
						}
					}
				}
				list.add(list1);
			}
		}
		if (!flag[i]) {
			List<String> list1 = new ArrayList<>();
			list1.add(strs[i]);
			list.add(list1);
		}
		return list;
	}

	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length())
			return false;
		int a[] = new int[26];
		for (int i = 0; i < s.length(); i++) {
			a[s.charAt(i) - 'a']++;
			a[t.charAt(i) - 'a']--;
		}
		for (int x : a) {
			if (x != 0)
				return false;
		}
		return true;
	}
}
