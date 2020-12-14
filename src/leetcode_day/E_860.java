package leetcode_day;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。
 * 
 * 顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
 * 
 * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
 * 
 * 注意，一开始你手头没有任何零钱。
 * 
 * 如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
 * 
 *
 *
 *
 *
 */
public class E_860 {
	public static void main(String[] args) {
		int a[] = {5,5,10,5,10,20};
		System.out.println(lemonadeChange(a));
	}

	public static boolean lemonadeChange(int[] bills) {
		if (bills[0] != 5)
			return false;
		int a[] = new int[3];
		for (int i = 0; i < bills.length; i++) {
			if (bills[i] == 5) {
				a[0]++;
			} else {
				if (bills[i] == 10) {
					if (a[0] == 0)
						return false;
					else {
						a[0]--;
						a[1]++;
					}
				} else {
					if (a[0] == 0) {
						return false;
					} else {
						if (a[1] == 0) {
							if (a[0] < 3)
								return false;
							else {
								a[0] -= 3;
								a[2]++;
							}
						} else {
							a[2]++;
							a[1]--;
							a[0]--;
						}
					}
				}
			}
		}
		return true;
	}
}
