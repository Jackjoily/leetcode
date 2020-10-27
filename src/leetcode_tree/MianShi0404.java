package leetcode_tree;

/**
 * @ClassName E_0404
 * @Description 实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。
 * @Author Jackjoily
 * @Date 2020年6月27日 下午4:14:41
 */
public class MianShi0404 {
	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		if (Math.abs(Height(root.left) - Height(root.right)) <= 1) {
			return isBalanced(root.left) && isBalanced(root.right);
		}
		return false;
	}
	public int Height(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = Height(root.left);
		int right = Height(root.right);
		return left > right ? left + 1 : right + 1;
	}
}
