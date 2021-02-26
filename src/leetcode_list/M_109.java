package leetcode_list;

import leetcode_tree.TreeNode;

/**
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 */
public class M_109 {
	/**
	 * 采用寻找中位数的方法插入节点
	 * 
	 * @param head
	 * @return
	 */
	public TreeNode sortedListToBST(ListNode head) {
		return buildTree(head,null);
	}

	public TreeNode buildTree(ListNode left, ListNode right) {
		if (left == right)
			return null;
		ListNode mid = getMid(left, right);
		TreeNode root = new TreeNode(mid.val);
		root.left = buildTree(left, mid);
		root.right = buildTree(mid.next, right);
		return root;
	}

	public ListNode getMid(ListNode left, ListNode right) {
		ListNode slow = left;
		ListNode fast = left;
		while (fast != right && fast.next != right) {
			fast = fast.next;
			fast = fast.next;
			slow = slow.next;
		}
		return slow;
	}
}
