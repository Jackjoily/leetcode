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
public class M_338 {
	public int[] countBits(int num) {
		if (num == 0) {
			return new int[1];
		}
		int a[] = new int[num + 1];
		a[1] = 1;
		int k = 2;
		while (k < num) {
			a[k] = 1;
			for (int i = k + 1; i < num && i < 2 * k; i++) {
				a[i] = a[k] + a[i - k];
			}
			k = 2 * k;
		}
		return a;
	}

}
