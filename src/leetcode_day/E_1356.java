package leetcode_day;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给你一个整数数组 arr 。 请你将数组中的元素按照其二进制表示中数字 1 的数目升序排序。
 * 如果存在多个数字二进制中 1 的数目相同，则必须将它们按照数值大小升序排列。 请你返回排序后的数组。
 * 
 * @author jackjoily
 *
 */
public class E_1356 {
	public static void main(String[] args) {
		E_1356 e = new E_1356();
		int a[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };
		int[] sortByBits = e.sortByBits(a);
		System.out.println(Arrays.toString(sortByBits));
	}

	public int[] sortByBits(int[] arr) {
		if (arr.length <= 1)
			return arr;
		Integer b[] = new Integer[arr.length];
		for (int i = 0; i < b.length; i++) {
			b[i] = arr[i];
		}
		Arrays.sort(b, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				int a = bitCount(o1);
				int b = bitCount(o2);
				if ((a - b) == 0) {
					return o1 - o2;
				} else {
					return a - b;
				}
			}
		});
		for (int i = 0; i < b.length; i++) {
			arr[i] = b[i];
		}
		return arr;
	}

	public static int bitCount(int n) {
		n = n - ((n >>> 1) & 0x55555555);
		n = (n & 0x33333333) + ((n >>> 2) & 0x33333333);
		n = (n + (n >>> 4)) & 0x0f0f0f0f;
		n = (n + (n >>> 8)) & 0x00FF00FF;
		return n % 255;
	}
}
