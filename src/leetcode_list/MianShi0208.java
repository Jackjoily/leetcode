package leetcode_list;

import edu.princeton.cs.algs4.Stack;

/**
 * 给定一个链表，如果它是有环链表，实现一个算法返回环路的开头节点。 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是
 * -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * 
 * @author jackjoily
 *
 */
public class MianShi0208 {
	public static void main(String[] args) {
	}

	public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null)
			return null;
		ListNode fast = head, low = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			low = low.next;
			if (fast == low)
				break;
		}
		// 有环之后
		if (fast == null || fast.next == null) {
			return null;
		}
		low = head;
		// 然后快慢指针进行相交
		while (fast != low) {
			fast = fast.next;
			low = low.next;
		}
		return low;
	}
}
