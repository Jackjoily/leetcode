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
public class E_169 {
	public int majorityElement(int[] nums) {
		int flag = 0;
		int val = 0;
		for (int i = 0; i < nums.length; i++) {
			if (flag == 0) {
				val = nums[i];
			} else {
				if (nums[i] == val)
					flag++;
				else {
					flag--;
				}
			}
		}
		return val;
	}
}