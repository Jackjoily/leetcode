package leetcode;

import java.util.HashMap;
import java.util.Map;

import leetcode_tree.TreeNode;

/**
 * twosum
 * 
 * @author jackjoily
 *
 */
public class JianZhiOffer07 {
	Map<Integer, Integer> map;

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		map = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
		return create(preorder, 0, preorder.length-1, inorder, 0, preorder.length-1);
	}

	public TreeNode create(int[] pre, int pl, int ph, int[] inorder, int il, int lh) {
		if (pl > ph)
			return null;
		int val = pre[pl];
		int inx = map.get(val);
		int num = inx - il;
		TreeNode root = new TreeNode(val);
		root.left = create(pre, pl + 1, pl + num, inorder, il, inx - 1);
		root.right = create(pre, pl + num + 1, ph, inorder, inx + 1, lh);
		return root;
	}

}
