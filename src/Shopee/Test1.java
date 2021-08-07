package Shopee;

public class Test1 {
	public static void main(String[] args) {
		Test1 t = new Test1();
		System.out.println(t.romanToInt("DCCCLVIII"));
	}

	public int romanToInt(String s) {
		char[] c = s.toCharArray();
		int val = 0;
		int len = c.length;
		for (int i = 0; i < len;) {
			if (c[i] == 'I') {
				if (i + 1 < len) {
					if (c[i + 1] == 'V') {
						val += 4;
						i += 2;
					} else if (c[i + 1] == 'X') {
						val += 10;
						i += 2;
					} else {
						val += 1;
						i++;
					}
				} else {
					val += 1;
					i++;
				}
			} else if (c[i] == 'X') {
				if (i + 1 < len) {
					if (c[i + 1] == 'L') {
						val += 40;
						i += 2;
					} else if (c[i + 1] == 'C') {
						val += 90;
						i += 2;
					} else {
						val += 10;
						i++;
					}
				} else {
					val += 10;
					i++;
				}
			} else if (c[i] == 'C') {
				if (i + 1 < len) {
					if (c[i + 1] == 'D') {
						val += 400;
						i += 2;
					} else if (c[i + 1] == 'M') {
						val += 900;
						i += 2;
					} else {
						val += 100;
						i++;
					}

				} else {
					val += 100;
					i++;
				}
			} else {
				// I X C
				if (c[i] == 'V') {
					val += 5;
					i++;
				} else if (c[i] == 'L') {
					val += 50;
					i++;
				} else if (c[i] == 'D') {
					val += 500;
					i++;
				} else if (c[i] == 'M') {
					val += 1000;
					i++;
				}
			}
		}
		return val;
	}

	String romanToInt1(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			sb.append(str(s.length() - 1 - i, s.charAt(i) + ""));
		}
		return sb.toString();
	}

	public String str(int i, String str) {
		if (i == 0)
			return get(str);
		if (i == 1)
			return get1(str);
		if (i == 2)
			return get2(str);
		if (i == 3)
			return get3(str);
		return "";
	}

	// 个位
	public String get(String str) {
		int n = Integer.valueOf(str);
		if (n == 4) {
			return "IV";
		}
		if (n == 9) {
			return "IX";
		}
		if (n == 5)
			return "V";
		if (n > 5) {
			String s = "V";
			for (int i = 0; i < n - 5; i++) {
				s += "I";
			}
			return s;
		}
		String s = "";
		for (int i = 0; i < n; i++) {

			s += "I";

		}
		return s;
	}

	// 10位
	public String get1(String str) {
		int n = Integer.valueOf(str);
		if (n == 4) {
			return "XL";
		}
		if (n == 9) {
			return "XD";
		}
		if (n == 5)
			return "L";
		if (n > 5) {
			String s = "L";
			for (int i = 0; i < (n - 5); i++) {
				s += "X";
			}
			return s;
		}
		String s = "";
		for (int i = 0; i < n; i++) {

			s += "X";

		}
		return s;
	}

	// 100位
	public String get2(String str) {
		int n = Integer.valueOf(str);
		if (n == 4) {
			return "CD";
		}
		if (n == 9) {
			return "CM";
		}
		if (n == 5)
			return "D";
		if (n > 5) {
			String s = "D";
			for (int i = 0; i < (n - 5); i++) {
				s += "C";
			}
			return s;
		}
		String s = "";
		for (int i = 0; i < n; i++) {
			s += "C";
		}
		return s;
	}

	// 1000位
	public String get3(String str) {
		int n = Integer.valueOf(str);
		String s = "";
		for (int i = 0; i < n; i++) {
			s += "M";
		}
		return s;
	}
}
