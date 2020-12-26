package leetcode_string;

import java.util.HashMap;
import java.util.Map;

public class M_468 {

	public static void main(String[] args) {
		System.out.println(validIPAddress("1e1.4.5.6"));
	}

	public static String validIPAddress(String ip) {
		// ipv6
		if (ip.contains(":")) {
			String[] split = ip.split(":", -1);
			for (String str : split) {
				if (!isOKIpv6(str)) {
					return "Neither";
				}
			}
			return "IPv6";
		} else {
			// ipv4
			String[] split = ip.split("\\.", -1);
			for (String str : split) {
				if (!isOKIpv4(str)) {
					return "Neither";
				}
			}
			return "IPv4";
		}
	}

	public static boolean isOKIpv4(String str) {
		if (str.length() == 1)
			return true;
		if (str.length() >= 2 && str.length() <= 3) {
			if (str.charAt(0) == '0')
				return false;
			if (str.length() == 3) {
				for (int i = 0; i < str.length(); i++) {
					if ( str.charAt(i) >= 'a' && str.charAt(i) <= 'z'
							|| str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
						return false;
					}
				}
				if (Integer.valueOf(str) > 255)
					return false;
			} else {
				for (int i = 0; i < str.length(); i++) {
					if ( str.charAt(i) >= 'f' && str.charAt(i) <= 'z'
							|| str.charAt(i) >= 'F' && str.charAt(i) <= 'Z') {
						return false;
					}
				}
			}
			return true;
		} else {
			return false;
		}
	}

	public static boolean isOKIpv6(String str) {
		if (str.length() == 1 && str.charAt(0) == 0) {
			return true;
		}
		if (str.length() > 4 || str.length() == 0)
			return false;
		if (str.charAt(0) == '0') {
			for (int i = 1; i < str.length(); i++) {
				if (str.charAt(i) == '9' || str.charAt(i) >= 'f' && str.charAt(i) <= 'z'
						|| str.charAt(i) >= 'F' && str.charAt(i) <= 'Z') {
					return false;
				}
			}
			if (str.length() == 2) {
				if (str.equals("00"))
					return false;
			}
			if (str.length() == 3) {
				if (str.contains("00"))
					return false;
			}
			if (str.length() == 4) {
				if (str.contains("000"))
					return false;
			}
		}
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '9')
				return false;
			if (str.charAt(i) >= 'f' && str.charAt(i) <= 'z' || str.charAt(i) >= 'F' && str.charAt(i) <= 'Z') {
				return false;
			}
		}
		return true;
	}
}
