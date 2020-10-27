package leetcode_tree;

public class E_100 {
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		n1.left = n2;
		n1.right = n3;

		TreeNode n11 = new TreeNode(1);
		TreeNode n22 = new TreeNode(2);
		TreeNode n33 = new TreeNode(3);
		n11.left = n22;
		n11.right = n33;
		System.out.println(isSameTree(n1, n11));
	}

	public static boolean isSameTree(TreeNode p, TreeNode q) {
		if (p != null && q != null) {
			if (p.val == q.val) {
				return isSameTree(p.left, q.left) & isSameTree(p.right, q.right);
			} else {
				return false;
			}
		} else if (p == null & q == null) {
			return true;
		} else {
			return false;
		}
	}
}
