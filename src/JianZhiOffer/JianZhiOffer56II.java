package JianZhiOffer;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。 请找出那个只出现一次的数字。
 * 
 * @author jackjoily
 *
 */
public class JianZhiOffer56II {
	public static void main(String[] args) {
	}

	public int singleNumber(int[] nums) {
		if (nums.length == 1)
			return nums[0];
		Map<Integer, Boolean> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				map.put(nums[i], false);
			} else {
				map.put(nums[i], true);
			}
		}
		Set<Entry<Integer, Boolean>> entrySet = map.entrySet();
		for (Entry<Integer, Boolean> entry : entrySet) {
			if (entry.getValue()) {
				return entry.getKey();
			}
		}
		return 0;
	}
}
