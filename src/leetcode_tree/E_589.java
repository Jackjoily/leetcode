package leetcode_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 * 
 * 例如，给定一个 3叉树 :
 * 
 * @author jackjoily
 *
 */
public class E_589 {
	private List<Integer> list = new ArrayList<>();

	public List<Integer> preorder(Node root) {
		if (root == null) {
			return list;
		} else {
			dfs(root);
			return list;
		}

	}

	public void dfs(Node root) {
		if (root != null) {
			list.add(root.val);
			List<Node> list = root.children;
			if (list != null) {
				for (int i = 0; i < list.size(); i++) {
					preorder(list.get(i));
				}
			}
		}
	}
}
