package leetcode_day;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
 * 
 * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
 * 
 * @author jackjoily
 *
 */
public class E_1207 {
	public static void main(String[] args) {
		E_1207 e = new E_1207();
		int a[] = { 1, 2 };
		boolean uniqueOccurrences = e.uniqueOccurrences(a);
		System.out.println(uniqueOccurrences);
	}

	public boolean uniqueOccurrences(int[] arr) {
		if (arr.length == 1)
			return true;
		Arrays.sort(arr);
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (!map.containsKey(arr[i])) {
				map.put(arr[i], 1);
			} else {
				map.put(arr[i], map.get(arr[i]) + 1);
			}
		}
		Object[] array = map.values().toArray();
		Arrays.sort(array);
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] == array[i + 1])
				return false;
		}
		return true;
	}
}
