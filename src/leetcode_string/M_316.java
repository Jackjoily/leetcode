package leetcode_string;

import java.util.HashMap;
import java.util.Map;

public class M_316 {

	public static void main(String[] args) {
		M_316 m = new M_316();
		System.out.println(m.intToRoman(3999));
	}

	/**
	 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
	 * 
	 * @param s
	 * @return
	 */
	public String intToRoman(int num) {
		String str = String.valueOf(num);
		char[] c = str.toCharArray();
		StringBuilder sb = new StringBuilder();
		if (c.length == 4) {
			sb.append(foget(c[0] - '0'));
			sb.append(tget(c[1] - '0'));
			sb.append(sget(c[2] - '0'));
			sb.append(fget(c[3] - '0'));
		} else if (c.length == 3) {
			sb.append(tget(c[0] - '0'));
			sb.append(sget(c[1] - '0'));
			sb.append(fget(c[2] - '0'));
		} else if (c.length == 2) {
			sb.append(sget(c[0] - '0'));
			sb.append(fget(c[1] - '0'));
		} else {
			return fget(num);
		}
		return sb.toString();
	}

	public String foget(int num) {
		if (num == 1) {
			return "M";
		} else if (num == 2) {
			return "MM";
		} else {
			return "MMM";
		}
	}

	public String tget(int num) {
		if (num == 1) {
			return "C";
		} else if (num == 2) {
			return "CC";
		} else if (num == 3) {
			return "CCC";
		} else if (num == 4) {
			return "CD";
		} else if (num == 5) {
			return "D";
		} else if (num == 6) {
			return "DC";
		} else if (num == 7) {
			return "DCC";
		} else if (num == 8) {
			return "DCCC";
		} else if (num == 9) {
			return "CM";
		} else {
			return "";
		}
	}

	public String sget(int num) {
		if (num == 5) {
			return "L";
		} else if (num == 4) {
			return "XL";
		} else if (num == 9) {
			return "XC";
		} else if (num == 1) {
			return "X";
		} else if (num == 3) {
			return "XXX";
		} else if (num == 2) {
			return "XX";
		} else if (num == 6) {
			return "LX";
		} else if (num == 7) {
			return "LXX";
		} else if (num == 8) {
			return "LXXX";
		} else {
			return "";
		}
	}

	public String fget(int num) {
		if (num == 1)
			return "I";
		else if (num == 2)
			return "II";
		else if (num == 3)
			return "III";
		else if (num == 4)
			return "IV";
		else if (num == 5)
			return "V";
		else if (num == 6)
			return "VI";
		else if (num == 7)
			return "VII";
		else if (num == 8)
			return "VIII";
		else if (num == 9)
			return "IX";
		else
			return "";
	}
}
