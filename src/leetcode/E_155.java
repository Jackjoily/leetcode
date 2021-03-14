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
public class E_155 {
}

class MinStack {
	Stack<Integer> s;
	Stack<Integer> s1;

	public MinStack() {
		s = new Stack<>();
		s1 = new Stack<>();
	}

	public void push(int x) {
		s.add(x);
		if (s1.size() == 0) {
			s1.add(x);
		} else {
			if (x > s1.peek()) {
				s1.add(s1.peek());
			} else {
				s1.add(x);
			}
		}
	
	}

	public void pop() {
		if (s.size() > 0) {
			s.pop();
			s1.pop();
		}
	}

	public int top() {
		return s.peek();
	}

	public int getMin() {
		return s1.peek();
	}
}
