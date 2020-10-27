package leetcode_tree;

import java.util.LinkedList;
import java.util.Queue;

import basic.Tree;

/**
 * 给定一个二叉树，根节点为第1层，深度为 1。在其第 d 层追加一行值为 v 的节点。
 * 
 * 添加规则：给定一个深度值 d （正整数），针对深度为 d-1 层的每一非空节点 N，为 N 创建两个值为 v 的左子树和右子树。
 * 
 * 将 N 原先的左子树，连接为新节点 v 的左子树；将 N 原先的右子树，连接为新节点 v 的右子树。
 * 
 * 如果 d 的值为 1，深度 d - 1 不存在，则创建一个新的根节点 v，原先的整棵树将作为 v 的左子树。
 * 
 * 来源：力扣（LeetCode）
 * 
 * @author jackjoily
 *
 */
public class M_623 {

	public static void main(String args[]) {
		TreeNode node4 = new TreeNode(4);
		TreeNode node2 = new TreeNode(2);
		TreeNode node6 = new TreeNode(6);
		TreeNode node3 = new TreeNode(3);
		TreeNode node1 = new TreeNode(1);
		TreeNode node5 = new TreeNode(5);
		node4.left = node2;
		node4.right = node6;
		node2.left = node3;
		node2.right = node1;
		node6.left = node5;
//		TreeNode.LevelOrder(node4);
		TreeNode root=addOneRow(node4,1,3);
	    TreeNode.LevelOrder(root);

	}

	public static TreeNode addOneRow(TreeNode root, int v, int d) {
		if(d==1) {
			TreeNode node=new TreeNode(v);
			node.left=root;
			return node;
		}else {
			Queue<TreeNode> queue = new LinkedList<>();
			int front = -1, rear = -1;
			int last = 0;
			TreeNode p = root;
			TreeNode left = null, right = null;
			queue.add(p);
			rear++;
			int j = 1;
			boolean flag=true;
			while (front < rear&&flag) {
				p = queue.poll();
				front++;
				if (p.left != null) {
					queue.add(p.left);
					rear++;
				}
				if (p.right != null) {
					queue.add(p.right);
					rear++;
				}
				if(d-j==1) {
					left = p.left;
					right = p.right;
					TreeNode nodeleft = new TreeNode(v);
					TreeNode noderight = new TreeNode(v);
					p.left = nodeleft;
					p.right = noderight;
					nodeleft.left = left;
					noderight.right = right;
				}
				if (front == last) {
					last = rear;
					j++;
				}

			}	
			
		}
	
		return root;

	}

}
