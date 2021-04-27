package ZhongXing;

import java.util.*;

public class Test1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int h = sc.nextInt();
		int u = sc.nextInt();
		if (h > u) {
			System.out.println(0);
		}else {
			int a[] = new int[n];
			for (int j = 0; j < n; j++) {
				a[j] = sc.nextInt();
			}
		Arrays.sort(a);
		int k=0;
		for (int j = a.length - 1; j >= 0; j--) {
			h += a[j];
			k++;
			if (h >= u) {
				System.out.println(k);
				break;
			}
		}	
		}
	}
}
