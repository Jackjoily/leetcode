package JianZhiOffer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 
 * 在数组中的两个数字，如果前面一个数字大于后面的数字， 则这两个数字组成一个逆序对。 输入一个数组，求出这个数组中的逆序对的总数。
 * 
 * 
 * @author jackjoily
 *
 */
public class JianZhiOffer51 {
	public static void main(String[] args) {
		JianZhiOffer51 j=new JianZhiOffer51();
		int n = 10;
		int a[] = {1,3,2,3,1};
		System.out.println(j.reversePairs1(a));
		System.out.println(Arrays.toString(a));
	}
	 int count = 0;
	
	public  int reversePairs1(int[] nums) {
		if (nums.length < 2) {
			return 0;
		}
		int temp[]=new int [nums.length];
		sort(nums,0,nums.length-1,temp);
		return count;
	}
	public  void sort(int a[], int left, int right, int[] temp) {
		if (left < right) {
			int mid = (left + right) / 2;
			sort(a, left, mid, temp);
			sort(a, mid + 1, right, temp);
			merge(a, left, mid, right, temp);
		}
	}
	public  void merge(int a[], int left, int mid, int right, int[] temp) {
		int i = left;
		int j = mid + 1;
		int k = left;
		while (i <= mid && j <= right) {
			if (a[i] <= a[j]) {
				temp[k++] = a[i++];
			} else {
				count += (mid - i + 1);
				temp[k++] = a[j++];
			}
			
		}
		while (i <= mid) {
			temp[k++] = a[i++];
		}
		while (j <= right) {
			temp[k++] = a[j++];
		}
		for (k = left; k <= right; k++) {
			a[k] = temp[k];
		}
	}
}
