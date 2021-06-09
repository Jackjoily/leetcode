package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

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
		int a[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
		System.out.println(Arrays.toString(h.maxSlidingWindow2(a, 3)));
	}

	public int[] maxSlidingWindow1(int[] nums, int k) {
		List<Integer> list = new ArrayList<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		for (int i = 0; i < k; i++) {
			pq.add(nums[i]);
		}
		list.add(pq.peek());
		for (int i = k; i < nums.length; i++) {
			pq.remove(nums[i - k]);
			pq.add(nums[i]);
			list.add(pq.peek());
		}
		int a[] = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			a[i] = list.get(i);
		}
		return a;
	}

	public int[] maxSlidingWindow2(int[] nums, int k) {
		LinkedList<Integer> val = new LinkedList<>();
		int right = 0;
		int[] result = new int[nums.length - k + 1];
		int i = 0;
		while (right < nums.length) {
			while (!val.isEmpty() && nums[val.peekLast()] < nums[right]) {
				val.pollLast();
			}
			val.addLast(right);
			if (val.peek() <= right - k) {
				val.poll();
			}
			if (right + 1 >= k) {
				result[i++] = nums[val.peek()];
			}
			right++;
		}
		return result;
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
