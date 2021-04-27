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
public class E_628 {
	public static void main(String[] args) {
		int a[] = {-710,-107,-851,657,-14,-859,278,-182,-749,718,-640,127,-930,-462,694,969,143,309,904,-651,160,451,-159,-316,844,-60,611,-169,-73,721,-902,338,-20,-890,-819,-644,107,404,150,-219,459,-324,-385,-118,-307,993,202,-147,62,-94,-976,-329,689,870,532,-686,371,-850,-186,87,878,989,-822,-350,-948,-412,161,-88,-509,836,-207,-60,771,516,-287,-366,-512,509,904,-459,683,-563,-766,-837,-333,93,893,303,908,532,-206,990,280,826,-13,115,-732,525,-939,-787};
		System.out.println(maximumProduct(a));
	}

	public static int maximumProduct(int[] nums) {
		int n = nums.length;
		if (n < 3)
			return 0;
		if (n == 3)
			return nums[0] * nums[1] * nums[2];
		Arrays.sort(nums);
		if (nums[0] >= 0) {
			return nums[n - 1] * nums[n - 2] * nums[n - 3];
		}
		if (nums[n - 1] < 0) {
			return nums[n - 1] * nums[n - 2] * nums[n - 3];
		}
		if (nums[0] < 0 && nums[1] < 0) {
			return Math.max(nums[0] * nums[1] * nums[n - 1], nums[n-2] * nums[n-1] * nums[n-3]);
		}
		if (nums[0] < 0 && nums[1] > 0) {
			return nums[n-2] * nums[n-1] * nums[n-3];
		}
		return 0;
	}
}
