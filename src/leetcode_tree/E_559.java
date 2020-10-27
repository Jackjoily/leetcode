package leetcode_tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个 N 叉树，找到其最大深度。
 * 
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 * 
 * 例如，给定一个 3叉树 :
 * 
 * @author jackjoily
 *
 */
public class E_559 {
	public static void main(String[] args) {
		Node1 n1 = new Node1(1);
		Node1 n3 = new Node1(3);
		Node1 n2 = new Node1(2);
		Node1 n4 = new Node1(4);
		Node1 n5 = new Node1(5);
		Node1 n6 = new Node1(6);
		List<Node1> list = new ArrayList<>();
		list.add(n3);
		list.add(n2);
		list.add(n4);
		n1.children = list;
		List<Node1> list1 = new ArrayList<>();
		list1.add(n5);
		list1.add(n6);
		n3.children = list1;
	
		System.out.println(	maxDepth(n1));
	}

	static List<Integer> list = new ArrayList<>();
	static int max = 0;

	public static int maxDepth(Node1 root) {
		dfs(root,0);
		if (list.size() == 0) {
			return 0;
		} else {
			int min = Integer.MIN_VALUE;
			for (int i = 0; i < list.size(); i++) {
				if (min < list.get(i)) {
					min = list.get(i);
				}
			}
			System.out.println(list);
			return min;
		}
	}

	public static void dfs(Node1 root, int max) {
		if (root == null) {
			return;
		} else {
			max++;
			if (root.children == null) {
				list.add(max);
				max = 0;
			} else {
				for (int i = 0; i < root.children.size(); i++) {
					dfs(root.children.get(i), max);
				}
			}
		}
	}
}
