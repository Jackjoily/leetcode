package leetcode_day;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数； 当 A[i] 为偶数时，
 * i 也是偶数。 你可以返回任何满足上述条件的数组作为答案。
 *
 */
public class E_922 {
	public static void main(String[] args) {
		E_922 e = new E_922();
		int a[] = { 4, 2, 5, 7 };
		int[] sortArrayByParityII = e.sortArrayByParityII(a);
		System.out.println(Arrays.toString(sortArrayByParityII));
	}

	public int[] sortArrayByParityII(int[] A) {
		int[] clone = A.clone();
		for (int j = 0, i = 0, k = 1; j < clone.length; j++) {
			if (clone[j] % 2 == 0) {
				A[i] = clone[j];
				i += 2;
			} else {
				A[k] = clone[j];
				k += 2;
			}
		}
		return A;
	}
}
