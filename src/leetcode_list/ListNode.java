package leetcode_list;

public class ListNode {
	public int val;
	public ListNode next;

	public ListNode() {
	}

	public ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}

	public static void print(ListNode node) {
		System.out.println("===========");
		while (node != null) {
			System.out.println(node.val);
			node = node.next;
		}
		System.out.println("===========");
	}

	public static ListNode create(int n) {
		ListNode l = new ListNode();
		ListNode p = l;
		for (int i = 1; i <= n; i++) {
			ListNode q = new ListNode(i);
			l.next = q;
			l = q;
		}
		return p.next;
	}

	public static ListNode reverseCreate(int n) {
		ListNode l = new ListNode();
		ListNode p = l;
		for (int i = n; i >= 1; i--) {
			ListNode q = new ListNode(i);
			l.next = q;
			l = q;
		}
		return p.next;
	}
}
