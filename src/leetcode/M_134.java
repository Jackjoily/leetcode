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
public class M_134 {
	public static void main(String[] args) {
		int a[] = { 5,1,2,3,4 };
		int b[] = { 4,4,1,5,1 };
		System.out.println(canCompleteCircuit(a, b));
	}

	public static int canCompleteCircuit(int[] gas, int[] cost) {
		int n = gas.length;
		for (int i = 0; i < n; i++) {
			int val = 0;
			if (cost[i] <= gas[i]) {
				val += gas[i] - cost[i];
				int j = (i + 1) % n;
				while (j != i) {
					if ((val + gas[j]) < cost[j]) {
						break;
					} else {
						val = (val + gas[j]) - cost[j];
					}
					j = (j + 1) % n;
				}
				if ((val + gas[j]) >= cost[j]) {
					return i;
				}
			}
		}
		return -1;
	}
}
