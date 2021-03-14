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
public class E_290 {
	public static void main(String[] args) {
		E_290 e = new E_290();
		System.out.println(e.wordPattern("abba", "dog cat cat dog"));
	}

	public boolean wordPattern(String pattern, String s) {
		String[] split = s.split("\\s+");
		if (split.length != pattern.length())
			return false;
		for (int i = 0; i < pattern.length(); i++) {
			if (pattern.indexOf(pattern.charAt(i)) != indexOfWordPattern(split, split[i])) {
				return false;
			}
		}
		return true;
	}

	public int indexOfWordPattern(String[] split, String str) {
		for (int i = 0; i < split.length; i++) {
			if (split[i].equals(str))
				return i;
		}
		return -1;
	}
}
