package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

/**
 * twosum
 * 
 * @author jackjoily
 *
 */
public class JianZhiOffer10I {
	public int fib(int n) {
		int a = 0, b = 1, c = 1;
		if (n <= 1)
			return n;
		for (int i = 2; i <= n; i++) {
			a = b;
			b = c;
			c = (a % (1000000007) + b % (1000000007)) % (1000000007);
		}
		return c;
	}
}
