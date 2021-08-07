package Shopee;

import java.util.*;

public class Test8 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(getMax1(a, m));
	}

	public static int getMax1(int a[], int m) {
		int n = a.length;
		int dp[][] = new int[n + 1][m + 1];
		int sum[] = new int[n + 1];
		for (int i = 0; i < n + 1; i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
			if (i < n) {
				sum[i + 1] = sum[i] + a[i];
			}
		}
		dp[0][0] = 0;
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < m + 1; j++) {
				for (int k = 0; k < i; k++) {
					dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j - 1], sum[i] - sum[k]));
				}
			}
		}
		return dp[n][m];
	}

	public static int getMax(int a[], int m) {
		int left = 0, right = 0;
		for (int num : a) {
			left = Math.max(left, num);
			right += num;
		}
		while (left < right) {
			int mid = (right - left) / 2 + left;
			int s = spilts(a, mid);
			if (s > m) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return left;
	}

	public static int spilts(int a[], int max) {
		int spilt = 1;
		int val = 0;
		for (int num : a) {
			if (val + num > max) {
				spilt++;
				val = 0;
			}
			val += num;
		}
		return spilt;
	}
}
