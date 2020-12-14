package leetcode_day;

public class M_649 {
	public static void main(String[] args) {
		System.out.println(predictPartyVictory("RDDRD"));
	}

	public static String predictPartyVictory(String senate) {
		int r = 0;
		int d = 0;
		int flag[] = new int[senate.length()];
		for (int i = 0; i < senate.length(); i++) {
			if (senate.charAt(i) == 'R') {
				r++;
			} else {
				d++;
			}
		}
		while (true) {
			for (int i = 0; i < senate.length(); i++) {
				char c = senate.charAt(i);
				boolean k = true;
				int l = i + 1;
				if (flag[i] == 0) {
					if (d == 0) {
						return "Radiant";
					}
					if (r == 0) {
						return "Dire";
					}
					while (k) {
						if (l ==senate.length()) {
							l = 0;
						}
						if (l != i) {
							char ch = senate.charAt(l);
							if (flag[l] == 0 && c != ch) {
								flag[l] = 1;
								if (ch == 'D') {
									d--;
								} else {
									r--;
								}
								break;
							}
						}
						l++;
					}
				}
			}
		}
	}
}
