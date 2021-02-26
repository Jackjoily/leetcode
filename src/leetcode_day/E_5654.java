package leetcode_day;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 *
 *
 *
 *
 *
 *
 */
public class E_5654 {

	public static void main(String[] args) {
		System.out.println(countBalls(1,10));
	}

	public static int countBalls(int lowLimit, int highLimit) {
		if(lowLimit==highLimit) {
			return 1;
		}
		int max = 0;
		int bounarys[] = new int[46];
		int index = 0;
		for (int i = lowLimit; i <= highLimit; i++) {
			if(max<++bounarys[getSum(i)]) {
				max=bounarys[getSum(i)];
				index=i;
			}
		}
		return max;
	}

	public static int getSum(int val) {
		int res = 0;
		while (val != 0) {
			res += val % 10;
			val /= 10;
		}
		return res;
	}
}
