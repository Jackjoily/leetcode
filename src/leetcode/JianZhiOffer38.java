package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

/**
 * twosum
 * 
 * @author jackjoily
 *
 */
public class JianZhiOffer38 {
	public static void main(String[] args) {
		String str = "1123";
		char[] charArray = str.toCharArray();
		f(charArray, 0, charArray.length);
		// Solution.recurse(charArray, null, 0);
	}

	public String[] permutation(String s) {
		return null;
	}

	public static void f(char c[], int k, int len) {
		if (k == len - 1) {
			System.out.println(Arrays.toString(c));
			return;
		}
		Set<Character> set = new HashSet<>();
		for (int i = k; i < len; i++) {
			if (set.contains(c[i]))
				continue;
			set.add(c[i]);
			swap(c, k, i);
			f(c, k + 1, len);
			swap(c, k, i);
		}
	}

	public static void swap(char c[], int i, int j) {
		char temp = c[i];
		c[i] = c[j];
		c[j] = temp;
	}
}

class Solution {
	public String[] permutation(String s) {
		char[] raw = s.toCharArray();
		List<String> ret = new LinkedList<>();
		recurse(raw, ret, 0);
		return ret.toArray(new String[ret.size()]);
	}

	static void recurse(char[] raw, List<String> ret, int level) {
		if (level == raw.length - 1) {
			// ret.add(String.valueOf(raw));
			System.out.println(Arrays.toString(raw));
			return;
		}
		Set<Character> set = new HashSet<>();
		for (int i = level; i < raw.length; ++i) {
			// 如果和之前的交换重复了，那就跳过
			if (set.contains(raw[i]))
				continue;
			set.add(raw[i]);
			swap(raw, level, i);
			recurse(raw, ret, level + 1);
			swap(raw, level, i);
		}
	}

	static void swap(char[] raw, int i, int j) {
		char tmp = raw[i];
		raw[i] = raw[j];
		raw[j] = tmp;
	}
}
