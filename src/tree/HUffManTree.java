package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HUffManTree {
	public static void main(String[] args) {
		int a[] = { 13, 7, 8, 3, 29, 6, 1 };
		PreOrder(createHuffmanTree(a));
	}

	/**
	 * 创建一棵哈夫曼树
	 * 
	 * @param a
	 * @return
	 */
	public static Node createHuffmanTree(int[] a) {
		List<Node> list = new ArrayList<Node>();
		for (int val : a) {
			list.add(new Node(val));
		}
		// 从小到大进行排序
		while (list.size() != 1) {
			Collections.sort(list);
			Node left = list.get(0);
			Node right = list.get(1);
			Node parent = new Node(left.weight + right.weight);
			parent.left = left;
			parent.right = right;
			list.remove(left);
			list.remove(right);
			list.add(parent);
		}
		return list.get(0);
	}

	public static void PreOrder(Node node) {
		if (node != null) {
			System.out.print(node.weight + "--->");
			PreOrder(node.left);
			PreOrder(node.right);
		}
	}
}

class Node implements Comparable<Node> {
	int weight;
	Byte c;// 字符
	Node left;
	Node right;

	public Node(int weight) {
		super();
		this.weight = weight;
	}

	public Node(Byte c,int weight) {
		super();
		this.weight = weight;
		this.c = c;
	}

	@Override
	public String toString() {
		return "Node [weight=" + weight + ", c=" + c + "]";
	}

	@Override
	public int compareTo(Node o) {
		return this.weight - o.weight;
	}

}
