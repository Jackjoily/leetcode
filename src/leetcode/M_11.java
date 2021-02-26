package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import leetcode_list.ListNode;

/**
 * 
 * @author jackjoily
 *
 */
public class M_11 {
	public int maxArea(int[] height) {
		int n = height.length;
		if (n == 2)
			return Math.min(height[0], height[1]) * 1;
		int left = 0, right = n - 1;
		int max = 0;
		while (left < right) {
			 int i = right - left + 1;
			if (height[left] < height[right]) {
				
				max = Math.max(height[left]*i,max);
				left++;
			} else {
				max = Math.max(height[right]*i,max);
				right--;
			}
		}
		return max;
	}
}
