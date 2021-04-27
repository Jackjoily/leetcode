package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

/**
 * twosum
 * 
 * @author jackjoily
 *
 */
public class JianZhiOffer61 {
	public static void main(String[] args) {
		int a[] = { 1, 2, 2, 4, 5 };
		System.out.println(isStraight(a));
	}

	public static boolean isStraight(int[] nums) {
		int o1 = 0;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				o1++;
				continue;
			}
			if (i > 0) {
				if (nums[i - 1] != 0) {
					int j = nums[i] - nums[i - 1];
					if (j > 1) {
						if (j - o1 <= 1) {
							o1-=j;
						} else {
							return false;
						}
					} else if (j == 1) {

					} else {
						if (nums[i] != 0)
							return false;
					}
				}
			}
		}
		return true;
	}
}
