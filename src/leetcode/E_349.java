package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author jackjoily
 *
 */
public class E_349 {
	public static void main(String[] args) {
	}

	public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < nums1.length; i++) {
			set.add(nums1[i]);
		}
		Set<Integer> set1 = new HashSet<>();
		for (int i = 0; i < nums2.length; i++) {
			set1.add(nums2[i]);
		}
		return getIntersection(set, set1);
	}

	public int[] getIntersection(Set<Integer> set1, Set<Integer> set2) {
		if (set1.size() > set2.size()) {
			return getIntersection(set2, set1);
		}
		Set<Integer> intersectionSet = new HashSet<Integer>();
		for (int num : set1) {
			if (set2.contains(num)) {
				intersectionSet.add(num);
			}
		}
		int[] intersection = new int[intersectionSet.size()];
		int index = 0;
		for (int num : intersectionSet) {
			intersection[index++] = num;
		}
		return intersection;
	}

}
