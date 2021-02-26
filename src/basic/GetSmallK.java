package basic;

/**
 * 从两个有序数组中寻找第k小的数字
 * 
 * @author jackjoily
 *
 */
public class GetSmallK {

	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int b[] = { 11, 12, 13, 14, 15, 16, 17, 18 };
		int len = a.length;
		int ae = a.length - 1;
		int be = b.length - 1;
		int left = (ae + be+1+2) / 2;
		int right = (ae + be+2+2) / 2;
		System.out.println(getSmallK(a, 0, ae, b, 0, be, left)/2 + getSmallK(a, 0, ae, b, 0, be, right)/2);
	}

	public static int getSmallK(int a[], int as, int ae, int b[], int bs, int be, int k) {
		int len1 = ae - as + 1;
		int len2 = be - bs + 1;
		if (len1 > len2) {
			return getSmallK(b, bs, be, a, as, ae, k);
		}
		if (len1 == 0) {
			// 数组一中已经没有可以选择了，这时候从数组二中开始选择
			return b[bs + k - 1];
		}
		if (k == 1) {
			return Math.min(a[as], b[bs]);
		}
		int i = as + Math.min(len1, k / 2) - 1;
		int j = bs + Math.min(len2, k / 2) - 1;
		if (a[i] > b[j]) {
			return getSmallK(a, as, ae, b, j + 1, be, k - (j + 1 - bs));
		} else {
			return getSmallK(a, i + 1, ae, b, bs, be, k - (i + 1 - as));
		}
	}

}
