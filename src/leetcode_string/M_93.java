package leetcode_string;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * 
 * 有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * 
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效的 IP 地址，但是 "0.011.255.245"、"192.168.1.312"
 * 和 "192.168@1.1" 是 无效的 IP 地址。
 * 
 *  
 * 
 * @author jackjoily
 *
 */
public class M_93 {
	public static void main(String[] args) {
		M_93 m = new M_93();
		String a = "010010";

		System.out.println(m.restoreIpAddresses(a));
	}
	List<String> res = new ArrayList<>();
	public List<String> restoreIpAddresses(String s) {
		int len = s.length();
		if (len < 4 || len > 12) {
			return res;
		}
		LinkedList<String> list = new LinkedList<>();
		f(s, len, 0, 0, list);
		return res;
	}
	public int isOkay(String s, int left, int right) {
		int len = right - left + 1;
		if (len > 1 && s.charAt(left) - '0' == 0) {
			return -1;
		}
		int res = 0;
		for (int i = left; i <= right; i++) {
			res = res * 10 + s.charAt(i) - '0';
		}
		if (res > 255)
			return -1;
		return res;
	}

	public void f(String s, int len, int count, int begin, LinkedList<String> list) {
		if (len == begin) {
			if (count == 4) {
				res.add(String.join(".", list));
			}
			return;
		}
		if(count>4)return ;
		for (int i = 0; i < 3; i++) {
			if (begin + i >= len) {
				return;
			}
			if (len - begin < (4 - count) || len - begin > (4 - count) * 3) {
				return;
			}
			int okay = isOkay(s, begin, begin + i);
			if (okay != -1) {
				list.add(okay + "");
				f(s, len, count + 1, begin + i + 1, list);
				list.removeLast();
			} else {
			}

		}

	}

}
