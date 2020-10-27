package leetcode_day;

import java.util.Arrays;

public class E_1365 {
	public static void main(String[] args) {
		E_1365 e = new E_1365();
		int a[]= {6,5,4,8};
		int[] smallerNumbersThanCurrent = e.smallerNumbersThanCurrent(a);
	System.out.println(Arrays.toString(smallerNumbersThanCurrent));
	}

	public int[] smallerNumbersThanCurrent(int[] nums) {
		int dp[] = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] > nums[j])
					dp[i]++;
				else if (nums[i] < nums[j]) {
					dp[j]++;
				}
			}
		}
		return dp;
	}
}
