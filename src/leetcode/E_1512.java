package leetcode;

import java.util.Arrays;
import java.util.HashMap;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

/**
 * twosum
 * 
 * @author jackjoily
 *
 */
public class E_1512 {

	public int numIdenticalPairs(int[] nums) {
		if(nums.length==1)return 0;
		boolean used[] = new boolean[nums.length];
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			if (!used[i]) {
				int k = 0;
				used[i] = true;
				for (int j = i + 1; j < nums.length; j++) {
					if (nums[i] == nums[j]) {
						used[j] = true;
						k++;
					}
				}
				if (k != 0) {
					sum += factorial(k);
				}
			}
		}
		return sum;
	}

	public int factorial(int number) {
		int num = 0;
		if (number == 1)
			return 1;
		for (int i = 1; i <= number; i++) {
			num += i;
		}
		return num;
	}

}
