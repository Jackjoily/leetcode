package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;

import javafx.scene.shape.Line;
import leetcode_list.ListNode;
import leetcode_tree.TreeNode;

/**
 * 
 * 随机打乱牌组的顺序
 * 
 * @author jackjoily
 *
 */
public class M_384 {
	class Solution {
		private int[] array;
		private int[] original;

		Random rand = new Random();

		private int randRange(int min, int max) {
			return rand.nextInt(max - min) + min;
		}

		private void swapAt(int i, int j) {
			int temp = array[i];
			array[i] = array[j];
			array[j] = temp;
		}

		public Solution(int[] nums) {
			array = nums;
			original = nums.clone();
		}

		public int[] reset() {
			array = original;
			original = original.clone();
			return original;
		}

		public int[] shuffle() {
			for (int i = 0; i < array.length; i++) {
				swapAt(i, randRange(i, array.length));
			}
			return array;
		}
	}
}
