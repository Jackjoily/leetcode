package leetcode_dp;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import edu.princeton.cs.algs4.In;

/**
 * 在一个火车旅行很受欢迎的国度，你提前一年计划了一些火车旅行。在接下来的一年里，你要旅行的日子将以一个名为 days 的数组给出。每一项是一个从 1 到 365 的整数。
 * 
 * 火车票有三种不同的销售方式：
 * 
 * 一张为期一天的通行证售价为 costs[0] 美元； 一张为期七天的通行证售价为 costs[1] 美元； 一张为期三十天的通行证售价为 costs[2]
 * 美元。 通行证允许数天无限制的旅行。 例如，如果我们在第 2 天获得一张为期 7 天的通行证，那么我们可以连着旅行 7 天：第 2 天、第 3 天、第 4
 * 天、第 5 天、第 6 天、第 7 天和第 8 天。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/minimum-cost-for-tickets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author jackjoily
 *
 */
public class M_983 {
	public static void main(String[] args) {
		M_983 m = new M_983();
		int days[] = { 1, 4, 6, 7, 8, 20 };
		int costs[] = { 2, 7, 15 };
		System.out.println(m.mincostTickets(days, costs));
	}

	Integer memo[];
	HashSet<Integer> set;
	int[] costs;
	int[] days;
	int day[] = { 1, 7, 30 };
	//
	// public int mincostTickets(int[] days, int[] costs) {
	// memo = new Integer[366];
	// set = new HashSet<>();
	// this.costs = costs;
	// for (int x : days) {
	// set.add(x);
	// }
	// return dp(1);
	// }
	//
	// public int dp(int i) {
	// if (i > 365) {
	// return 0;
	// }
	// if (memo[i] != null) {
	// return memo[i];
	// }
	// if (set.contains(i)) {
	// memo[i] = Math.min(Math.min(dp(i + 1) + costs[0], dp(i + 7) + costs[1]), dp(i
	// + 30) + costs[2]);
	// } else {
	// memo[i] = dp(i + 1);
	// }
	// return memo[i];
	// }

	/**
	 * 采用记忆窗口+动态规划
	 * @param days
	 * @param costs
	 * @return
	 */
	public int mincostTickets(int[] days, int[] costs) {
		memo = new Integer[days.length];
		this.costs = costs;
		this.days = days;
		return dp(0, days.length);
	}

	public int dp(int i, int len) {
		if (i >= len) {
			return 0;
		}
		if (memo[i] != null) {
			return memo[i];
		}
		memo[i] = Integer.MAX_VALUE;
		int j = i;
		for (int k = 0; k < 3; k++) {
			while (j < len && days[j] < days[i] + day[k]) {
				j++;
			}
			memo[i] = Math.min(memo[i], dp(j, len) + costs[k]);
		}
		return memo[i];
	}
}
