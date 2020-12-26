package leetcode_day;

import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import leetcode_list.ListNode;

/**
 * 
 * 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
 * 
 * （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/monotone-increasing-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author jackjoily
 *
 */
public class M_738 {
	public static void main(String[] args) {
		System.out.println(monotoneIncreasingDigits(200000));
	}

	public static int monotoneIncreasingDigits(int N) {
		char[] arr = (N + "").toCharArray();
		int max = -1, idx = -1;
		for (int i = 0; i < arr.length - 1; i++) {
			if (max < arr[i]) {
				max = arr[i];
				idx = i;
			}
			if (arr[i] > arr[i + 1]) {
				arr[idx] -= 1;
				for (int j = idx + 1; j < arr.length; j++) {
					arr[j] = '9';
				}
				break;
			}
		}
		return Integer.parseInt(new String(arr));
	}
}
