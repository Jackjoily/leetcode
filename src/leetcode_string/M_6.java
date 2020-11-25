package leetcode_string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import edu.princeton.cs.algs4.In;

/**
 * 
 * 
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。 比如输入字符串为 "LEETCODEISHIRING" 行数为 3
 * 时，排列如下： L C I R E T O E S I I G E D H N
 * 
 * @author jackjoily
 *
 */
public class M_6 {
	public static void main(String[] args) {
		System.out.println(convert("LEETCODEISHIRING", 4));
	}

	public static String convert(String s, int numRows) {
		if (numRows == 1)
			return s;
		char[] charArray = s.toCharArray();
		int n = numRows - 1;
		char a[][] = new char[numRows][s.length()];
		int temp = 1;
		int flag = 0;
		for (int i = 0; i < charArray.length; i += n) {
			int k = 0;
			int l = n;
			for (int j = i; j < charArray.length && j < i + n; j++) {
				if (temp % 2 == 0) {
					a[l][flag] = charArray[j];
					l--;
				} else {
					a[k][flag] = charArray[j];
					k++;
				}
			}
			flag++;
			temp++;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				if (a[i][j] != '\u0000') {
					sb.append(a[i][j]);
				}

			}
		}
		return sb.toString();
	}
}
