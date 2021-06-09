package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 
 * 这是一道典型的拓扑排序题目
 * 
 * @author jackjoily
 *
 */
public class M_207 {
	public static void main(String[] args) {
		int a[][] = { { 0,1 } };
		System.out.println(canFinish(2, a));
	}

	static List<List<Integer>> edges;
	static int indegs[];
	static int visited[];
	static boolean flag = true;

	public static boolean canFinish1(int numCourses, int[][] prerequisites) {
		edges = new ArrayList<>();
		indegs = new int[numCourses];
		for (int i = 0; i < numCourses; i++) {
			edges.add(new ArrayList<>());
		}
		for (int i = 0; i < prerequisites.length; i++) {
			edges.get(prerequisites[i][1]).add(prerequisites[i][0]);
			indegs[prerequisites[i][0]]++;
		}
		Queue<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < numCourses; i++) {
			if (indegs[i] == 0) {
				q.add(i);
			}
		}
		int cnt = 0;
		while (!q.isEmpty()) {
			int m = q.poll();
			cnt++;
			for (int n : edges.get(m)) {
				indegs[n]--;
				if (indegs[n] == 0) {
					q.add(n);
				}
			}
		}
		return cnt==numCourses;
	}

	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		edges = new ArrayList<>();
		visited = new int[numCourses];
		for (int i = 0; i < numCourses; i++) {
			edges.add(new ArrayList<>());
		}
		for (int i = 0; i < prerequisites.length; i++) {
			edges.get(prerequisites[i][1]).add(prerequisites[i][0]);
		}
		for (int i = 0; i < numCourses && flag; i++) {
			if (visited[i] == 0) {
				dfs(i);
			}
		}
		return flag;
	}

	private static void dfs(int i) {
		visited[i] = 1;
		for (int n : edges.get(i)) {
			if (visited[n] == 0) {
				dfs(n);
				if (!flag) {
					return;
				}
			} else if (visited[n] == 1) {
				flag = false;
				return;
			}
		}
		visited[i] = 2;
	}
}
