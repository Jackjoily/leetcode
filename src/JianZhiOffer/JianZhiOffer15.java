package JianZhiOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 找出数组中重复的数字。
 * 
 * 请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。 例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入
 * 9，则该函数输出 2。
 * 
 * 
 * @author jackjoily
 *
 */
public class JianZhiOffer15 {
	public static void main(String[] args) {
		System.out.println(hammingWeight(11));
	}

	public  static int hammingWeight(int n) {
		int i = 0;
		int count = 0;
		while (i < 32) {
			if ((n & 1) == 1)
				count++;
			i++;
			n >>= 1;
		}
		return count;
	}

}
