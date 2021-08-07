package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
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
		int a[][] = { { 0, 1 } };
		System.out.println(canFinish(2, a));
	}

	static List<List<Integer>> edges;
	static int indegs[];
	static int visited[];
	static boolean flag = true;

	public static boolean canFinish1(int numCourses, int[][] prerequisites) {
		edges = new ArrayList<>();
		visited = new int[numCourses];
		for (int i = 0; i < numCourses; i++) {
			edges.add(new ArrayList<>());
		}
		for (int i = 0; i < prerequisites.length; i++) {
			edges.get(prerequisites[i][1]).add(prerequisites[i][0]);
		}
		for (int i = 0; i < numCourses; i++) {
			if (!flag) {
				break;
			}
			if (visited[i] == 0) {
				dfs(i);
			}
		}
		return flag;
	}

	public static void dfs(int u) {
		visited[u] = 1;
		for (int e : edges.get(u)) {
			if (visited[e] == 0) {
				dfs(e);
				if (!flag)
					return;
			} else if (visited[e] == 1) {
				flag = false;
			}
		}
		visited[u] = 2;
	}

	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		edges = new ArrayList<>();
		indegs = new int[numCourses];
		for (int i = 0; i < numCourses; i++) {
			edges.add(new ArrayList<>());
		}
		for (int i = 0; i < prerequisites.length; i++) {
			edges.get(prerequisites[i][1]).add(prerequisites[i][0]);
			indegs[prerequisites[i][0]]++;
		}
		Queue<Integer> q = new LinkedList<Integer>();
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
		return cnt == numCourses;
	}
}
