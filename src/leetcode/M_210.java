package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import javafx.scene.shape.Line;
import leetcode_list.ListNode;
import leetcode_tree.TreeNode;

/**
 * 
 * @author jackjoily
 *
 */
public class M_210 {
	public static void main(String[] args) {
		M_210 m = new M_210();
		int a[][] = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
		System.out.println(Arrays.toString(m.findOrder1(4, a)));
	}

	List<List<Integer>> edges;
	int index[];
	int[] visited;
	boolean flag = true;
	int b[];
	int inx = 0;
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		edges = new ArrayList<>();
		index = new int[numCourses];
		b = new int[numCourses];
		for (int i = 0; i < numCourses; i++) {
			edges.add(new ArrayList<>());
		}
		visited = new int[numCourses];
		for (int a[] : prerequisites) {
			edges.get(a[0]).add(a[1]);
			index[a[1]]++;
		}
		for (int i = 0; i < numCourses && flag; i++) {
			if (visited[i] == 0) {
				dfs(i);
			}
		}
		if (flag) {
			return b;
		} else {
			return new int[0];
		}
	}

	public void dfs(int i) {
		visited[i] = 1;
		for (int e : edges.get(i)) {
			if (visited[e] == 0) {
				dfs(e);
				if (!flag) {
					return;
				}
			} else if (visited[e] == 1) {
				flag = false;
				return;
			}
		}
		visited[i] = 2;
		b[inx++] = i;
	}

	public int[] findOrder1(int numCourses, int[][] prerequisites) {
		edges = new ArrayList<>();
		inx = numCourses - 1;
		index = new int[numCourses];
		b = new int[numCourses];
		for (int i = 0; i < numCourses; i++) {
			edges.add(new ArrayList<>());
		}
		visited = new int[numCourses];
		for (int a[] : prerequisites) {
			edges.get(a[0]).add(a[1]);
			index[a[1]]++;
		}
		int cnt = 0;
		Queue<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < numCourses; i++) {
			if (index[i] == 0) {
				q.add(i);
			}
		}
		while (!q.isEmpty()) {
			int n = q.poll();
			b[inx--] = n;
			cnt++;
			for (int e : edges.get(n)) {
				index[e]--;
				if (index[e] == 0) {
					q.add(e);
				}
			}
		}
		if (cnt == numCourses) {
			return b;
		} else {
			return new int[0];
		}
	}

}
