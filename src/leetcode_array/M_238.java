package leetcode_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ， 其中
 * output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 * 
 * @author jackjoily
 *
 */
public class M_238 {
	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(productExceptSelf(a)));
	}

	public static int[] productExceptSelf(int[] nums) {
		int[] res = new int[nums.length];
		int k = 1;
		for (int i = 0; i < res.length; i++) {
			res[i] = k;
			k = k * nums[i]; // 此时数组存储的是除去当前元素左边的元素乘积
		}
		k = 1;
		for (int i = res.length - 1; i >= 0; i--) {
			res[i] *= k; // k为该数右边的乘积。
			k *= nums[i]; // 此时数组等于左边的 * 该数右边的。
		}
		return res;
	}
}
