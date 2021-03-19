package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import javafx.scene.shape.Line;
import leetcode_list.ListNode;
import leetcode_tree.TreeNode;

/**
 * 
 * @author jackjoily
 *
 */
public class M_547 {
	public static void main(String[] args) {
            int a[][]=
            	{{1,0,0,0,0,0,0,0,0,1,0,0,0,0,0},
            			{0,1,0,1,0,0,0,0,0,0,0,0,0,1,0},
            			{0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
            			{0,1,0,1,0,0,0,1,0,0,0,1,0,0,0},
            			{0,0,0,0,1,0,0,0,0,0,0,0,1,0,0},
            			{0,0,0,0,0,1,0,0,0,0,0,0,0,0,0},
            			{0,0,0,0,0,0,1,0,0,0,0,0,0,0,0},
            			{0,0,0,1,0,0,0,1,1,0,0,0,0,0,0},
            			{0,0,0,0,0,0,0,1,1,0,0,0,0,0,0},
            			{1,0,0,0,0,0,0,0,0,1,0,0,0,0,0},
            			{0,0,0,0,0,0,0,0,0,0,1,0,0,0,0},
            			{0,0,0,1,0,0,0,0,0,0,0,1,0,0,0},
            			{0,0,0,0,1,0,0,0,0,0,0,0,1,0,0},
            			{0,1,0,0,0,0,0,0,0,0,0,0,0,1,0},
            			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,1}};
            System.out.println(findCircleNum(a));
	}
	public static int findCircleNum(int[][] isConnected) {
		int n = isConnected.length;
		Queue<Integer> q = new LinkedList<Integer>();
		int count = 0;
		boolean flag[] = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (!flag[i]) {
				Set<Integer> set = new HashSet<>();
				set.add(i);
				q.add(i);
				while (!q.isEmpty()) {
					int k = q.poll();
					flag[k] = true;
					for (int j = 0; j < n; j++) {
						if (isConnected[k][j] == 1) {
							if (!set.contains(j)) {
								q.add(j);
								set.add(j);
							}
						}
					}
				}
				count++;
			}
		}
		return count;
	}
}
