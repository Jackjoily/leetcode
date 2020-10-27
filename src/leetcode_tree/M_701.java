package leetcode_tree;

/**
 * 给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 保证原始二叉搜索树中不存在新值。
 * 
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回任意有效的结果。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-into-a-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author jackjoily
 *
 */
public class M_701 {
	public TreeNode insertIntoBST(TreeNode root, int val) {
		if (root == null) {
			return root;
		}
		createNode(root, val);
		return root;
	}

	public void createNode(TreeNode root, int val) {
		if (root != null) {
			if (root.val > val) {
				if (root.left == null) {
					root.left = new TreeNode(val);
					return ;
				}
				createNode(root.left, val);
			} else {
				if (root.right == null) {
					root.right = new TreeNode(val);
					return ;
				}
				createNode(root.right, val);
			}
		}
	}
}
