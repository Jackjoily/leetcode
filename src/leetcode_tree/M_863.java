package leetcode_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。
 * 
 * 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @param root
 * @param target
 * @param K
 * @return
 */
public class M_863 {
	List<Integer> ans;
	TreeNode target;
	int K;

	public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
		ans = new LinkedList();
		this.target = target;
		this.K = K;
		dfs(root);
		return ans;
	}

	public int dfs(TreeNode node) {
		if (node == null)
			return -1;
		else if (node == target) {
			//如果这个节点就等于target，则吧子节点中距离k的节点加入到list中
			subtree_add(node, 0);
			return 1;
		} else {
			int L = dfs(node.left), R = dfs(node.right);
			if (L != -1) {
				if (L == K)
					ans.add(node.val);
				subtree_add(node.right, L + 1);
				return L + 1;
			} else if (R != -1) {
				if (R == K)
					ans.add(node.val);
				subtree_add(node.left, R + 1);
				return R + 1;
			} else {
				return -1;
			}
		}
	}
	// 将距离该节点距离为k的节点添加到list中
	public void subtree_add(TreeNode node, int dist) {
		if (node == null)
			return;
		if (dist == K)
			ans.add(node.val);
		else {
			subtree_add(node.left, dist + 1);
			subtree_add(node.right, dist + 1);
		}
	}
}
