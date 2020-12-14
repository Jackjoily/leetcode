package leetcode_string;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 
 * 
 * 给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。 字符串 text
 * 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"
 * 
 * @author jackjoily
 *
 */
public class E_1189 {
	public static void main(String[] args) {
		System.out.println(maxNumberOfBalloons("nlaebolk"));
	}

	// balon
	public static int maxNumberOfBalloons(String text) {
		int a[] = new int[5];
		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) == 'b') {
				a[0]++;
			} else if (text.charAt(i) == 'a') {
				a[1]++;
			} else if (text.charAt(i) == 'l') {
				a[2]++;
			} else if (text.charAt(i) == 'o') {
				a[3]++;
			} else if (text.charAt(i) == 'n') {
				a[4]++;
			}
		}
		int min = Integer.MAX_VALUE;
		a[2] = a[2] / 2;
		a[3] = a[3] / 2;
		for (int i = 0; i < a.length; i++) {
			min = Math.min(min, a[i]);
		}
		return min;
	}

}
