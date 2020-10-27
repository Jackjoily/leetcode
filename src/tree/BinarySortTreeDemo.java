package tree;

public class BinarySortTreeDemo {

	public static void main(String[] args) {
          int a[]= {7,3,10,12,5,1,9};
          BinarySortTree bi=new BinarySortTree();
          for(int i=0;i<a.length;i++) {
        	   bi.add(new BstNode(a[i])); 
          }
          bi.inOrder(bi.getRoot());
	}

}

class BinarySortTree {

	private BstNode root;

	public BstNode getRoot() {
		return root;
	}

	public void setRoot(BstNode root) {
		this.root = root;
	}

	public void add(BstNode node) {
		if (root == null) {
			root = node;
		} else {
			root.add(node);
		}
	}

	public void inOrder(BstNode node) {
		if (node != null) {
			inOrder(node.left);
			System.out.println(node);
			inOrder(node.right);
		}
	}
}

//二叉排序树的节点
class BstNode {
	int value;
	BstNode left;
	BstNode right;

	public BstNode(int value) {
		super();
		this.value = value;
	}

	// 添加节点的方法
	public void add(BstNode node) {
		if (node == null)
			return;
		if (node.value < this.value) {
			if (this.left == null) {
				this.left = node;
			} else {
				this.left.add(node);
			}
		} else {
			if (this.right == null) {
				this.right = node;
			} else {
				this.right.add(node);
			}
		}
	}

	@Override
	public String toString() {
		return "BstNode [value=" + value + "]";
	}

}
