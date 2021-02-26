package JianZhiOffer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import basic.Node;

/**
 * 
 * 输入一个字符串，打印出该字符串中字符的所有排列。 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * 
 * 
 * @author jackjoily
 *
 */
public class JianZhiOffer38 {
	public static void main(String[] args) {
		String str = "ava";
		JianZhiOffer38 j = new JianZhiOffer38();
		System.out.println(Arrays.toString(j.permutation(str)));
	}

	Set<String> set = new HashSet<>();

	public String[] permutation(String s) {
		if (s.length() == 0)
			return new String[0];
		else if (s.length() == 1)
			return new String[] { s };
		StringBuilder sb = new StringBuilder();
		boolean flag[] = new boolean[s.length()];
		f(s, sb, flag);
		String str[] = new String[set.size()];
		int i = 0;
		Iterator<String> iterator = set.iterator();
		while (iterator.hasNext()) {
			str[i] = iterator.next();
			i++;
		}
		return str;
	}

	public void f(String s, StringBuilder sb, boolean flag[]) {
		if (s.length() == sb.length()) {
			set.add(sb.toString());
			return;
		}
		for (int i = 0; i < s.length(); i++) {
			if (i > 0) {
				// aa情况的
				if (s.charAt(i) == s.charAt(i - 1) && !flag[i - 1] && !flag[i]) {
					continue;
				}
			}
			if (!flag[i]) {
				sb.append(s.charAt(i));
				flag[i] = true;
				f(s, sb, flag);
				flag[i] = false;
				sb.deleteCharAt(sb.length() - 1);
			}
		}
	}

}
