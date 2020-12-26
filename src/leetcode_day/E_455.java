package leetcode_day;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。 对每个孩子
 * i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j] 。如果 s[j] >=
 * g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 *
 *
 *
 *
 */
public class E_455 {
	public static void main(String[] args) {
		int a[] = { 1, 2 };
		int s[] = { 1, 2,3 };
		System.out.println(findContentChildren(a, s));
	}

	public static int findContentChildren(int[] g, int[] s) {
		if (s.length == 0)
			return 0;
		Arrays.sort(g);
		Arrays.sort(s);
		int j = 0;
		int i = 0;
		int temp = 0;
		for (i = 0; i < g.length; i++) {
			if (j >= s.length) {
				break;
			}
			for (; j < s.length; j++) {
				if (g[i] <= s[j]) {
					j++;
					temp++;
					break;
				}
			}
		}
		return temp;
	}
}
