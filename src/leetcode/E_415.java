package leetcode;

import java.util.Arrays;
import java.util.HashMap;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

/**
 * 
 * @author jackjoily
 *
 */
public class E_415 {
	public static void main(String[] args) {

		System.out.println(addStrings("11", "99"));
	}

	public static String addStrings(String num1, String num2) {
		char[] n = num1.toCharArray();
		char[] n1 = num2.toCharArray();
		int i = n.length - 1;
		int j = n1.length - 1;
		StringBuilder sb = new StringBuilder();
		int val = 0;
		int sum = 0;
		while (i != -1 && j != -1) {
			sum = (val + n[i] - '0' + n1[j] - '0') % 10;
			val = (val + n[i] - '0' + n1[j] - '0') / 10;
			sb.append(sum);
			i--;
			j--;
		}
		while (i != -1) {
			sum = (val + n[i] - '0'  )%10;
			val = (val + n[i] - '0' )/ 10;
			sb.append(sum);
			i--;
		}
		while (j != -1) {
			sum = (val + n1[j] - '0' )% 10;
			val = (val + n1[j] - '0' )/ 10;
			sb.append(sum);
			j--;
		}
		if (val == 1) {
			sb.append(val);
		}
		return sb.reverse().toString();
	}
}
