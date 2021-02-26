package leetcode_dp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import edu.princeton.cs.algs4.In;

/**
 * 
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * 
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 
 * 示例 1:
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author jackjoily
 *
 */
public class H_123 {
	public int maxProfit(int[] prices) {
		int len = prices.length;
		if (len == 0)
			return 0;
		// buy[i][j] {0~i}，恰好进行了j笔交易的时候，拥有最高收入，持有一只股票
		int buy[][] = new int[len][3];
		// buy[i][j] {0~i}，恰好进行了j笔交易的时候，拥有最高收入，没有股票的时候
		int sell[][] = new int[len][3];
		buy[0][0] = -prices[0];
		sell[0][0] = 0;
		for (int i = 1; i <= 2; i++) {
			buy[0][i] = sell[0][i] = Integer.MIN_VALUE / 2;
		}
		for (int i = 1; i < len; i++) {
			buy[i][0] = Math.max(buy[i - 1][0], sell[i - 1][0] - prices[i]);
			for (int j = 1; j <= 2; j++) {
				buy[i][j] = Math.max(buy[i - 1][j], sell[i - 1][j] - prices[i]);
				sell[i][j] = Math.max(sell[i - 1][j], buy[i - 1][j - 1] + prices[i]);
			}
		}
		return Arrays.stream(sell[len - 1]).max().getAsInt();
	}
}
