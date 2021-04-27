package HuaWei;

import java.util.*;


public class H_2016_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = 0;
		while (sc.hasNext()) {
			a = sc.nextInt();
			System.out.println(getIndex(a));
		}
	}

	public static int getIndex(int a) {
		if (a > 1000)
			a = 1000;
		int b = a;
		boolean used[] = new boolean[a];
		int count = 0;
		int i = 0;
		while (b != 1) {
			if (!used[i]) {
				count++;
				if (count == 3) {
					used[i] = true;
					b--;
					count = 0;
				}
			}
			i = (i + 1) % a;
		}
		for (int j = 0; j < a; j++) {
			if (!used[j]) {
				return j;
			}
		}
		return i;
	}
}
