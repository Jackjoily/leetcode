package leetcode_day;

public class M_424 {
	public int characterReplacement(String s, int k) {
		int n = s.length();
		if (n <= 1)
			return n;
		int left = 0, right = 0;
		int maxSame = 0;
		int a[] = new int[26];
		while (right < n) {
			char c = s.charAt(right);
			maxSame = Math.max(++a[c - 'A'], maxSame);
			if (maxSame + k < right - left + 1) {
				a[s.charAt(left) - 'A']--;
				left++;
			}
			right++;
		}
		return right - left;
	}
}
