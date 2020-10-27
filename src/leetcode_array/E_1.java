package leetcode_array;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author jackjoily
 *
 */
public class E_1 {
	public int[] twoSum(int[] nums, int target) {
		if (nums.length == 0)
			return null;
		Map<Integer, Integer> map = new HashMap<>();
		int a[] = new int[2];
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				a[0] = i;
				a[1] = map.get(target - nums[i]);
				return a;
			}
			map.put(nums[i], i);
		}
		return a;
	}
}
