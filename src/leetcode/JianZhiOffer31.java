package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

/**
 * twosum
 * 
 * @author jackjoily
 *
 */
public class JianZhiOffer31 {
	public boolean validateStackSequences(int[] pushed, int[] popped) {
		int n = pushed.length;
		if (n == 0)
			return false;
		int i = 0;
		Stack<Integer> s = new Stack<>();
		for (int num : pushed) {
			s.add(num);
			while (!s.isEmpty() && s.peek() == popped[i]) {
				i++;
				s.pop();
			}
		}
		return s.isEmpty();
	}
}
