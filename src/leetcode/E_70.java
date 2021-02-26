package leetcode;

import java.util.Arrays;
import java.util.HashMap;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

/**
 * twosum
 * 
 * @author jackjoily
 *
 */
public class E_70 {
	public static void main(String[] args) {
		System.out.println(climbStairs(3));
	}
	public static  int climbStairs(int n) {
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;
		int a = 1, b = 2, c = 0;
		for (int i = 3; i <= n; i++) {
			c = a + b;
			a = b;
			b = c;
		}
		return c;
	}
}
