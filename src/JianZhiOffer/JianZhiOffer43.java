package JianZhiOffer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 * 
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 * 
 */
public class JianZhiOffer43 {
	public static void main(String[] args) {
		JianZhiOffer43 j = new JianZhiOffer43();
		System.out.println(	j.countDigitOne(824883294));
	}

	public int countDigitOne(int n) {
		if (n < 10)
			return 1;
		int k=1;
		for (int i = 10; i < n+1; i++) {
			k= (k + count(i));
		}
		return k;
	}

	public int count(int n) {
		String s = String.valueOf(n);
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '1')
				count++;
		}
		return count;
	}
}
