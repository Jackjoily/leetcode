package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

/**
 * twosum
 * 
 * @author jackjoily
 *
 */
public class E_496 {

	public static void main(String[] args) {
		int a[] = { 2,4 };
		int b[] = { 1, 2, 3, 4 };
		System.out.println(Arrays.toString(nextGreaterElement(a, b)));
	}

	public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
		int a[] = new int[nums1.length];
		Arrays.fill(a, -1);
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums1.length; i++) {
			map.put(nums1[i], i);
		}
		Stack<Integer> s = new Stack<>();
		for (int i = 0; i < nums2.length; i++) {
			if (s.isEmpty()) {
				s.add(nums2[i]);
			} else {
				while (!s.isEmpty() && s.peek() < nums2[i]) {
					Integer pop = s.pop();
					if (map.containsKey(pop)) {
						a[map.get(pop)] = nums2[i];
					}

				}
				s.add(nums2[i]);
			}
		}
		return a;
	}
}
