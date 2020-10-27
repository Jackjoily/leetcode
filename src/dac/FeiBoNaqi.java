package dac;

public class FeiBoNaqi {
	static int a[] = new int[11];

	public static void main(String[] args) {
		System.out.println(fibDnc(10, a));
		System.out.println(fib(10));
		System.out.println(fibDnc(10));
	}

	public static int fib(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}
		return fib(n - 1) + fib(n - 2);
	}

	public static int fibDnc(int n, int a[]) {
		if (n == 1 || n == 2)
			return 1;
		if (a[n] != 0)
			return a[n];
		a[n] = fibDnc(n - 1, a) + fibDnc(n - 2, a);
		return a[n];
	}

	public static int fibDnc(int n) {
		int a[] = new int[n];
		a[0] = a[1] = 1;
		for (int i = 2; i < n; i++) {
			a[i] = a[i - 1] + a[i - 2];
		}
		return a[n-1];
	}
}
