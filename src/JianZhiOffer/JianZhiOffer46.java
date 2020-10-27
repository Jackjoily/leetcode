package JianZhiOffer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……， 11 翻译成 “l”，……，25 翻译成
 * “z”。一个数字可能有多个翻译。请编程实现一个函数， 用来计算一个数字有多少种不同的翻译方法。 TODO
 */
public class JianZhiOffer46 {
	public static void main(String[] args) {
		JianZhiOffer46 j = new JianZhiOffer46();
		int a[] = { 1, 2, 2, 5, 8 };
	}

	int count = 0;

	public int translateNum(int num) {
		String str = String.valueOf(num);
		int[] intArray = new int[str.length()];
		for (int i = 0; i < str.length(); i++) {
			Character ch = str.charAt(i);
			intArray[i] = Integer.parseInt(ch.toString());
		}
		f(intArray, 0);
		return count;
	}

	LinkedList<Integer> list = new LinkedList<>();

	public void f(int[] str, int start) {
		if (start == str.length && list.size() == str.length) {
			count++;
			return;
		}
		for (int i = start; i < str.length; i++) {
			list.add(str[i]);
			f(str, i + 1);
			list.removeLast();
			if (i + 1 < str.length) {
				int q = (str[i] * 10 + str[i + 1]);
				if (q <= 25) {
					list.add(str[i]);
					list.add(str[i + 1]);
					f(str, i + 2);
					list.removeLast();
					list.removeLast();
				}

			}

		}
	}
}
