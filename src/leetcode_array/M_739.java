package leetcode_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0
 * 来代替。 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1,
 * 4, 2, 1, 1, 0, 0]。 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30,
 * 100] 范围内的整数。
 * 
 * @author jackjoily
 *
 */
public class M_739 {
	public static void main(String[] args) {
		int a[] = { 73, 74, 75, 71, 69, 72, 76, 73 };
		System.out.println(Arrays.toString(dailyTemperatures1(a)));
	}

	public static int[] dailyTemperatures(int[] T) {
		int a[] = new int[T.length];
		for (int i = T.length - 1; i >= 0; i--) {
			for (int j = i + 1; j < T.length; j++) {
				if (T[j] > T[i]) {
					a[i] = j - i;
					break;
				}
			}
		}
		return a;
	}

	/**
	 * 使用递减栈的方法
	 * 
	 * @param T
	 * @return
	 */
	public static int[] dailyTemperatures1(int[] T) {
		Stack<Integer> stack = new Stack<>();
		int length = T.length;
		int[] result = new int[length];
		for (int i = 0; i < length; i++) {
			while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
				int pre = stack.pop();
				result[pre] = i - pre;
			}
			stack.add(i);
		}
		return result;
	}
}
