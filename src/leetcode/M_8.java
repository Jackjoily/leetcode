package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import leetcode_list.ListNode;

/**
 * 
 * @author jackjoily
 *
 */
public class M_8 {
	public int myAtoi(String s) {
		char[] c = s.toCharArray();
		if (c.length == 0)
			return 0;
		int i = 0;
		int val = 0;
		while (i < c.length && c[i] == ' ')
			i++;
		if (c[i] == '-') {
			i++;
			while (i < c.length && c[i] >= '0' && c[i] <= '9') {
				if (val > Integer.MAX_VALUE / 10 || (val == Integer.MAX_VALUE / 10 && c[i] - '0' > 7)) {
					return Integer.MIN_VALUE;
				}
				val = val * 10 + c[i] - '0';
				i++;
			}
			val = -val;
		} else if (c[i] == '+') {
			i++;
			while (i < c.length && c[i] >= '0' && c[i] <= '9') {
				if (val > Integer.MAX_VALUE / 10 || (val == Integer.MAX_VALUE / 10 && c[i] - '0' > 7)) {
					return Integer.MAX_VALUE;
				}
				val = val * 10 + c[i] - '0';
				i++;
			}
		} else {
			while (i < c.length && c[i] >= '0' && c[i] <= '9') {
				if (val > Integer.MAX_VALUE / 10 || (val == Integer.MAX_VALUE / 10 && c[i] - '0' > 7)) {
					return Integer.MAX_VALUE;
				}
				val = val * 10 + c[i] - '0';
				i++;
			}
		}
		return val;
	}
}
