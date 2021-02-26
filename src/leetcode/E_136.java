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
public class E_136 {
	public int singleNumber(int[] nums) {
		int a=0;
		for(int b:nums) {
			a^=b;
		}
		return a;
	}
}
