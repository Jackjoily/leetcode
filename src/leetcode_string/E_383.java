package leetcode_string;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines
 * 里面的字符构成。如果可以构成，返回 true ；否则返回 false。
 * 
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。)
 * 
 * 
 * @author jackjoily
 *
 */
public class E_383 {
	public static void main(String[] args) {
		System.out.println(canConstruct("bg", "efjbdfbdgfjhhaiigfhbaejahgfbbgbjagbddfgdiaigdadhcfcj"));
	}

	public static boolean canConstruct(String ransomNote, String magazine) {
		char[] ransom = ransomNote.toCharArray();
		char[] mag = magazine.toCharArray();
		Map<Character, Integer> set = new HashMap<>();
		for (Character c : ransom) {
			if (set.containsKey(c)) {
				set.put(c, set.get(c) + 1);
			} else {
				set.put(c, 1);
			}
		}
		Map<Character, Integer> set1 = new HashMap<>();
		for (Character m : mag) {
			if (set1.containsKey(m)) {
				set1.put(m, set1.get(m) + 1);
			} else {
				set1.put(m, 1);
			}
		}
		for (Entry<Character, Integer> aa : set.entrySet()) {
			if (!set1.containsKey(aa.getKey())) {
				return false;
			}
			if (aa.getValue() > set1.get(aa.getKey())) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 使用桶排序
	 * 
	 * @param ransomNote
	 * @param magazine
	 * @return
	 */
	public boolean canConstruct1(String ransomNote, String magazine) {
		int[] bucket = new int[26];
		// 首先将magazine中各元素分配到桶中
		for (int i = 0; i < magazine.length(); i++) {
			char ch = magazine.charAt(i);
			bucket[ch - 'a']++;
		}
		// 从桶中取出元素，与ransomNote中的元素匹配
		for (int i = 0; i < ransomNote.length(); i++) {
			char ch = ransomNote.charAt(i);
			if (--bucket[ch - 'a'] < 0)
				return false;
		}
		return true;
	}

}