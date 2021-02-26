package leetcode_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 
 * 在未排序的数组中找到第 k 个最大的元素。 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 
 * @author jackjoily
 *
 */
public class M_215 {
	public static void main(String[] args) {
		int a[] = { 9,8,71,2,3,4,5,6,7,12,846,321,4568,8744 };
		System.out.println(findKthLargest(a, 3));
	}

	public static int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for (int i = 0; i < k; i++) {
			q.add(nums[i]);
		}
		for (int i = k; i < nums.length; i++) {
			if (nums[i] > q.peek()) {
				q.poll();
				q.add(nums[i]);
			}
		}
		return q.peek();
	}
}
