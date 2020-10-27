package basic;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {
	public static void main(String[] args) {
//		TreeNode TreeNode = new TreeNode(1);
//		TreeNode TreeNode1 = new TreeNode(2);
//		TreeNode TreeNode2 = new TreeNode(3);
//		TreeNode TreeNode3 = new TreeNode(4);
//		TreeNode TreeNode4 = new TreeNode(5);
//		TreeNode TreeNode5 = new TreeNode(6);
//		TreeNode TreeNode6 = new TreeNode(7);
//		TreeNode TreeNode7 = new TreeNode(8);
//		TreeNode.left = TreeNode1;
//		TreeNode.right = TreeNode2;
//		TreeNode1.left = TreeNode3;
//		TreeNode1.right = TreeNode4;
//		TreeNode2.left = TreeNode5;
//		TreeNode2.right = TreeNode6;
//		TreeNode3.left = TreeNode7;
//		ThreadTree TreeNode = new ThreadTree(1);
//		ThreadTree TreeNode1 = new ThreadTree(2);
//		ThreadTree TreeNode2 = new ThreadTree(3);
//		ThreadTree TreeNode3 = new ThreadTree(4);
//		ThreadTree TreeNode4 = new ThreadTree(5);
//		ThreadTree TreeNode5 = new ThreadTree(6);
//		ThreadTree TreeNode6 = new ThreadTree(7);
//		ThreadTree TreeNode7 = new ThreadTree(8);
//		TreeNode.left=TreeNode1;
//		TreeNode1.left=TreeNode2;
//		TreeNode2.left=TreeNode3;
//		TreeNode3.left=TreeNode4;
//		TreeNode.right=TreeNode5;
//		TreeNode5.right=TreeNode6;
//		TreeNode6.right=TreeNode7;
//		ThreadTree pre=null;
//		InThreadTree(TreeNode,pre);
//		pre.rtag=1;
		int a[] = { 45, 24, 53, 45, 12, 24 };
		TreeNode p = new TreeNode(a[0]);
		for (int i = 1; i < a.length; i++) {
			Insert_BST(p, a[i]);
		}
		InOrder(p);
	}

	public static void InOrder(TreeNode TreeNode) {
		TreeNode stack[] = new TreeNode[100];
		int tail = -1;
		TreeNode p = TreeNode;
		while (p != null || tail != -1) {
			if (p != null) {
				stack[++tail] = p;
				p = p.left;
			} else {
				p = stack[tail--];
				System.out.println(p.val);
				p = p.right;
			}
		}

	}

	public static void PreOrder(TreeNode TreeNode) {
		TreeNode stack[] = new TreeNode[100];
		int tail = -1;
		TreeNode p = TreeNode;
		while (p != null || tail != -1) {
			if (p != null) {
				System.out.println(p.val);
				stack[++tail] = p;
				p = p.left;
			} else {
				p = stack[tail--];

				p = p.right;
			}
		}

	}

	public static void LevelOrder(TreeNode TreeNode) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		if (TreeNode != null) {
			queue.add(TreeNode);
		}
		while (!queue.isEmpty()) {
			TreeNode p = queue.poll();
			System.out.println(p.val);
			if (p.left != null) {
				queue.add(p.left);
			}
			if (p.right != null) {
				queue.add(p.right);
			}
		}
	}

	public static void PostOrder(TreeNode node) {
		TreeNode stack[] = new TreeNode[100];
		int tail = -1;
		TreeNode p = node;
		TreeNode r = null;
		while (p != null || tail != -1) {
			if (p != null) {
				stack[++tail] = p;
				p = p.left;
			} else {
				p = stack[tail];
				if (p.right != null && p.right != r) {
					p = p.right;
					stack[++tail] = p;
					p = p.left;
				} else {
					p = stack[tail--];
					System.out.println(p.val);
					r = p;
					p = null;
				}
			}
		}

	}

	/**
	 * 非递归统计树的高度
	 * 
	 * @param TreeNode
	 * @return
	 */
	public static int LevelHeight(TreeNode TreeNode) {
		int level = 0;
		if (TreeNode == null) {
			return 0;
		}
		TreeNode[] queue = new TreeNode[100];
		int front = -1, rear = -1;
		queue[++rear] = TreeNode;
		int last = 0;
		while (front < rear) {
			TreeNode p = queue[++front];
			if (p.left != null) {
				queue[++rear] = p.left;
			}
			if (p.right != null) {
				queue[++rear] = p.right;
			}
			if (front == last) {
				level++;
				last = rear;
			}
		}
		return level;
	}

	public static int depeth(TreeNode TreeNode) {
		if (TreeNode == null) {
			return 0;
		}
		int left = depeth(TreeNode.left);
		int right = depeth(TreeNode.right);
		return left > right ? left + 1 : right + 1;
	}

	/**
	 * 判断一棵二叉树是否为完全二叉树
	 * 
	 * @param TreeNode
	 * @return
	 */
	public static boolean isCompleteBinaryTree(TreeNode TreeNode) {
		boolean flag = true;
		if (TreeNode == null) {
			return flag;
		}
		TreeNode p = null;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(TreeNode);
		while (!queue.isEmpty() && flag == true) {
			p = queue.poll();
			if (p != null) {
				queue.add(p.left);
				queue.add(p.right);
			} else {
				while (!queue.isEmpty()) {
					p = queue.poll();
					if (p != null) {
						flag = false;
					}
				}
			}
		}
		return flag;
	}

	public static int DoubleBranchTreeNode(TreeNode TreeNode) {
		if (TreeNode == null) {
			return 0;
		} else {
			if (TreeNode.left != null && TreeNode.right != null) {
				return DoubleBranchTreeNode(TreeNode.left) + DoubleBranchTreeNode(TreeNode.right) + 1;
			}
			return DoubleBranchTreeNode(TreeNode.left) + DoubleBranchTreeNode(TreeNode.right);
		}
	}

	/**
	 * 查找该节点的所有父节点
	 * 
	 * @param p
	 * @param val
	 */
	public static void PrintParentTreeNode(TreeNode p, int val) {
		TreeNode stack[] = new TreeNode[100];
		int tail = -1;
		TreeNode r = null;
		boolean flag = false;
		while (p != null || tail != -1) {
			if (p != null) {
				stack[++tail] = p;
				p = p.left;
			} else {
				p = stack[tail];
				if (p.right != null && p.right != r) {
					p = p.right;
					stack[++tail] = p;
					p = p.left;
				} else {
					p = stack[tail--];
					if (p.val == val) {
						flag = true;
						break;
					}
					r = p;
					p = null;
				}

			}
		}
		while (flag == true && tail != -1) {
			System.out.println(stack[tail--].val);
		}

	}

	/**
	 * 中序线索二叉树
	 * 
	 * @param p
	 * @param pre
	 */
	public static void InThreadTree(ThreadTree p, ThreadTree pre) {
		if (p.left != null) {
			InThreadTree(p.left, pre);
			if (p.left == null) {
				p.left = pre;
				p.ltag = 1;
			}
			if (pre != null && pre.right == null) {
				pre.right = p.left;
				p.rtag = 1;
			}
		}
		pre = p;
		InThreadTree(p.right, pre);
	}

	/**
	 * 建立二叉查找树
	 * 
	 * @param p
	 * @param k
	 */
	public static void Insert_BST(TreeNode p, int k) {
		if (p.val < k) {
			if (p.right == null)
				p.right = new TreeNode(k);
			else
				Insert_BST(p.right, k);
		} else if (p.val == k) {
			return;
		} else {
			if (p.left == null)
				p.left = new TreeNode(k);
			else
				Insert_BST(p.left, k);
		}
	}

	public static void assign(TreeNode p) {
		p = new TreeNode(5);
	}
}

class TreeNode {
	public TreeNode left;
	public TreeNode right;
	int val;

	public TreeNode(int val) {
		super();
		this.val = val;
	}

	static {
		System.out.println("TreeNode--->被初始化了");
	}

}
