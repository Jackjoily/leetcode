package leetcode_array;

import java.util.Arrays;

/**
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 
 * 必须原地修改，只允许使用额外常数空间。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author jackjoily
 *
 */
public class M_31 {
	public static void main(String[] args) {
		int a[] = {1,3,2};
		M_31 m = new M_31();
		m.nextPermutation(a);
		System.out.println(Arrays.toString(a));
	}

	/**
	 * 字典序的下一个排列 以输入为 358764 为例，字典序算法的步骤： 1、从原排列中，从右至左，找到第一个左邻小于右邻的字符，记左邻位置为 a。 示例中
	 * a=1，list[a] = 5。 2、重新从右至左，找到第一个比 list[a] 大的字符，记为位置为 b。 示例中 b=4，list[b] = 6。
	 * 3、交换 a 和 b 两个位置的值。 示例变为了 368754。 4、将 a 后面的数，由小到大排列。 示例变为了 364578。
	 * 
	 * 算法结束，输出 364578。
	 * 
	 * @param nums
	 */
	public void nextPermutation(int[] nums) {
		if (nums.length == 0)
			return;
		if (nums.length == 1) {
			return;
		}
		int temp, i, j, k, l, temp1;
		boolean flag=false;;
		for (i = nums.length - 1; i >= 1; i--) {
			if (nums[i - 1] < nums[i]) {
				flag=true;
				for (l = nums.length - 1; l >= 0; l--) {
					if (nums[l] > nums[i - 1]) {
						temp1 = nums[l];
						nums[l] = nums[i - 1];
						nums[i - 1] = temp1;
						break;
					}
				}
				for (k = i; k < nums.length; k++) {
					for (j = i; j < nums.length - 1; j++) {
						if (nums[j] > nums[j + 1]) {
							temp = nums[j];
							nums[j] = nums[j + 1];
							nums[j + 1] = temp;
						}
					}
				}
				break;
			}
		}
		if(!flag) {
			Arrays.sort(nums);
		}
	}

}
