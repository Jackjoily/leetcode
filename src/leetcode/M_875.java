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
public class M_875 {

	public static void main(String[] args) {
		int[] piles = { 312884470 };
		System.out.println(minEatingSpeed(piles,312884469));
	}

	public static int minEatingSpeed(int[] piles, int h) {
		int n = piles.length;
		int max = piles[0];
		for (int i = 1; i < n; i++) {
			if (max < piles[i])
				max = piles[i];
		}
		int min = 1;
		while (min < max) {
			int mid = (max - min) / 2 + min;
			if (canFinshed(piles, mid, h)) {
				max = mid;
			} else {
				min = mid + 1;
			}
		}
		return min;
	}

	public static boolean canFinshed(int[] piles, int speed, int h) {
		int hour = 0;
		for (int i = 0; i < piles.length; i++) {
			int a = piles[i] % speed;
			if (a == 0) {
				hour += piles[i] / speed;
			} else {
				hour += piles[i] / speed + 1;
			}
		}
		return hour <= h ? true : false;
	}
}
