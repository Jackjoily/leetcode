package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import edu.princeton.cs.algs4.In;

/**
 * 
 * @author jackjoily
 *
 */
public class M_165 {
	public static void main(String[] args) {
		System.out.println(compareVersion("0.1", "1.1"));
	}

	public static int compareVersion(String version1, String version2) {
		String[] split = version1.split("\\.");
		String[] split1 = version2.split("\\.");
		int i = 0, j = 0;
		while (i < split.length && j < split1.length) {
			char[] c = split[i].toCharArray();
			int k = 0;
			for (; k < c.length;) {
				if (c[k] == '0') {
					k++;
				} else {
					break;
				}
			}
			String str = "";
			if (k == c.length) {
				str = "0";
			} else {
				str = new String(c, k, c.length - k);
			}
			char[] c1 = split1[i].toCharArray();
			int k1 = 0;
			for (; k1 < c1.length;) {
				if (c1[k1] == '0') {
					k1++;
				} else {
					break;
				}
			}
			String str1 = "";
			if (k1 == c1.length) {
				str1 = "0";
			} else {
				str1 = new String(c1, k1, c1.length - k1);
			}
			int res = Integer.valueOf(str);
			int res1 = Integer.valueOf(str1);
			int compareTo = res - res1;
			if (compareTo == 0) {
				i++;
				j++;
				continue;
			} else if (compareTo > 0) {
				return 1;
			} else {
				return -1;
			}
		}
		while (i < split.length) {
			String s = split[i];
			for (int l = 0; l < s.length(); l++) {
				if (s.charAt(l) >= '1' && s.charAt(l) <= '9') {
					return 1;
				}
			}
			i++;
		}
		while (j < split1.length) {
			String s1 = split1[j];
			for (int l = 0; l < s1.length(); l++) {
				if (s1.charAt(l) >= '1' && s1.charAt(l) <= '9') {
					return -1;
				}
			}
			j++;
		}
		return 0;
	}

}
