package basic;

public class BinarySort {
	public static void main(String[] args) {
		int a[] = new int[] { 1, 2, 2, 2, 3, 3, 3, 4, 4, 5, 6, 7, 8, 9, 10 };
		System.out.println(binarySort2(0, a.length - 1, a, 9));
	}

	public static int binarySort(int start, int end, int a[], int val) {
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (a[mid] == val) {
				return mid;
			} else if (a[mid] > val) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}

	/**
	 * 寻找最>=val最左边的数字
	 * 
	 * @param start
	 * @param end
	 * @param a
	 * @param val
	 * @return
	 */
	public static int binarySort1(int start, int end, int a[], int val) {
		int flag = -1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (a[mid] == val) {
				flag = mid;
				end = mid - 1;
			} else if (a[mid] > val) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return flag;
	}

	/**
	 * 寻找最<val最右边的数字
	 * 
	 * @param start
	 * @param end
	 * @param a
	 * @param val
	 * @return
	 */
	public static int binarySort2(int start, int end, int a[], int val) {
		int flag = -1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (a[mid] == val) {
				start = mid + 1;
			} else if (a[mid] > val) {
				flag = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return flag;
	}

}