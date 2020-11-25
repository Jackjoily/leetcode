package leetcode_day;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给你两个数组，arr1 和 arr2，
 * 
 * arr2 中的元素各不相同 arr2 中的每个元素都出现在 arr1 中 对 arr1  中的元素进行排序，使 arr1 中项的相对顺序和 
 * arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 *
 */
public class E_1122 {
	public static void main(String[] args) {
		E_1122 e = new E_1122();
		int arr1[] = { 2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19 };
		int arr2[] = { 2, 1, 4, 3, 9, 6 };

		relativeSortArray(arr1, arr2);
	}

	public static int[] relativeSortArray(int[] arr1, int[] arr2) {
		if (arr1.length == 0 || arr2.length == 0) {
			Arrays.sort(arr1);
			return arr1;
		}
		int i = 0, j = 0,k=0;
		while (j < arr2.length) {
			i=k;
			while (i < arr1.length) {
				while (i < arr1.length && arr1[i] == arr2[j]) {
					i++;
				}
				 k = i;
				while (i < arr1.length && arr1[i] != arr2[j]) {
					i++;
				}
				if (i < arr1.length) {
					int temp = arr1[k];
					arr1[k] = arr1[i];
					arr1[i] = temp;
					i = k + 1;
				}
			}
			j++;
		}
		Arrays.sort(arr1, k, arr1.length);
		return arr1;
	}
}
