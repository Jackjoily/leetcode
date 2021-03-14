package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;
/**
 * twosum
 * 
 * @author jackjoily
 *
 */
public class H_239 {
	public static void main(String[] args) {
		H_239 h = new H_239();
		int a[] = { 7, 2, 4 };
		System.out.println(Arrays.toString(h.maxSlidingWindow1(a, 2)));
	}
	public int[] maxSlidingWindow1(int[] nums, int k) {
		LinkedList<Integer> q = new LinkedList<>();
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			while (q.size() > 0 && nums[q.peekLast() ]<= nums[i]) {
				q.pollLast();
			}
			q.add(i);
			if (q.peek() <= i - k) {
				q.poll();
			}
			if (i + 1 >= k) {
				list.add(nums[q.peek()]);
			}
		}
		int a[] = new int[list.size()];
		for (int i = 0; i < a.length; i++) {
			a[i] = list.get(i);
		}
		return a;
	}

	public int[] maxSlidingWindow(int[] nums, int k) {
		List<Integer> list = new ArrayList<>();
		int max = Integer.MIN_VALUE;
		int right = k - 1;
		for (int i = 0; i < k; i++) {
			max = Math.max(max, nums[i]);
		}
		list.add(max);
		right++;
		int left = 1;
		while (right < nums.length) {
			if (nums[left - 1] < max) {
				if (nums[right] <= max) {
				} else {
					max = nums[right];
				}
			} else {
				if (nums[right] > max) {
					max = nums[right];
				} else {
					max = max(nums, left, right);
				}
			}
			list.add(max);
			left++;
			right++;
		}
		int a[] = new int[list.size()];
		for (int i = 0; i < a.length; i++) {
			a[i] = list.get(i);
		}
		return a;
	}

	public int max(int a[], int left, int right) {
		int max = Integer.MIN_VALUE;
		for (int i = left; i <= right; i++) {
			max = Math.max(max, a[i]);
		}
		return max;
	}
}
