package leetcode_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * 
 * candidates 中的每个数字在每个组合中只能使用一次
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author jackjoily
 *
 */
public class M_40 {

	public static void main(String[] args) {
		M_40 m = new M_40();
		int a[] = { 1, 1, 2, 5, 6, 7, 10 };
		System.out.println(m.combinationSum2(a, 8));
	}

	int m;
	List<List<Integer>> res = new ArrayList<>();

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		if (candidates.length == 0)
			return res;
		Arrays.sort(candidates);
		this.m = target;
		LinkedList<Integer> list = new LinkedList<>();
		f(candidates,0, 0, list);
		Set<List<Integer>> set = new HashSet<>();
		set.addAll(res);
		res = new ArrayList<List<Integer>>(set);
		return res;
	}

	public void f(int a[], int cur, int sum, LinkedList<Integer> list) {
		if (sum == m) {
			res.add(new ArrayList<Integer>(list));
			return;
		} else if (sum > m) {
			return;
		}
		for (int i = cur; i < a.length; i++) {
			list.add(a[i]);
			sum += a[i];
			f(a, i + 1, sum, list);
			list.removeLast();
			sum-=a[i];
		}
	}
}
