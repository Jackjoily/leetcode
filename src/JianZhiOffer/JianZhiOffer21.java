package JianZhiOffer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 找出数组中重复的数字。
 * 
 * 
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序， 使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * 
 * 
 * @author jackjoily
 *
 */
public class JianZhiOffer21 {
	public static void main(String[] args) {
		JianZhiOffer21 j = new JianZhiOffer21();
		int a[] = {1,2,3,4,5,6};
		System.out.println(Arrays.toString(exchange(a)));
	}

	public static int[] exchange(int[] nums) {
		if (nums.length == 1)
			return nums;
		int i = 0, j = nums.length - 1;
		for (i = 0; i < nums.length; i++) {
			if (nums[i] % 2 == 0) {
				int temp = nums[i];
				while (j >i && (nums[j] % 2)== 0)	j--;
				nums[i] = nums[j];
				nums[j] = temp;
			}
		}
		return nums;
	}
}
