package JianZhiOffer;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MianShi60 {
	public static void main(String[] args) {
		MianShi60 m = new MianShi60();
		m.dicesProbability1(2);
	}

	public double[] dicesProbability(int n) {
		int a[] = { 1, 2, 3, 4, 5, 6 };
		f(a, 0, 0, n, 0);
		double b[] = new double[map.keySet().size()];
		int i = 0;
		Collection<Integer> values = map.values();
		for (Integer integer : values) {
			b[i] = (double) integer / flag;
			i++;
		}
		return b;
	}

	Map<Integer, Integer> map = new HashMap<>();
	int flag = 0;

	public void f(int a[], int start, int count, int n, int sum) {
		if (count == n) {
			if (map.containsKey(sum)) {
				map.put(sum, map.get(sum) + 1);
			} else {
				map.put(sum, 1);
			}
			flag++;
		}
		for (int i = start; i < n; i++) {
			for (int j = 0; j < a.length; j++) {
				sum += a[j];
				f(a, i + 1, count + 1, n, sum);
				sum -= a[j];
			}
		}
	}

	public double[] dicesProbability1(int n) {
		int a[] = { 1, 2, 3, 4, 5, 6 };
		int dp[][] = new int[n][6 * n];
		for (int i = 0; i < a.length; i++) {
			dp[0][i] = 1;
		}
		for (int i = 1; i < n; i++) {
			for (int j = i; j < dp[0].length; j++) {
				for (int k = 1; k <= 6 && k <= j; k++) {
					dp[i][j] += dp[i - 1][j - k];
				}
			}
		}
		double[] ans = new double[6 * n - n + 1];
		 for(int i = n; i <= 6 * n; i++)
	            ans[i - n] = ((double)dp[n-1][i-1]) / (Math.pow(6,n));
	        return ans;
	}
}
