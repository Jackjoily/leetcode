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
public class E_125 {

	public static void main(String[] args) {

		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
	}

	public static boolean isPalindrome(String s) {
		 StringBuffer sgood = new StringBuffer();
	        int length = s.length();
	        for (int i = 0; i < length; i++) {
	            char ch = s.charAt(i);
	            if (Character.isLetterOrDigit(ch)) {
	                sgood.append(Character.toLowerCase(ch));
	            }
	        }
	        StringBuffer sgood_rev = new StringBuffer(sgood).reverse();
	        return sgood.toString().equals(sgood_rev.toString());
	}
}
