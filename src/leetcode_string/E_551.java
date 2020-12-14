package leetcode_string;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 
 * 给定一个字符串来代表一个学生的出勤记录，这个记录仅包含以下三个字符：
 * 
 * 'A' : Absent，缺勤 'L' : Late，迟到 'P' : Present，到场
 * 如果一个学生的出勤记录中不超过一个'A'(缺勤)并且不超过两个连续的'L'(迟到),那么这个学生会被奖赏。
 * 
 * 你需要根据这个学生的出勤记录判断他是否会被奖赏。
 * 
 * @author jackjoily
 *
 */
public class E_551 {
	public static void main(String[] args) {
		System.out.println(checkRecord("PPLLLALLPL"));
	}

	public static boolean checkRecord(String s) {
		int a = 0;
		char ch = ' ';
		int temp = 0;
		for (int i = 0; i < s.length(); i++) {
			char charAt = s.charAt(i);
			if (charAt == 'A') {
				a++;
				if (a > 1)
					return false;
				ch = 'A';
			} else {
				if (charAt == 'L') {
					if (ch == 'L') {
						if (temp == 1) {
							return false;
						} else {
							ch = 'L';
							temp = 1;
						}
					} else {
						ch = charAt;
						temp = 0;
					}
				}else {
					ch = charAt;
					temp = 0;
				}
			}
		}
		return true;
	}
}
