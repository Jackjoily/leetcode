package JianZhiOffer;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 找出数组中重复的数字。
 * 
 * 
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的 弹出顺序。假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5}
 * 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列， 但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 * 
 * 
 * 
 * @author jackjoily
 *
 */
public class JianZhiOffer31 {
	public static void main(String[] args) {
		int a[] = { 1,2,3,4,5 };
		int b[] = { 4,3,5,1,2 };
		JianZhiOffer31 j = new JianZhiOffer31();
		System.out.println(j.validateStackSequences(a, b));
	}

	public boolean validateStackSequences(int[] pushed, int[] popped) {
		 Stack<Integer> stack = new Stack<>();
	        int i = 0;
	        for(int num : pushed) {
	            stack.push(num); // num 入栈
	            while(!stack.isEmpty() && stack.peek() == popped[i]) { // 循环判断与出栈
	                stack.pop();
	                i++;
	            }
	        }
	        return stack.isEmpty();
	}
}
