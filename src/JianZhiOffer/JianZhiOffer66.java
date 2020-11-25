package JianZhiOffer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class JianZhiOffer66 {
	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 5 };
		constructArr(a);
	}

	public static int[] constructArr(int[] a) {
		if (a.length <= 1)
			return new int[0];
		int b[] = new int[a.length];
		Arrays.fill(b, 1);
		int temp[] = new int[a.length];
		Arrays.fill(temp, 1);
		for (int i = a.length - 2, j = a.length - 2; i >= 0; j--, i--) {
			temp[j] *= a[i + 1] * temp[j + 1];
		}
		b[0] = temp[0];
		int flag = 1;
		int flag1 = 1;
		for (int k = 1; k < a.length; k++) {
			flag *= a[k - 1]*flag1;
            flag1=flag;
            flag=1;
            b[k]=flag1*temp[k];
		}

		return b;
	}
}
