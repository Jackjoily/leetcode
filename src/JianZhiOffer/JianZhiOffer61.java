package JianZhiOffer;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，
 * 可以看成任意数字。A 不能视为 14。
 * 
 * 
 * 
 * @author jackjoily
 *
 */
public class JianZhiOffer61 {
	public static void main(String[] args) {
		int a[] = { 0, 0, 1, 2, 5 };
		System.out.println(isStraight(a));
	}

	public static boolean isStraight(int[] nums) {
		Arrays.sort(nums);
		int count = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] == 0) {
				count++;
				continue;
			}
			if ((nums[i + 1] - nums[i]) == 0)
				return false;
			if (count == 0) {
				if ((nums[i + 1] - nums[i]) > 1)
					return false;
			} else {
				if ((nums[i + 1] - nums[i]) > 2) {
					count -= (nums[i + 1] - nums[i] - 1);
				}
			}
		}
		if (count >= 0)
			return true;
		else
			return false;
	}
}
