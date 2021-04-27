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
public class E_860 {
	public boolean lemonadeChange(int[] bills) {
		int n = bills.length;
		if (n == 0)
			return true;
		if (bills[0] != 5)
			return false;
		int a = 1;
		int b = 0;
		int c = 0;
		for (int i = 1; i < n; i++) {
			if (bills[i] == 5) {
				a++;
			} else if (bills[i] == 10) {
				if (a == 0)
					return false;
				a--;
				b++;
			} else {
				if (b > 0 && a > 0) {
					b--;
					a--;
					c++;
				}else
				if (a >= 3) {
					a -= 3;
					c++;
				}else {
					return false;
				}
			
			}
		}
		return true;
	}
}
