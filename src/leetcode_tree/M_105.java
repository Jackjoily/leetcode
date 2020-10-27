package leetcode_tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 
 * @author jackjoily
 *
 */
public class M_105 {
	public static void main(String[] args) {
	}

	/**
	 * 前序遍历 preorder = [3,9,20,15,7] 中序遍历 inorder = [9,3,15,20,7]
	 * 
	 * @param preorder
	 * @param inorder
	 * @return
	 */
	 Map<Integer,Integer> map=new HashMap<>();
	   public  TreeNode buildTree(int[] preorder, int[] inorder) {
	       for(int i=0;i<inorder.length;i++){
	           map.put(inorder[i],i);
	       }
		return createNode(0, preorder.length-1, 0, inorder.length-1, preorder, inorder);
		}
		public  TreeNode createNode(int plow, int phigh, int ilow, int ihigh, int[] preorder, int[] inorder)
	     {
			if (plow > phigh)
				return null;
			TreeNode node = new TreeNode(preorder[plow]);
			int k=map.get(preorder[plow]) ;
			int num = k- ilow;
			node.left = createNode(plow + 1, plow + num, ilow, k - 1, preorder, inorder);
			node.right = createNode(plow + num + 1, phigh, k + 1, ihigh, preorder, inorder);
			return node;
		}

	public  void postOrder(TreeNode node) {
		if (node != null) {
			postOrder(node.left);
			postOrder(node.right);
			System.out.println(node.val);
		}
	}

}
