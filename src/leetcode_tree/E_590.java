package leetcode_tree;

import java.util.ArrayList;
import java.util.List;
/**
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 * 
 * 例如，给定一个 3叉树 :
 * 
 * @author jackjoily
 *
 */
public class E_590 {
	private List<Integer> list = new ArrayList<>();

	public List<Integer> postorder(Node root) {
		if (root == null) {
			return list;
		} else {
			dfs(root);
			return list;
		}

	}

	public void dfs(Node root) {
		if (root != null) {
			List<Node> list1 = root.children;
			if (list1 != null) {
				for (int i = 0; i < list1.size(); i++) {
					dfs(list1.get(i));
				}
			}
			list.add(root.val);
		}
	}
}
