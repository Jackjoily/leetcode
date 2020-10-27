package leetcode_tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * 给你一个二叉树的根结点，请你找出出现次数最多的子树元素和。一个结点的「子树元素和」定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。
 * 
 * 你需要返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。
 * 
 * @author jackjoily
 *
 */
public class M_508 {
	Map<Integer, Integer> map = new HashMap<>();
	int res = 0;
	boolean flag = true;

	public static void main(String[] args) {
		TreeNode n5 = new TreeNode(5);
		TreeNode n2 = new TreeNode(2);
		TreeNode n52 = new TreeNode(-3);
		n5.left = n2;
		n5.right = n52;
		M_508 m = new M_508();
		int[] findFrequentTreeSum = m.findFrequentTreeSum(n5);
		System.out.println(Arrays.toString(findFrequentTreeSum));

	}

	public int[] findFrequentTreeSum(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		if (root == null) {
			return new int[0];
		} else {
			dfs1(root);
			int max = Integer.MIN_VALUE;
			map.values();
			for (Integer b : map.values()) {
				if (b > max)
					max = b;
			}
			int i = 0;
			Object[] keySet = map.keySet().toArray();
			for (Integer b : map.values()) {
				if (b == max) {
					list.add((Integer) keySet[i]);
				}
				i++;
			}
			int a[] = new int[list.size()];
			for (int k = 0; k < list.size(); k++) {
				a[k] = list.get(k);
			}
			return a;
		}
	}

	public void dfs1(TreeNode root) {
		if (root != null) {
			dfs(root);
			if (map.containsKey(res)) {
				int n = map.get(res) + 1;
				map.put(res, n);
			} else {
				map.put(res, 1);
			}
			res = 0;
			dfs1(root.left);
			dfs1(root.right);
		}
	}

	public void dfs(TreeNode root) {
		if (root != null) {
			if (flag) {
				flag = false;
				dfs(root.left);
				res += root.val;
				dfs(root.right);
			} else {
				dfs(root.left);
				res += root.val;
				dfs(root.right);
			}

		}

	}

}
