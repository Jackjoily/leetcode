package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

/**
 * twosum
 * 
 * @author jackjoily
 *
 */
public class E_20 {
	public static void main(String[] args) {
	}

	public boolean isValid(String s) {
		char[] c = s.toCharArray();
		Stack<Character> statck = new Stack<>();
		int i = 0;
		while (i < c.length) {
			if (c[i] != '(' && c[i] != '[' && c[i] != '{') {
				if (statck.isEmpty()) {
					return false;
				} else {
					Character pop = statck.pop();
					if (c[i] == ')' && pop != '(') {
						return false;
					} else if (c[i] == ']' && pop != '[') {
						return false;
					} else if (c[i] == '}' && pop != '{') {
						return false;
					}
				}
			} else {
				statck.add(c[i]);
			}
			i++;
		}
		if (!statck.isEmpty()) {
			return false;
		}
		return true;
	}
}
