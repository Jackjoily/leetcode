package leetcode_array;

public class M_33 {
	int target;

	public static void main(String[] args) {
		M_33 m = new M_33();
		int a[] = { 4, 5, 6, 7, 8, 1, 2, 3 };
		System.out.println(m.search(a, 8));
	}

	public int search(int[] nums, int target) {
		if (nums.length == 0)
			return -1;
		if (nums.length == 1)
			return nums[0] == target ? 0 : -1;
		this.target = target;
		return find(nums, 0, nums.length - 1);
	}

	/**
	 * 
	 * @param a
	 * @param low  分析二分查找的一个技巧是：不要出现 else，而是把所有情况用 else if 写清楚，
	 * @param high
	 * @return
	 */
	// 改成非递归函数
	public int find(int a[], int low, int high) {
		// if
		while (low <= high) {
			if (low <= high) {
				int mid = (low + high) / 2;
				if (a[mid] == target) {
					return mid;
				}
				// low到mid有序
				if (a[low] <= a[mid] && a[low] > target) {
					low = mid + 1;
				} else if (a[low] <= a[mid] && a[mid] > target && a[low] <= target) {
					high = mid - 1;
				} else if (a[low] <= a[mid] && a[mid] < target) {
					low = mid + 1;
				} else if (a[mid] <= a[high] && a[mid] < target && a[high] >= target) {
					low = mid + 1;
				} else if (a[mid] <= a[high] && a[mid] > target) {
					high = mid - 1;
				} else if (a[mid] <= a[high] && a[high] < target) {
					high = mid - 1;
				}
			}
		}
		return -1;
	}
}
