package leetcode_sort;

import java.util.Arrays;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序， 使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。 [2,0,2,1,1,0] [0,0,1,1,2,2]
 * 
 * @author jackjoily
 *
 */
public class M_75 {
	public static void main(String[] args) {
		int nums[] = { 2, 0, 2, 1, 1, 0 };
		System.out.println(Arrays.toString(nums));
	}

	public void sortColors(int[] nums) {
		if (nums.length == 0)
			return;
		int p0 = 0, i = 0;
		for (; i < nums.length; i++) {
			if (nums[i] == 0) {
				if (p0 == i) {
					p0++;
				} else {
					int temp = nums[p0];
					nums[p0] = 0;
					nums[i] = temp;
					p0++;
				}
			}
		}
		for (i = p0; i < nums.length; i++) {
			if (nums[i] == 1) {
				if (p0 == i) {
					p0++;
				} else {
					int temp = nums[p0];
					nums[p0] = 1;
					nums[i] = temp;
					p0++;
				}
			}
		}

	}

}
