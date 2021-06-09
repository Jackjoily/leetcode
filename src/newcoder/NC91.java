package newcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import leetcode_tree.TreeNode;
import leetcode_tree.TreeUtils;

public class NC91 {
	public static void main(String[] args) {
		int a[] = { 2, 1, 5, 3, 6, 4, 8, 9, 7 };
		System.out.println(Arrays.toString(LIS(a)));
	}

	public static int[] LIS(int[] arr) {
		   int[] nums = new int[arr.length];
	        int[] temp = new int[arr.length];
	        nums[0] = 1;
	        int tempIndex = 0;
	        temp[tempIndex] = arr[0];
	        for (int i = 1; i < arr.length; ++i) {
	            int left = 0, right = tempIndex;
	            if (arr[i] > temp[tempIndex]) {
	                ++tempIndex;
	                nums[i] = tempIndex + 1;
	                temp[tempIndex] = arr[i];
	            } else {
	                while (left <= right) {        // 注意这里 left <= right 而不是 left < right，我们要替换的是第一个比 arr[i] 大的元素
	                    int mid = (right + left) / 2;
	                    if (temp[mid] > arr[i]) {
	                        right = mid - 1;
	                    } else {
	                        left = mid + 1;
	                    }
	                }
	                temp[left] = arr[i];
	                nums[i] = left + 1;
	            }
	        }
	 
	        int[] res = new int[tempIndex + 1];
	        for (int i = nums.length - 1; i >= 0; --i) {
	            if (nums[i] == tempIndex + 1) {
	                res[tempIndex] = arr[i];
	                --tempIndex;
	            }
	        }
	        return res;
	    }

	public static int lengthOfLIS(int[] nums) {
		// list中保存的是构成的上升子序列
		ArrayList<Integer> list = new ArrayList<>(nums.length);
		for (int num : nums) {
			// 如果list为空，我们直接把num加进去。如果list的最后一个元素小于num，
			// 说明num加入到list的末尾可以构成一个更长的上升子序列，我们就把num
			// 加入到list的末尾
			if (list.size() == 0 || list.get(list.size() - 1) < num)
				list.add(num);
			else {
				// 如果num不小于list的最后一个元素，我们就用num把list中第一
				// 个大于他的值给替换掉,这样我们才能保证list中的元素在长度不变
				// 的情况下，元素值尽可能的小
				int i = Collections.binarySearch(list, num);
				// 因为list是从小到大排序的，所以上面使用的是二分法查找。当i大
				// 于0的时候，说明出现了重复的，我们直接把他替换即可，如果i小于
				// 0，我们对i取反，他就是list中第一个大于num值的位置，我们把它
				// 替换即可
				list.set((i < 0) ? -i - 1 : i, num);
			}
		}
		System.out.println(list);
		return list.size();
	}
}
