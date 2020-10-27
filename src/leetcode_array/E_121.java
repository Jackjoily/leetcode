package leetcode_array;

import java.util.LinkedList;

import com.sun.scenario.effect.impl.prism.PrCropPeer;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。 注意：你不能在买入股票前卖出股票。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author jackjoily
 *
 */
public class E_121 {

	public static void main(String[] args) {
		E_121 e = new E_121();
		int a[] = new int[10000];
		for (int i = 0; i < 10000; i++) {
			a[i] = i + 1;
		}
		e.f(a, 0, 0);
		System.out.println(e.max);
	}

	public int maxProfit(int[] prices) {
		if (prices.length == 0 || prices.length == 1) {
			return 0;
		}
		int minprice = Integer.MAX_VALUE;
		int maxprofit = 0;
		for (int i = 0; i < prices.length; i++) {
			if (minprice > prices[i])
				minprice = prices[i];
			else if (prices[i] - minprice > maxprofit)
				maxprofit = prices[i] - minprice;
		}
		return maxprofit;
	}

	LinkedList<Integer> list = new LinkedList<>();
	int max = Integer.MIN_VALUE;

	public void f(int prices[], int count, int cur) {
		if (count == 2) {
			System.out.println(list);
			return;
		}
		for (int i = cur; i < prices.length; i++) {
			if (list.size() == 0) {
				list.add(prices[i]);
				f(prices, count + 1, i + 1);
				list.removeLast();
			} else {
				if (list.peek() > prices[i])
					continue;
				else {
					max = Math.max(max, prices[i] - list.peek());
					list.add(prices[i]);
					f(prices, count + 1, i + 1);
					list.removeLast();
				}
			}
		}
	}
}
