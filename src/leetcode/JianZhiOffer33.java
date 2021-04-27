package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import javafx.css.PseudoClass;

/**
 * twosum
 * 
 * @author jackjoily
 *
 */
public class JianZhiOffer33 {
	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 7, 6, 5, 4 };
		System.out.println(verify(a, 0, a.length - 1));
	}

	public boolean verifyPostorder(int[] postorder) {
		return verify(postorder, 0, postorder.length-1);
	}

	public static boolean verify(int[] post, int low, int high) {
		if (low >= high) {
			return true;
		}
		int p = low;
		while (post[p] < post[high]) {
			p++;
		}
		int m = p;
		while (post[p] > post[high]) {
			p++;
		}
		return p == high ? verify(post, low, m - 1) && verify(post, m, high - 1) : false;
	}

}
