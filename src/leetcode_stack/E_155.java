package leetcode_stack;

import java.util.Stack;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * 
 * push(x) —— 将元素 x 推入栈中。 pop() —— 删除栈顶的元素。 top() —— 获取栈顶元素。 getMin() ——
 * 检索栈中的最小元素。
 * 
 * @author jackjoily
 *
 */
public class E_155 {

}

class MinStack {
	// 设计两个栈，还有一个辅助栈用来存放的最小的值
	Stack<Integer> stack;
	Stack<Integer> minStack;

	/** initialize your data structure here. */
	public MinStack() {
		stack = new Stack<>();
		minStack = new Stack<>();
	}

	public void push(int x) {
		stack.push(x);
		if (minStack.size() == 0) {
			minStack.push(x);
		} else {
			Integer peek = minStack.peek();
			if (x < peek) {
				minStack.add(x);
			} else {
				minStack.add(peek);
			}
		}

	}

	public void pop() {
		if (stack.size() > 0) {
			stack.pop();
			minStack.pop();
		}
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return minStack.peek();
	}
}
