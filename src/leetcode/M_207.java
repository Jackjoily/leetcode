package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

import leetcode_tree.TreeNode;
import leetcode_tree.TreeUtils;

/**
 * 
 * 这是一道典型的拓扑排序题目
 * 
 * @author jackjoily
 *
 */
public class M_207 {

	List<List<Integer>> list;
	int visied[];
	boolean flag = true;

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		int n = prerequisites.length;
		visied = new int[numCourses];
		for (int i = 0; i < numCourses; i++) {
			list.add(new ArrayList<>());
		}
		for (int i = 0; i < n; i++) {
			list.get(prerequisites[i][0]).add(prerequisites[i][1]);
		}
		for (int i = 0; i < numCourses; i++) {
			if (visied[i] == 0) {
				dfs(i);
			}
		}
		return flag;
	}

	public void dfs(int u) {
		visied[u] = 1;
		for (int k : list.get(u)) {
			if (visied[k] == 0) {
				dfs(k);
				if (!flag)
					return;
			} else if (visied[k] == 1) {
				flag = false;
				return;
			}
		}
		visied[u] = 2;
	}
}
