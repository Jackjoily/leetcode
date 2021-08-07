package basic;

import java.util.Arrays;

import leetcode_list.ListNode;

public class Sort {
	public static void main(String[] args) {
		int[] gennerateArray = gennerateArray(20, 100);
		bubbleSort(gennerateArray);
		System.out.println(Arrays.toString(gennerateArray));
	}

	public static void sort(int a[]) {
		int temp[] = new int[101];
		for (int i = 0; i < a.length; i++) {
			temp[a[i]]++;
		}
		for (int i = 0; i < 101; i++) {
			if (temp[i] > 0) {
				for (int j = 0; j < temp[i]; j++) {
					System.out.print(i + " ");
				}
				System.out.println();
			}
		}

	}

	public static int[] gennerateArray(int len, int max) {
		int[] arr = new int[len];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * max);
		}
		return arr;
	}

	/**
	 * 冒泡算法
	 * 
	 * @param a
	 */
	public static void bubbleSort(int a[]) {
		for (int i = 0; i < a.length - 1; i++) {
			boolean flag = false;
			for (int j = 0; j < a.length - 1 - i; j++) {
				if (a[j] > a[j + 1]) {
					swap(a, j, j + 1);
					flag = true;
				}
			}
			if (!flag) {
				break;
			}
		}
	}

	/**
	 * 插入排序算法
	 * 
	 * @param a
	 * @param low
	 * @param high
	 */

	public static void quickSort(int a[], int low, int high) {
		if (low < high) {
			int inx = partition(a, low, high);
			quickSort(a, low, inx - 1);
			quickSort(a, inx + 1, high);
		}
	}

	public static int partition(int a[], int low, int high) {
		int temp = a[low];
		while (low < high) {
			while (low < high && a[high] >= temp)
				high--;
			a[low] = a[high];
			while (low < high && a[low] <= temp)
				low++;
			a[high] = a[low];
		}
		a[low] = temp;
		return low;
	}

	/**
	 * 归并排序算法
	 * 
	 * @param a
	 * @param low
	 * @param high
	 * @param temp
	 */
	public static void mergeSort(int a[], int low, int high, int temp[]) {
		if (low < high) {
			int mid = (high + low) / 2;
			mergeSort(a, low, mid, temp);
			mergeSort(a, mid + 1, high, temp);
			merge(a, low, mid, high, temp);
		}
	}

	public static void merge(int a[], int low, int mid, int high, int temp[]) {
		int i, k, j;
		for (i = low; i <= high; i++) {
			temp[i] = a[i];
		}
		for (i = low, j = mid + 1, k = low; i <= mid && j <= high;) {
			if (temp[i] < temp[j]) {
				a[k++] = temp[i++];
			} else {
				a[k++] = temp[j++];
			}
		}
		while (i <= mid) {
			a[k++] = temp[i++];
		}
		while (j <= high) {
			a[k++] = temp[j++];
		}
	}

	public static void swap(int a[], int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public ListNode mergerListNode(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode slow = head;
		ListNode fast = head.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode temp = slow.next;
		slow.next = null;
		ListNode left = mergerListNode(head);
		ListNode right = mergerListNode(temp);
		ListNode res = new ListNode(0);
		ListNode root = res;
		while (left != null && right != null) {
			if (left.val < right.val) {
				res.next = left;
				left = left.next;
			} else {
				res.next = right;
				right = right.next;
			}
			res = res.next;
		}
		res.next = left == null ? right : left;
		return root.next;
	}

}
