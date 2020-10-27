package leetcode_tree;

/**
 * @ClassName M_1432
 * @Description
 * 
 * 				给你一个整数 num 。你可以对它进行如下步骤恰好 两次 ： 选择一个数字 x (0 <= x <= 9). 选择另一个数字 y
 *              (0 <= y <= 9) 。数字 y 可以等于 x 。 将 num 中所有出现 x 的数位都用 y 替换。 得到的新的整数
 *              不能 有前导 0 ，得到的新整数也 不能 是 0 。 令两次对 num 的操作得到的结果分别为 a 和 b 。 请你返回 a
 *              和 b 的 最大差值 。 来源：力扣（LeetCode）
 *              链接：https://leetcode-cn.com/problems/max-difference-you-can-get-
 *              from-changing-an-integer 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author Jackjoily
 * @Date 2020年6月26日 下午4:57:57
 */
public class M_1432 {
	public static void main(String[] args) {
		System.out.println(maxDiff(123456));
	}

	public static int maxDiff(int num) {
		char a[] = String.valueOf(num).toCharArray();
		char b[] = a.clone();
		if ((a[0] - '0') == 9) {
			char c = ' ';
			for (int i = 1; i < a.length; i++) {
				if ((a[i] - '0') != 9) {
					c = a[i];
					break;
				}

			}
			for (int i = 1; i < a.length; i++) {
				if (a[i] == c) {
					a[i] = '9';
				}
			}

		} else {
			char c = a[0];
			for (int i = 0; i < a.length; i++) {
				if (a[i] == c)
					a[i] = '9';
			}

		}
		if ((b[0] - '0') == 1) {
			char c = ' ';
			for (int i = 1; i < a.length; i++) {
				if ((b[i] - '0') != 0 && (b[i] - '0') != 1) {
					c = b[i];
					break;
				}

			}
			for (int i = 1; i < a.length; i++) {
				if (b[i] == c) {
					b[i] = '0';
				}
			}
		} else {
			char c = b[0];
			for (int i = 0; i < a.length; i++) {
				if (b[i] == c)
					b[i] = '1';
			}
		}
		return Integer.valueOf(String.valueOf(a)) - Integer.valueOf(String.valueOf(b));
	}
}
