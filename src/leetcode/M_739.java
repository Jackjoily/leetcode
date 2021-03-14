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

import javafx.scene.shape.Line;
import leetcode_list.ListNode;
import leetcode_tree.TreeNode;

/**
 * 
 * @author jackjoily
 *
 */
public class M_739 {
	public int[] dailyTemperatures(int[] T) {
		int a[] = new int[T.length];
		Stack<Integer> s = new Stack<>();
		for (int i = 0; i < T.length; i++) {
			if (s.isEmpty()) {
				s.add(i);
			} else {
				while (!s.isEmpty() && T[i] > T[s.peek()]) {
					a[s.peek()] = i-s.peek() ;
					s.pop();
				}
				s.push(i);
			}
		}
		return a;
	}
}
