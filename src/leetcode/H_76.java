package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

/**
 * twosum
 * 
 * @author jackjoily
 *
 */
public class H_76 {
	public static void main(String[] args) {
		H_76 h = new H_76();
		System.out.println(h.minWindow(
				"amesukmiidgcgrknjqdezewypwihxfaxrfpnrewbhcenuqdfggjimhgdfokeumbnttbkxzogbsvxiacqi", 
				"nyuwe"));
	}

	public String minWindow(String s, String t) {
		char[] charArray = t.toCharArray();
		char[] c2 = s.toCharArray();
		Map<Character, Integer> need = new HashMap<>();
		Map<Character, Integer> has = new HashMap<>();
		for (char c : charArray) {
			need.put(c, need.getOrDefault(c, 0) + 1);
		}
		int left1 = 0;
		int right1 = 0;
		int left = 0;
		int right = 0;
		int max = Integer.MAX_VALUE;
		int count = 0;
		while (right < s.length()) {
			count = 0;
			if (need.containsKey(c2[right])) {
				int val = has.getOrDefault(c2[right], 0) + 1;
				has.put(c2[right], val);
				if (val >= need.get(c2[right])) {
					while (count == need.size() || isOKay(need, has)) {
						count = need.size();
						if (max > right - left + 1) {
							max = right - left + 1;
							left1 = left;
							right1 = right;
						}
						if (has.containsKey(c2[left])) {
							int val1 = has.get(c2[left]);
							if (val1 - 1 == 0) {
								has.remove(c2[left]);
								count--;
							} else if (val1 - 1 < need.get(c2[left])) {
								has.put(c2[left], val1 - 1);
								count--;
							}
						}
						left++;
					}
					right++;
				} else {
					right++;
				}
			} else {
				right++;
			}
		}
		if (max == Integer.MAX_VALUE) {
			return "";
		}
		return s.substring(left1, right1 + 1);
	}

	public boolean isOKay(Map<Character, Integer> need, Map<Character, Integer> has) {
		if (need.size() != has.size())
			return false;
		for (char c : need.keySet()) {
			if (need.get(c) > has.get(c))
				return false;
		}
		return true;
	}
}
