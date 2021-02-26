package leetcode_list;

/**
 * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 * 
 * 如果有两个中间结点，则返回第二个中间结点。
 * 
 * @author jackjoily
 *
 */
public class E_876 {

	/**
	 * 奇数寻找中点 偶数寻找下中点
	 * 
	 * @param head
	 * @return
	 */
	public ListNode middleNode(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode fast = head;
		ListNode slow = head.next;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
}
