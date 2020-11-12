package JianZhiOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数， 打印能拼接出的所有数字中最小的一个。
 * 
 * 
 */
public class JianZhiOffer45 {
	public static void main(String[] args) {
		JianZhiOffer45 j = new JianZhiOffer45();
		int a[] = { 3, 4, 3, 4, 3, 4, 3, 4, 3, 4 };
		boolean flag[] = new boolean[a.length];
		j.minNumber(a);
	}

	String min;

	public String minNumber(int[] nums) {
		boolean flag[] = new boolean[nums.length];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < nums.length; i++) {
			sb.append("a");
		}
		min = sb.toString();
		f(nums, 0, flag);
		System.out.println(min);
		return min;
	}

	LinkedList<Integer> list = new LinkedList<>();
	List<String> list1 = new ArrayList<>();

	public void f(int a[], int count, boolean flag[]) {
		if (count == a.length) {
			StringBuilder sb = new StringBuilder();
			list.forEach(x -> sb.append(x));
			if (min.compareTo(sb.toString()) > 0) {
				min = sb.toString();
			}
			return;
		}
		for (int i = 0; i < a.length; i++) {
			if (list.size() == 0) {
				if (!flag[i] && min.compareTo(a[i] + "") > 0) {
					flag[i] = true;
					list.add(a[i]);
					f(a, count + 1, flag);
					list.removeLast();
					flag[i] = false;
				}
			} else {
				if (!flag[i]) {
					flag[i] = true;
					list.add(a[i]);
					f(a, count + 1, flag);
					list.removeLast();
					flag[i] = false;
				}
			}
		}
	}



	/**
	 * 官方的排序方法
	 * 
	 * @param nums
	 * @return
	 */
	public String minNumber1(int[] nums) {
		String[] strs = new String[nums.length];
		for (int i = 0; i < nums.length; i++)
			strs[i] = String.valueOf(nums[i]);
		Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
		StringBuilder res = new StringBuilder();
		for (String s : strs)
			res.append(s);
		return res.toString();
	}
}
