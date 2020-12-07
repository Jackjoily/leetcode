package leetcode_day;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 *
 *
 *
 * 给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。
 * 
 * 如果不能形成任何面积不为零的三角形，返回 0。
 *
 *
 *
 *
 *
 */
public class E_976 {
	public static void main(String[] args) {
		E_976 e = new E_976();
		int a[] = { 8, 20, 34, 74, 23, 20, 8, 32, 46, 13, 46, 22, 41, 16, 35, 38, 199, 45, 12, 46, 3, 19, 11, 31, 25,
				46, 28, 6, 20, 13, 12 };
		Arrays.sort(a);
		System.out.println(e.largestPerimeter(a));
	}

	public int largestPerimeter(int[] a) {
		Arrays.sort(a);
		try {
			f(a, a.length - 1);
		} catch (RuntimeException e) {
			return temp == -1 ? 0 : temp;
		}
		return 0;
	}

	LinkedList<Integer> list = new LinkedList<>();
	int temp = 0;

	public void f(int a[], int start) {
		if (list.size() == 3) {
			temp = zhouchang(list.get(0), list.get(1), list.get(2));
			if (temp != -1) {
				throw new RuntimeException();
			}
		}
		for (int i = start; i >= 0; i--) {
			if (list.size() == 2) {
				if (list.get(0) + list.get(1) > a[i] && list.get(0) - list.get(1) < a[i]) {
					list.add(a[i]);
					start = i - 1;
					f(a, start);
					list.removeLast();
				} else {
					return;
				}
			} else {
				list.add(a[i]);
				start = i - 1;
				f(a, start);
				list.removeLast();
			}

		}
	}

	public int zhouchang(int a, int b, int c) {
		if ((a + b) > c && (a + c) > b && (b + c) > a) {
			return (a + b + c);
		}
		return -1;
	}

}
