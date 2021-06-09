package leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * twosum
 * 
 * @author jackjoily
 *
 */
public class H_135 {
	public static void main(String[] args) {
		int a[] = {1,3,2,2,1};
		System.out.println(candy(a));
	}

	public static int candy(int[] ratings) {
		int n = ratings.length;
		int left[] = new int[n];
		int right[] = new int[n];
		int res = 0;
		for (int i = 0; i < n; i++) {
			if (i == 0) {
				left[0] = 1;
			} else {
				if (ratings[i] > ratings[i - 1]) {
					left[i] = left[i - 1] + 1;
				} else {
					left[i] = 1;
				}
			}
		}
		right[n - 1] = 1;
		res += Math.max(left[n - 1], right[n - 1]);
		for (int i = n - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1]) {
				right[i] = right[i + 1] + 1;
			} else {
				right[i] = 1;
			}
			res += Math.max(left[i], right[i]);
		}
		return res;
	}
}
