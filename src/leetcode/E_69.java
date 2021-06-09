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
public class E_69 {
	public static void main(String[] args) {
		System.out.println(mySqrt(2147395599));
	}

	public static int mySqrt(int x) {
		int low = 0;
		int high = x;
		int ans = 0;
		while (low <= high) {
			int mid = (high - low) / 2 + low;
			if ((long) mid * mid<= x) {
				ans = mid;
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return ans;
	}
}
