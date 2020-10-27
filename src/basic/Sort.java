package basic;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;


public class Sort {

	public static int aux[];

	public static void main(String[] args) {
		int a[] = new int[80000];
		for (int i = 0; i < 80000; i++) {
			a[i] = (int) Math.random() * 80000;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		System.out.println(sdf.format(new Date()));
		quickSort(a, 0, a.length-1);
		System.out.println(sdf.format(new Date()));
	}

	/**
	 * 选择排序
	 * 
	 * @param a
	 */
	public static void selectSort(int a[]) {
		int min = 0;
		int temp = 0;
		int index = 0;
		for (int i = 0; i < a.length; i++) {
			index = i;
			min = a[i];
			for (int j = i + 1; j < a.length; j++) {
				if (min > a[j]) {
					min = a[j];
					index = j;
				}
			}
			temp = min;
			a[index] = a[i];
			a[i] = temp;
		}

	}

	/**
	 * 插入排序
	 * 
	 * @param a
	 */
	public static void insertSort(int a[]) {
		for (int i = 1; i < a.length; i++) {
			int j = i;
			int temp = a[i];
			while (j > 0 && temp < a[j - 1]) {
				a[j] = a[j - 1];
				j--;
			}
			a[j] = temp;

		}
	}

	/**
	 * 二路归并排序
	 * 
	 * @param a
	 * @param low
	 * @param high
	 */
	public static void mergeSort(int a[], int low, int high) {
		if (low < high) {
			int mid = (low + high) / 2;
			mergeSort(a, low, mid);
			mergeSort(a, mid + 1, high);
			merge(a, low, mid, high);
		}
	}

	public static void merge(int a[], int low, int mid, int high) {
		int k, i, j;
		for (k = low; k <= high; k++) {
			aux[k] = a[k];
		}
		for (i = low, j = mid + 1, k = i; i <= mid && j <= high; k++) {
			if (aux[i] >= aux[j]) {
				a[k] = aux[j];
				j++;
			} else {
				a[k] = aux[i];
				i++;
			}
		}
		while (i <= mid) {
			a[k] = aux[i];
			k++;
			i++;
		}
		while (j <= high) {
			a[k] = aux[j];
			k++;
			j++;
		}
	}

	/**
	 * 冒泡排序
	 * 
	 * @param a
	 */
	public static void bubbleSort(int a[]) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length - 1; j++) {
				if (a[j] > a[j + 1]) {
					swap(a, j, j + 1);
				}
			}

		}
	}

	public static void swap(int a[], int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void quickSort(int a[], int low, int high) {
		if (low < high) {
			int pivot = partition(a, low, high);
			quickSort(a, low, pivot - 1);
			quickSort(a, pivot + 1, high);

		}

	}

	private static int partition(int a[], int low, int high) {
		int pivot = a[low];
		while (low < high) {
			while (low < high && a[high] >= pivot)
				high--;
			a[low] = a[high];
			while (low < high && a[low] <= pivot)
				low++;
			a[high] = a[low];
		}
		a[low] = pivot;
		return low;
	}

	public static int binarySearch(int a[], int val, int low, int high) {
		if (low > high)
			return 0;
		int mid = (low + high) / 2;
		if (val == a[mid])
			return a[mid];
		else if (val < a[mid])
			return binarySearch(a, val, low, mid - 1);
		else
			return binarySearch(a, val, mid + 1, high);
	}

	/**
	 * 交换式希尔排序
	 */
	public static void shellSort(int a[]) {
		int temp = 0;
		// 第一轮排序,将数据以k/2为步长
		for (int k = a.length / 2; k > 0; k = k / 2) {
			for (int i = k; i < a.length; i++) {
				// 遍历各组中的所有的元素（共五组，每组有两个元素），步长为5
				for (int j = i - k; j >= 0; j -= k) {
					if (a[j] > a[j + k]) {
						temp = a[j];
						a[j] = a[j + k];
						a[j + k] = temp;
					}
				}
			}
		}
	}

	public static void shellSort1(int a[]) {
		// 第一轮排序,将数据以k/2为步长
		for (int k = a.length / 2; k > 0; k = k / 2) {
			// 从gap个元素开始进行插入排序
			for (int i = k; i < a.length; i++) {
				int j = i;
				int temp = a[j];
				if (a[j] < a[j - k]) {
					while (j - k >= 0 && temp <= a[j - k]) {
						a[j] = a[j - k];
						j -= k;
					}
					// 当退出while后
					a[j] = temp;
				}

			}

		}

	}

	/**
	 * 编写堆排序
	 */
	public static void heapSort(int arr[]) {
		adjustHeap(arr, arr.length);
		for (int i = arr.length; i >= 1; i--) {
			int temp = arr[i - 1];
			arr[i - 1] = arr[0];
			arr[0] = temp;
			adjustHeap(arr, i - 1);
		}
	}

	/**
	 * 完成将以I对应的非叶子节点的树调整成大顶堆
	 * 
	 * @param arr
	 * @param i   页子节点的索引
	 * @param len 待调整元素的个数
	 */
	public static void adjustHeap(int[] a, int len) {

		// 左子节点
		for (int i = len / 2; i >= 0; i--) {
			int temp = a[i];
			for (int k = i * 2 + 1; k < len; k = k * 2 + 1) {
				// 左子节的值小于右子节点
				if (k + 1 < len && a[k] < a[k + 1]) {
					k++;
				}
				if (a[k] > temp) {
					a[i] = a[k];
					i = k;// 继续向下循环
				} else {
					break;
				}
			}
			a[i] = temp;
		}

		// 当for循环结束后，我们已经将以i为父节点的树的最大值，放在了最顶上(局部)
	}

}
