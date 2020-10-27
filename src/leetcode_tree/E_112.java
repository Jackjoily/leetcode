package leetcode_tree;

public class E_112 {
	public boolean hasPathSum(TreeNode root, int sum) {
		dfs(root, sum);
		return res==0?false:true;
	}

	int res = 0;

	public void dfs(TreeNode root, int sum) {
		if (root == null) {
			return;	
		}
		if (root.val == sum) {
			if(root.left==null&&root.right==null) {
				res++;
			}
		}
		dfs(root.left, sum - root.val);
		dfs(root.right, sum - root.val);
	}

}
