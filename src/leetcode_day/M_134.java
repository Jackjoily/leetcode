package leetcode_day;

import leetcode_list.ListNode;

public class M_134 {
	/**
	 * 
	 * 
	 * 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
	 * 
	 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
	 * 
	 * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
	 * 
	 */
	public static void main(String[] args) {
		int gas[] = { 3, 3, 4 };
		int cost[] = { 3, 4, 4 };
		System.out.println(canCompleteCircuit(gas, cost));
	}

	public static int canCompleteCircuit(int[] gas, int[] cost) {
		if (gas.length == 0 && cost.length == 0)
			return 1;
		int k = 0;
		int init = 0;
		int i = 0;
		while (i < gas.length) {
			init = gas[i];
			int temp = i;
			k=0;
			while (k < gas.length && init >= cost[i]) {
				init -= cost[i];
				i++;
				if (i == gas.length) {
					i = 0;
				}
				init += gas[i];
				k++;
			}
			if (k == gas.length)
				return temp;
			i = temp + 1;
		}
		return -1;
	}
}
