package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

/**
 * twosum
 * 
 * @author jackjoily
 *
 */
public class JianZhiOffer40 {
	public int[] getLeastNumbers(int[] arr, int k) {
		int n = arr.length;
		int a[] = new int[k];
		if (n == 0 || n < k || k == 0)
			return a;
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2 - o1;
			}
		});
		int i = 0;
		for (i = 0; i < k; i++) {
			pq.add(arr[i]);
		}
		for (; i < n; i++) {
			if (arr[i] < pq.peek()) {
				pq.poll();
				pq.add(arr[i]);
			}
		}
		for (i = 0; i < k; i++) {
			a[i] = pq.poll();
		}
		return a;
	}
}
