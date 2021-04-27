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

import com.oracle.webservices.internal.api.databinding.Databinding;

import javafx.scene.shape.Line;
import leetcode_list.ListNode;
import leetcode_tree.TreeNode;

/**
 * 
 * @author jackjoily
 *
 */
public class M_739 {
	public static void main(String[] args) {
		int a[]= {73, 74, 75, 71, 69, 72, 76, 73};
		System.out.println(dailyTemperatures(a));
	}

	public static int[] dailyTemperatures(int[] T) {
		if (T.length <= 1) {
			return new int[] { 0 };
		}
		int a[] = new int[T.length];
		Stack<Integer> s = new Stack<>();
		s.add(0);
		for (int i = 1; i < T.length; i++) {
			while (!s.isEmpty() && T[s.peek()] < T[i]) {
				int pop = s.pop();
				a[pop] = i - pop;
			}
			s.add(i);
		}
		return a;
	}
}
