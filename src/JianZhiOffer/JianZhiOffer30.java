package JianZhiOffer;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中， 调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * 
 * 
 * @author jackjoily
 *
 */
public class JianZhiOffer30 {
	public static void main(String[] args) {
	}

}

class MinStack {
	Stack<Integer> A, B;

	/** initialize your data structure here. */
	public MinStack() {
		A = new Stack<>();
		B = new Stack<>();
	}

	public void push(int x) {
		if (B.size() > 0) {
			if (x < B.peek()) {
				B.add(x);
			} else {
				Integer pop = B.pop();
				B.add(x);
				B.add(pop);
			}
		}else {
			B.add(x);
		}
		A.add(x);
	}

	public void pop() {
		B.remove(Integer.valueOf(A.pop()));
	}

	public int top() {
		return A.peek();
	}

	public int min() {
		return B.peek();
	}
}
