package ZhongXing;

import java.math.BigInteger;
import java.util.*;

public class Test2 {
	static BigInteger base1 = new BigInteger("1");
	static BigInteger base2 = new BigInteger("2");

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			f(new BigInteger(sc.nextLine()));
		}
	}

	public static void f(BigInteger b) {
		int res = 1;
		while (b.compareTo(base1) > 0) {
			b=b.add(base1).divide(base2);
			res++;
		}
		System.out.println(res);
	}
}
