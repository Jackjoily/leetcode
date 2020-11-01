package JianZhiOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 * 
 * 示例:
 * 
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3 输出: [3,3,5,5,6,7] 解释:
 * 
 * 
 * @author jackjoily
 *
 */
public class JianZhiOffer59_I {
	public static void main(String[] args) {
		int a[] = { 1,-1};
		int k = 1;
		maxSlidingWindow(a, k);
	}

	public static int[] maxSlidingWindow(int[] nums, int k) {
		if (nums.length == 0)
			return new int[0];
		if (nums.length == k) {
			int max = nums[0];
			for (int i = 1; i < nums.length; i++) {
				if (max < nums[i]) {
					max = nums[i];
				}
			}
			return new int[] { max };
		}
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < nums.length - k + 1; i++) {
			int max = nums[i];
			for (int j = i + 1; j < i + k; j++) {
				if (max < nums[j])
					max = nums[j];
			}
			list.add(max);
		}
		int a[] = new int[list.size()];
		for (int l = 0; l < list.size(); l++) {
			a[l] = list.get(l);
		}
		return a;
	}
}
