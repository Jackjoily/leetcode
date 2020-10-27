package leetcode_array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 不包含重复数字的全排列
 * 
 * @author jackjoily
 *
 */
public class M_46 {
	List<List<Integer>> list = new ArrayList<>();

	public static void main(String[] args) {
		M_46 m = new M_46();
		int a[] = { 1, 2, 3 };

	}

	public List<List<Integer>> permute(int[] nums) {
		if (nums.length == 0)
			return list;
		boolean used[] = new boolean[nums.length];
		f(nums, 0, 0, used);
		return list;
	}

	LinkedList<Integer> clist = new LinkedList<>();

	public void f(int[] nums, int count, int cur, boolean used[]) {
		if (nums.length == count) {
			list.add(new LinkedList<>(clist));
		}
		for (int i = 0; i < nums.length; i++) {
			if (!used[i]) {
				clist.add(nums[i]);
				used[i] = true;
				f(nums, count + 1, i + 1, used);
				clist.removeLast();
				used[i] = false;
			}
		}

	}

}
