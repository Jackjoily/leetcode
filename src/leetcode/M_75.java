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
public class M_75 {
	public static void main(String[] args) {
		int a[] = { 2, 0, 2, 1, 1, 0 };
		M_75 m = new M_75();
		m.sortColors(a);
	}

	public void sortColors1(int[] nums) {
		int m = nums.length;
		if (m == 1)
			return;
		int p0 = 0, p1 = 0;
		for (int i = 0; i < m; i++) {
			if (nums[i] == 0) {
				swap(nums, p0, i);
				p0++;
				p1++;
			} else if (nums[i] == 1) {
				swap(nums, p1, i);
				p1++;
			} else {

			}
		}
	}

	public void sortColors(int[] nums) {
		int m = nums.length;
		if (m == 1)
			return;
		int left = -1;
		int right = -1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				for (int j = i + 1; j < nums.length; j++) {
					if (nums[j] == 0) {
						swap(nums, i, j);
						left++;
						break;
					}
				}
			}
		}
		for (int i = nums.length - 1; i > left; i--) {
			if (nums[i] != 2) {
				for (int j = i - 1; j > left; j--) {
					if (nums[j] == 2) {
						swap(nums, i, j);
						break;
					}
				}
			}
		}

	}

	public void swap(int a[], int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}
