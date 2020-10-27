package leetcode_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * 
 * @author jackjoily
 *
 */
public class M_47 {

	public static void main(String[] args) {
		M_47 m = new M_47();
		int a[] = { 3};
		System.out.println(m.permuteUnique(a));
	}

	List<List<Integer>> list = new ArrayList<>();

	public List<List<Integer>> permuteUnique(int[] nums) {
		if (nums.length == 0)
			return list;
		if (nums.length == 1) {
			List<Integer> alist = new ArrayList<Integer>();
			alist.add(nums[0]);
			list.add(alist);
			return list;
		}
	       boolean used[]=new boolean[nums.length];
	       Arrays.sort(nums);
	        f(nums,0,0,used);
			return list;
	}

	LinkedList<Integer> clist = new LinkedList<Integer>();

	public void f(int nums[], int count, int cur, boolean[] used) {
		// 进行减枝
		if (nums.length == count) {
//			System.out.println(clist);
			list.add(new LinkedList<>(clist));
		}
		for (int i = 0; i < nums.length; i++) {
			if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1] || used[i])
				continue;
			clist.add(nums[i]);
			used[i] = true;
			f(nums, count + 1, cur, used);
			clist.removeLast();
			used[i] = false;
		}

	}
}
