package leetcode;

import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

/**
 * twosum
 * 
 * @author jackjoily
 *
 */
public class E_204 {
	public static void main(String[] args) {
		System.out.println(	countPrimes(10));
	}

	public static int countPrimes(int n) {
		BitSet set = new BitSet(n);
		set.clear();
		for (int i = 2; i * i < n; i++) {
			if (!set.get(i)) {
				set.set(i);
				for (int j = i * i; j < n; j+=i){
                   set.set(j);   
				}
			}
		}
		System.out.println(set);
		int count=0;
		for (int i = 0; i < n; i++) {
		    if(!set.get(i)) {
		    	count++;
		    }
		}
		return count;
	}
}
