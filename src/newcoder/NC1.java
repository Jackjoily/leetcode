package newcoder;

public class NC1 {
	public static void main(String[] args) {
		System.out.println(solve("1", "99"));
	}

	public static String solve(String s, String t) {
		StringBuilder sb = new StringBuilder();
		int i = s.length() - 1, j = t.length() - 1, res = 0, val = 0;
		int l = 0, r = 0;
		while (i >= 0 && j >= 0) {
			l = s.charAt(i) - '0';
			r = t.charAt(j) - '0';
			res = (l + r + val) % 10;
			val = (l + r + val) / 10;
			sb.append(res);
			i--;
			j--;
		}
		if (i < 0) {
			while (j >= 0) {
				r = t.charAt(j) - '0';
				res = ( r + val) % 10;
				val = (r + val) / 10;
				sb.append(res);
				j--;
			}
			if (val>0) {
				sb.append(val);
			}
		} else {
			while (i >= 0) {
				l = s.charAt(i) - '0';
				res = (l + val) % 10;
				val = (l  + val) / 10;
				sb.append(res);
				i--;
			}
			if (val>0) {
				sb.append(val);
			}
		}
		return sb.reverse().toString();
	}
}
