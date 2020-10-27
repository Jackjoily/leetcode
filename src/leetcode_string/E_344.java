package leetcode_string;

public class E_344 {
	public static void main(String[] args) {
		char c[] = { 'a', 'b', 'c', 'd', 'e','f' };
		reverseString(c);
		System.out.println(c);
	}

	public static void reverseString(char[] s) {
		if (s.length == 0)
			return;
		int n = s.length - 1;
		for (int i = 0; i <= n / 2; i++) {
			char c = s[i];
			s[i] = s[n - i];
			s[n - i] = c;
		}
	}
}
