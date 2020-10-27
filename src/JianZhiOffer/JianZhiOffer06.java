package JianZhiOffer;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import leetcode_list.ListNode;

/**
 * 
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 * 
 * @author jackjoily
 *
 */
public class JianZhiOffer06 {
	public static void main(String[] args) {
		JianZhiOffer06 j = new JianZhiOffer06();
		ListNode create = ListNode.create(3);
	}

	public int[] reversePrint(ListNode head) {
		if (head == null)
			return new int[0];
		Stack<Integer> stack = new Stack<>();
		while (head != null) {
			stack.add(head.val);
			head=head.next;
		}
		int a[] = new int[stack.size()];
		int i = 0;
		while (!stack.isEmpty()) {
			a[i] = stack.pop();
			i++;
		}
		return a;
	}
}
