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
public class JianZhiOffer15 {
	public static void main(String[] args) {

		System.out.println(new JianZhiOffer15().hammingWeight(4967293));
	}

	public int hammingWeight(int n) {
		int i = 0;
		int j = 1;
		int count = 0;
		while (i < 32) {
			if ((n & j) == j) {
				count++;
			}
			j <<= 1;
			i++;
		}
		return count;
	}
}
