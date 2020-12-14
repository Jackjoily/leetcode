package leetcode_day;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import edu.princeton.cs.algs4.In;

/**
 *
 *
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 *
 *
 *
 *
 */
public class E_7 {
	public  static int reverse(int x) {
		StringBuilder sb = new StringBuilder();
		if (x > 0) {
			String str = String.valueOf(x);
			sb.append(str);
			String string = sb.reverse().toString();
			long l = Long.valueOf(string);
			if (l > Integer.MAX_VALUE)
				return 0;
			return (int) l;
		} else if (x < 0) {
			String str = String.valueOf(x);
			sb.append(str.substring(1, str.length()));
			String string = sb.reverse().toString();
			string = "-" + string;
			long l = Long.valueOf(string);
			if (l < Integer.MIN_VALUE)
				return 0;
			return (int) l;
		} else {
			return 0;
		}
	}
}
