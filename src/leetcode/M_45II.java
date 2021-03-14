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
public class M_45II {
	public static void main(String[] args) {
		int a[] = { 2, 1 };
		System.out.println(jump1(a));

	}

	public static int jump(int[] nums) {
		int step = 1;
		int pos = nums.length - 1;
		while (pos > 0) {
			for (int i = 0; i < pos; i++) {
				if (i + nums[pos] >= pos) {
					pos = i;
					step++;
					break;
				}
			}
		}
		return step;
	}

	public static int jump1(int[] nums) {
		int step = 0;
		int pos = nums.length - 1;
		int maxPos = 0;
		int end = 0;
		for (int i = 0; i < pos; i++) {
			maxPos = Math.max(maxPos, i + nums[i]);
			if (i == end) {
				end = maxPos;
				step++;
			}
		}
		return step;
	}
}
