package leetcode_array;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author jackjoily 使用set进行交并补的操作
 * retainAll（）交	
 * addAll（）并
 * removeAll（）差
 */
public class E_349 {
	public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> set1 = new HashSet<>();
		for (Integer integer : nums1) {
			set1.add(integer);
		}
		Set<Integer> set2 = new HashSet<>();
		for (Integer integer : nums2) {
			set2.add(integer);
		}
		set1.retainAll(set2);
		int a[] = new int[set1.size()];
		int i = 0;
		for (Integer integer : set1) {
			a[i] = integer;
			i++;
		}
		return a;
	}
}
