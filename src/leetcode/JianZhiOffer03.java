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
public class JianZhiOffer03 {
	public static void main(String[] args) {
		int a[]= {2, 3, 1, 0, 2, 5, 3};
		System.out.println(findRepeatNumber(a));
	}
	
	public static  int findRepeatNumber(int[] nums) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			int index = (nums[i] - 1) % nums.length;
			nums[index] += nums.length;
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] <= nums.length) {
				list.add(i + 1);
			}
		}
		System.out.println(list);
		return 0;
	}
}
