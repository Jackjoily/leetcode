package leetcode_array;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 涉及到动态规划
 * 
 * @author jackjoily
 *
 */
public class M_39 {
	public static void main(String[] args) {
		M_39 m = new M_39();
		int a[] = { 2, 3, 5 };

		System.out.println(m.set);
	}
	
	List<List<Integer>> list = new ArrayList<>();
	Set<LinkedList<Integer>> set = new HashSet<>();

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		if (candidates.length == 0)
			return list;
		f(candidates, 0, 0, target);
		set.forEach(x->list.add(x));
		return list;
	}



	LinkedList<Integer> clist = new LinkedList<>();

	public void f(int a[], int cur, int sum, int target) {
		if (sum == target) {
			LinkedList<Integer> linkedList = new LinkedList<>(clist);
			Collections.sort(linkedList);
			set.add(linkedList);
			return;
		} else if (sum > target) {
			return;
		}
		for (int i = 0; i < a.length; i++) {
			clist.add(a[i]);
			sum += a[i];
			f(a, i + 1, sum, target);
			sum -= a[i];
			clist.removeLast();
		}
	}
}
