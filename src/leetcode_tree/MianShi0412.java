package leetcode_tree;

public class MianShi0412 {
	public static void main(String[] args) {
		TreeNode n5 = new TreeNode(5);
		TreeNode n4 = new TreeNode(4);
		TreeNode n8 = new TreeNode(8);
		TreeNode n11 = new TreeNode(11);
		TreeNode n7 = new TreeNode(7);
		TreeNode n2 = new TreeNode(2);
		TreeNode n13 = new TreeNode(13);
		TreeNode n44 = new TreeNode(4);
		TreeNode n55 = new TreeNode(5);
		TreeNode n1 = new TreeNode(1);
		n5.left = n4;
		n5.right = n8;
		n4.left = n11;
		n11.left = n7;
		n11.right = n2;
		n8.left = n13;
		n8.right = n44;
		n44.left = n5;
		n44.right = n1;
		MianShi0412 m = new MianShi0412();
		int res=m.pathSum(n5, 5);
		System.out.println(res);

	}

	int res = 0;

	public int pathSum(TreeNode root, int sum) {
		preOrder(root, sum);
		return res;
	}

	public void dfs(TreeNode root, int sum) {
		if (root == null) {
			return;	
		}
		if (root.val == sum) {
			res++;
		}
		dfs(root.left, sum - root.val);
		dfs(root.right, sum - root.val);
	}

	public void preOrder(TreeNode root, int sum) {
		if (root == null) {
			return;
		} else {
			dfs(root, sum);
			preOrder(root.left, sum);
			preOrder(root.right, sum);
		}
	}

}
