package JianZhiOffer;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import leetcode_list.ListNode;
import leetcode_tree.TreeNode;

/**
 * 
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 
 * @author jackjoily
 *
 */
public class JianZhiOffer07 {
	public static void main(String[] args) {
		JianZhiOffer07 j = new JianZhiOffer07();
		int[] inorder= {4,5,2,1,6,7,3};
		int[] preorder= {1,2,4,5,3,6,7};
		TreeNode.InOrder(j.buildTree(preorder, inorder));
	}

	Map<Integer, Integer> map = new HashMap<>();

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder.length == 0 || inorder.length == 0)
			return null;
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
		return createTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
	}

	public TreeNode createTree(int preorder[], int pl, int ph, int[] inorder, int il, int ih) {
		if (pl > ph)
			return null;
		int k = map.get(preorder[pl]);
		TreeNode t = new TreeNode(preorder[pl]);
		int num = k - il;
		t.left = createTree(preorder, pl + 1, pl + num, inorder, il, k - 1);
		t.right = createTree(preorder, pl + num + 1, ph, inorder, k + 1, ih);
		return t;
	}
}
