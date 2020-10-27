package leetcode_day;

import java.util.ArrayList;
import java.util.List;

import leetcode_list.ListNode;

public class M_143 {
	public static void main(String[] args) {
		M_143 m = new M_143();
		ListNode create = ListNode.create(5);
		m.reorderList(create);
		ListNode.print(create);
	}

	public void reorderList(ListNode head) {
		// 只有一个节点或者只有两个节点的情况
		if(head==null||head.next==null) {
			return ;
		}
		ListNode p = head;
		List<ListNode> list = new ArrayList<>();
		while (p!= null) {
			list.add(p);
			p=p.next;
		}
		ListNode r = new ListNode();
		ListNode m = r;
		for (int i = 0; i < list.size() / 2; i++) {
			r.next = list.get(i);
			r = r.next;
			r.next = list.get(list.size()-1- i);
			r = r.next;
		}
		if(list.size()%2!=0) {
			r.next=list.get(list.size()/2);
			r=r.next;
		}
		r.next=null;
		head = m.next;
	}
}
