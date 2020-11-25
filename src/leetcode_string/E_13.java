package leetcode_string;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * 
 * @author jackjoily
 *
 */
public class E_13 {
	public static void main(String[] args) {
		System.out.println(romanToInt("MMMCMXCIX"));
	}

	public static int romanToInt(String s) {
		Map<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		if (s.length() == 1) {
			return map.get(s.charAt(0));
		}
		char[] arr = s.toCharArray();
		int temp = 0;
		int i = 0;
		for (; i < arr.length - 1; i++) {
			char a = s.charAt(i);
			char b = s.charAt(i + 1);
			if (a == 'I') {
				if (b == 'V') {
					temp += 4;
					i++;
				} else if (b == 'X') {
					temp += 9;
					i++;
				} else {
					temp += 1;
				}
			} else if (a == 'V') {
				temp += 5;
			} else if (a == 'X') {
				if (b == 'L') {
					temp += 40;
					i++;
				} else if (b == 'C') {
					temp += 90;
					i++;
				} else {
					temp += 10;
				}
			} else if (a == 'L') {
				temp += 50;
			} else if (a == 'C') {
				if (b == 'D') {
					temp += 400;
					i++;
				} else if (b == 'M') {
					temp += 900;
					i++;
				} else {
					temp += 100;
				}
			} else if (a == 'D') {
				temp += 500;
			} else if (a == 'M') {
				temp += 1000;
			}
		}
		if (i == arr.length - 1) {
			return temp += map.get(arr[i]);
		}
		return temp;
	}
}
