package leetcode_list;

/**
 * 给定一个链表，判断链表中是否有环。
 * 
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos
 * 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos
 * 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * 
 * @author jackjoily
 *
 */
public class E_141 {
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
	n1.next = n2;
//		n2.next = n3;
//		n3.next = n4;
//		n4.next = n2;
		E_141 e = new E_141();
		System.out.println(e.hasCycle(n1));
	}

	public static boolean hasCycle(ListNode head) {
		boolean flag = false;
		if (head == null)
			return false;
		ListNode p, q;
		p = head;
		q = head;
		while (p != null && q!= null) {
			p = p.next;
			if(q.next==null) {
				break;
			}
			q = q.next.next;
			if (p == q) {
				flag = true;
				break;
			}
		}
		return flag;
	}
}
