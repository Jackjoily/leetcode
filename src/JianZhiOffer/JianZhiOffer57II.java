package JianZhiOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列 （至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。 来源：力扣（LeetCode）
 * 
 * @author jackjoily
 *
 */
public class JianZhiOffer57II {

	public static void main(String[] args) {
		JianZhiOffer57II j = new JianZhiOffer57II();
		// j.f(50252);
		j.c(9);
	}

	LinkedList<Integer> list = new LinkedList<>();
	ArrayList<LinkedList<Integer>> list1 = new ArrayList<>();

	public int[][] findContinuousSequence(int target) {
		if (target <= 2) {
			return new int[0][0];
		}
		int a[] = new int[target];
		for (int i = 0; i < a.length; i++) {
			a[i] = i + 1;
		}
		ArrayList<int[]> f = f(target);
		int c[][] = new int[f.size()][];
		for (int i = 0; i < f.size(); i++) {
			c[i] = f.get(i);
		}
		return c;
	}

	public void f(int sum, int target, int start) {
		if (sum == target && list.size() >= 2) {
			list1.add(new LinkedList<>(list));
			return;
		}
		if (sum > target)
			return;
		for (int i = start; i <= target / 2 + 1; i++) {
			if (list.size() != 0) {
				if (list.getLast() + 1 != i) {
					continue;
				} else {
					sum += i;
					list.add(i);
					f(sum, target, i + 1);
					sum -= i;
					list.removeLast();
				}
			} else {
				sum += i;
				list.add(i);
				f(sum, target, i + 1);
				sum -= i;
				list.removeLast();
			}

		}

	}

	public void c(int target) {
		int i = 1;
		int j = 1;
		int sum = 0;
		while (i <= target / 2) {
			if (sum < target) {
				sum += j;
				j++;
			} else if (sum > target) {
				sum -= i;
				i++;
			} else {
				for (int k = i; k <j; k++) {
					System.out.print(k + ",");
				}
				System.out.println();
				sum -= i;
				i++;
			}
		}
	}

	public ArrayList<int[]> f(int target) {
		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<int[]> list1 = new ArrayList<>();
		for (int i = 1; i <= target / 2 + 1; i++) {
			int sum = 0;
			for (int j = i;; j++) {
				sum += j;
				list.add(j);
				if (sum == target) {
					System.out.println(list);
					int[] d = new int[list.size()];
					for (int k = 0; k < list.size(); k++) {
						d[k] = list.get(k);
					}
					list1.add(d);
					list = new ArrayList<>();
				} else if (sum > target) {
					list = new ArrayList<>();
					break;
				}
			}
		}
		return list1;
	}
}
