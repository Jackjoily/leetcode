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
public class E_665 {
	public boolean checkPossibility(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			int x = nums[i], y = nums[i + 1];
			if (x> y) {
				nums[i] = y;
				if (isOkay(nums))
					return true;
				nums[i] = x;
				nums[i + 1] = x;
				return isOkay(nums);
			}
		}
		return true;
	}

	public boolean isOkay(int a[]) {
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] > a[i + 1])
				return false;
		}
		return true;
	}

}
