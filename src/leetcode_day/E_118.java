package leetcode_day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 *
 *
 *
 *
 *
 */
public class E_118 {
	public static void main(String[] args) {
		System.out.println(generate(5));
	}

	public static List<List<Integer>> generate(int numRows) {

		List<List<Integer>> list = new ArrayList<>();
		if (numRows == 0)
			return list;
		List<Integer> list1 = new ArrayList<>();
		list1.add(1);
		list.add(list1);
		if (numRows == 1)
			return list;
		list1 = new ArrayList<>();
		list1.add(1);
		list1.add(1);
		list.add(list1);
		if (numRows == 2)
			return list;
		for (int i = 3; i <= numRows; i++) {
			list1 = new ArrayList<>();
			list1.add(1);
			List<Integer> list2 = list.get(i - 2);
			for (int k = 1; k < list2.size(); k++) {
				list1.add(list2.get(k - 1) + list2.get(k));
			}
			list1.add(1);
			list.add(list1);
		}
		return list;
	}
}
