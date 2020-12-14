package leetcode_day;

import java.util.ArrayList;
import java.util.List;

import leetcode_list.ListNode;

public class M_49 {
	public static void main(String[] args) {
		String a[]= {"eat", "tea", "tan", "ate", "nat", "bat"};
		System.out.println(groupAnagrams(a));
	}

	public static List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> list = new ArrayList<>();
		if(strs.length==0)return list;
		int i = 0;
		for (; i < strs.length; i++) {
			if (list.size() == 0) {
				List<String> list1 = new ArrayList<>();
				list1.add(strs[i]);
				list.add(list1);
			} else {
				int a = 0;
				for (List<String> l : list) {
					if (isSame(l.get(0), strs[i])) {
						a = 1;
						l.add(strs[i]);
					}
				}
				if (a == 0) {
					List<String> list1 = new ArrayList<>();
					list1.add(strs[i]);
					list.add(list1);
				}
			}
		}
		return list;
	}

	public static boolean isSame(String str, String str1) {
		int a[] = new int[26];
		if (str.length() != str1.length())
			return false;
		else {
			for (int i = 0; i < str.length(); i++) {
				a[str.charAt(i) - 'a']++;
				a[str1.charAt(i) - 'a']--;
			}
			for (int i = 0; i < 26; i++) {
				if (a[i] != 0)
					return false;
			}
			return true;
		}
	}
}
