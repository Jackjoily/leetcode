package JianZhiOffer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 
 * 输入整数数组 arr ，找出其中最小的 k 个数。 例如，输入4、5、1、6、2、7、3、8这8个数字， 则最小的4个数字是1、2、3、4。
 * 
 * @author jackjoily
 *
 */
public class JianZhiOffer40 {
	public static void main(String[] args) {
		JianZhiOffer40 j = new JianZhiOffer40();
		int a[] = { 3, 2, 1 };
		System.out.println(Arrays.toString(j.getLeastNumbers1(a, 2)));
	}

	public int[] getLeastNumbers(int[] arr, int k) {
		if (k > arr.length) {
			return new int[0];
		}
		if (k == arr.length) {
			return arr;
		}
		if (arr.length == 0) {
			return new int[0];
		}
		Arrays.sort(arr);
		int a[] = new int[k];
		for (int i = 0; i < k; i++) {
			a[i] = arr[i];
		}
		return a;
	}

	/**
	 * 使用优先级队列
	 */
	public int[] getLeastNumbers1(int[] arr, int k) {
		if (k == arr.length) {
			return arr;
		}
		if (arr.length == 0||k==0||k > arr.length) {
			return new int[0];
		}
		PriorityQueue<Integer> pq = new PriorityQueue(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2 - o1;
			}
		});
		int i, j;
		for (i = 0; i < k; i++) {
			pq.add(arr[i]);
		}
		for (j = i; j < arr.length; j++) {
			if (pq.peek() > arr[j]) {
				pq.poll();
				pq.add(arr[j]);
			}
		}
		int a[] = new int[k];
		int n = 0;
		while (pq.size() > 0) {
			a[n] = pq.poll();
			n++;
		}
		return a;
	}
}
