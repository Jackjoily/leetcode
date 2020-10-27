package tree;

public class ThreadTree {

	private HeroNode root;
	private HeroNode pre = null;// pre指向前驱节点

	public static void main(String[] args) {
		HeroNode root = new HeroNode(1, "tom");
		HeroNode node2 = new HeroNode(3, "jack");
		HeroNode node3 = new HeroNode(6, "tom");
		HeroNode node4 = new HeroNode(8, "marry");
		HeroNode node5 = new HeroNode(10, "king");
		HeroNode node6 = new HeroNode(14, "dim");
		root.setLeft(node2);
		root.setRight(node3);
		node2.setLeft(node4);
		node2.setRight(node5);
		node3.setLeft(node6);
		ThreadTree t = new ThreadTree();
		t.threadNodes(root);
		System.out.println(node5.getLeft());
		System.out.println(node5.getRight());
	}

	public void threadNodes(HeroNode node) {
		// 如果Node=null
		if (node == null) {
			return;
		}
		threadNodes(node.getLeft());
		// 出去当前节点的前驱节点
		if (node.getLeft() == null) {
			node.setLeft(pre);
			node.setLeftType(1);
		}
		if (pre != null && pre.getRight() == null) {
			pre.setRight(node);
			pre.setLeftType(1);
		}
		pre = node;
		threadNodes(node.getRight());
		// 先线索化左子树
		// 在线索化右子树

	}

	public HeroNode getRoot() {
		return root;
	}

	public void setRoot(HeroNode root) {
		this.root = root;
	}
}

class HeroNode {
	private int no;
	private String name;
	private HeroNode left;
	private HeroNode right;
	// 0是子树，1是节点
	private int leftType;
	private int rightType;

	public HeroNode(int no, String name) {
		this.no = no;
		this.name = name;
	}

	public int getNo() {
		return no;
	}


	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + "]";
	}

	public int getLeftType() {
		return leftType;
	}

	public void setLeftType(int leftType) {
		this.leftType = leftType;
	}

	public int getRightType() {
		return rightType;
	}

	public void setRightType(int rightType) {
		this.rightType = rightType;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HeroNode getLeft() {
		return left;
	}

	public void setLeft(HeroNode left) {
		this.left = left;
	}

	public HeroNode getRight() {
		return right;
	}

	public void setRight(HeroNode right) {
		this.right = right;
	}

}