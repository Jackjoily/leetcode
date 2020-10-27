package leetcode_tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author jackjoily 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。 请注意，它是排序后的第 k
 *         小元素，而不是第 k 个不同的元素。
 */
public class M_378 {
	public static void main(String[] args) {
		int [][]a= {
		           {1,5,9},
		           {10,11,13},
		           {12,13,15}
		};
		System.out.println(kthSmallest(a,8));
	}

	public static int kthSmallest(int[][] matrix, int k) {
		List<Integer> list = new ArrayList<>();
		for (int[] is : matrix) {
			for (Integer integer : is) {
				list.add(integer);
			}
		}
		Collections.sort(list);
		return list.get(k-1);
	}

}
