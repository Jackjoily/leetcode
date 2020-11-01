package JianZhiOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。 求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * 
 * 答案需要取模 1e9+7（1000000007）， 如计算初始结果为：1000000008，请返回 1。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 * 
 * @author jackjoily
 *
 */
public class JianZhiOffer10_II {
	public static void main(String[] args) {
	}

	public int numWays(int n) {
		if (n <= 2)
			return n;
		int a = 1, b = 2, c = 0;
		for (int i = 3; i <= n; i++) {
			c = (a + b) % 1000000007;
			a = b;
			b = c;
		}
		return c;
	}
}
