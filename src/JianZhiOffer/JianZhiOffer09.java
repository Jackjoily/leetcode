package JianZhiOffer;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 找出数组中重复的数字。
 * 
 * 
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。 (若队列中没有元素，deleteHead 操作返回 -1 )
 * 
 * 
 * @author jackjoily
 *
 */
public class JianZhiOffer09 {

}

class CQueue {
	private Stack<Integer> statck;
	private Stack<Integer> statck1;

	public CQueue() {
		statck = new Stack<>();
		statck1 = new Stack<>();
	}

	public void appendTail(int value) {
		statck1.add(value);
	}

	public int deleteHead() {
		if (statck.size() > 0) {
			return statck.pop();
		} else {
			if (statck1.size() > 0) {
				while (statck1.size() > 0) {
					statck.add(statck1.pop());
				}
				return statck.pop();
			} else {
				return -1;
			}
		}
	}
}