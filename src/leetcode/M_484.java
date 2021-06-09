package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import javafx.scene.shape.Line;
import leetcode_list.ListNode;
import leetcode_tree.TreeNode;

/**
 * 
 * @author jackjoily
 *
 */
public class M_484 {
	public static void main(String[] args) {
		M_484 m = new M_484();
		String str = "1.0.1.";
		System.out.println(m.validIPAddress(str));
	}

	public String validIPAddress(String IP) {
		int flag = 0;
		if (IP.contains(".")) {
			for (int i = 0; i < IP.length(); i++) {
				if (IP.charAt(i) == '.') {
					flag++;
					if (flag >= 4)
						return "Neither";
				}
			}
			String[] split = IP.split("\\.");
			if (split.length != 4)
				return "Neither";
			for (String string : split) {
				if (!isOkayIPV4(string)) {
					return "Neither";
				}
			}
			return "IPv4";
		} else {
			for (int i = 0; i < IP.length(); i++) {
				if (IP.charAt(i) == ':') {
					flag++;
					if (flag >= 8)
						return "Neither";
				}
			}
			String[] split1 = IP.split("\\:");
			if (split1.length != 8)
				return "Neither";
			for (String string : split1) {
				if (!isOkayIPV6(string)) {
					return "Neither";
				}
			}
		}
		return "IPV6";
	}

	public boolean isOkayIPV6(String str) {
		if (isBlank(str))
			return false;
		int length = str.length();
		if (length >= 5)
			return false;
		for (int i = 0; i < length; i++) {
			char charAt = str.charAt(i);
			if (!Character.isLetterOrDigit(charAt)) {
				return false;
			} else {
				if (Character.isLetter(charAt)) {
					if (charAt >= 'g' && charAt <= 'z' || charAt >= 'G' && charAt <= 'Z') {
						return false;
					}
				}
			}
		}
		return true;
	}

	public boolean isOkayIPV4(String str) {
		if (isBlank(str))
			return false;
		int length = str.length();
		if (length >= 4)
			return false;
		for (int i = 0; i < length; i++) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		if (length == 1)
			return true;
		if (length > 1) {
			if (str.charAt(0) == '0')
				return false;
			if (Integer.valueOf(str) > 255)
				return false;
		}
		return true;
	}

	public static boolean isBlank(final CharSequence cs) {

		int strLen;
		if (cs == null || (strLen = cs.length()) == 0) {
			return true;
		}
		for (int i = 0; i < strLen; i++) {
			if (Character.isWhitespace(cs.charAt(i)) == false) {
				return false;
			}
		}
		return true;
	}
}
