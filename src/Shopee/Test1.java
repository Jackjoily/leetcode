package Shopee;

import java.util.Random;

public class Test1 {
	public static void main(String[] args) {
	
	 System.out.println(romanToInt("MCMXCIV"));
	}

	public static int romanToInt(String s) {
		char[] c = s.toCharArray();
		int res = 0;
		for (int i = 0; i < c.length;) {
			if (c[i] == 'I') {
				if (i + 1 < c.length) {
					if (c[i + 1] == 'V') {
						res += 4;
						i += 2;
					} else if (c[i + 1] == 'X') {
						res += 9;
						i += 2;
					} else {
						res++;
						i++;
					}
				} else {
					res++;
					i++;
					break;
				}
			}
			else if (c[i] == 'X') {
				if (i + 1 < c.length) {
					if (c[i + 1] == 'L') {
						res += 40;
						i += 2;
					} else if (c[i + 1] == 'C') {
						res += 90;
						i += 2;
					} else {
						res += 10;
						i++;
					}
				} else {
					res += 10;
					i++;
					break;
				}
			}
			else if (c[i] == 'C') {
				if (i + 1 < c.length) {
					if (c[i + 1] == 'D') {
						res += 400;
						i += 2;
					} else if (c[i + 1] == 'M') {
						res += 900;
						i += 2;
					} else {
						res += 100;
						i++;
					}
				} else {
					res += 100;
					i++;
					break;
				}
			}
			else if (c[i] == 'V') {
				res += 5;
				i++;
			}
			else if (c[i] == 'L') {
				res += 50;
				i++;
			}
			else if (c[i] == 'D') {
				res += 50;
				i++;
			}
			else if (c[i] == 'M') {
				res +=1000;
				i++;
			}
		}
		return res;
	}
}
