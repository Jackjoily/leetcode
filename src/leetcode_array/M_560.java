package leetcode_array;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 给定一个整数数组和一个整数 k，你需要找到 该数组中和为 k 的连续的子数组的个数。
 * 
 * @author jackjoily
 *
 */
public class M_560 {
	public static void main(String[] args) {
		M_560 m = new M_560();
		int a[] = { 28, 54, 7, -70, 22, 65, -6, 100 };
		System.out.println(m.subarraySum(a, 100));
	}
	int temp = 0;
	int res = 0;
	public int subarraySum(int[] nums, int k) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == k) {
				res++;
			}
			temp = 0;
			temp += nums[i];
			for (int j = i + 1; j < nums.length; j++) {
				temp += nums[j];
				if (temp > k) {
					break;
				}
				if (temp == k) {
					res++;
				}
			}
		}
		return res;
	}

}
