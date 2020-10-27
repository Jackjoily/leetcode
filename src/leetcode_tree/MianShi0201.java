package leetcode_tree;

/**
 * @ClassName MianShi0201
 * @Description移除无序列表中的重复节点
 * @Author Jackjoily
 * @Date 2020年6月26日 下午4:17:26
 */
public class MianShi0201 {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode head1 = new ListNode(1);
		ListNode head2 = new ListNode(1);
		ListNode head3 = new ListNode(1);
		ListNode head4 = new ListNode(2);
		head.next = head1;
		head1.next = head2;
		head2.next = head3;
		head3.next = head4;
		removeDuplicateNodes(head);
		while (head != null) {
			System.out.print(head.val + "-->");
			head=head.next;
		}
	}

	static ListNode removeDuplicateNodes(ListNode head) {
		ListNode p = head;
		ListNode pre = null;
		while (p != null) {
			ListNode q = p.next;
			pre = p;
			while (q != null) {
				if (q.val != p.val) {
					pre = q;
					q = q.next;
				} else {
					pre.next = q.next;
					q = q.next;
				}
			}
			p = p.next;
		}
		return head;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}