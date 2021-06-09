package Shopee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

import jdk.nashorn.internal.runtime.regexp.joni.ScanEnvironment;
import leetcode_tree.TreeNode;

public class Test4 {
	static Map<Integer, Integer> map;

	public static void main(String[] args) {
		Test4 t=new Test4();
		Scanner sc = new Scanner(System.in);
		map = new HashMap<>();
		List<Integer> list = new ArrayList<>();
		String str=sc.nextLine();
		String[] split = str.split(" ");
	
		int a[] = new int[split.length];
		for (int i = 0; i < a.length; i++) {
			a[i] = Integer.valueOf(split[i]);
		}
		int[] b = a.clone();
		Arrays.sort(b);
		for (int i = 0; i < b.length; i++) {
			map.put(b[i], i);
		}
		TreeNode creatTreeNode = t.creatTreeNode(a, 0, a.length-1, b, 0, a.length-1);
		t.dfs(creatTreeNode);
	}

	public TreeNode creatTreeNode(int preOrder[], int pl, int ph, int inorder[], int il, int ih) {
		if (pl >ph)
			return null;
		TreeNode node = new TreeNode(preOrder[pl]);
		int inx = map.get(preOrder[pl]);
		int num = inx - il;
		node.left = creatTreeNode(preOrder, pl + 1, pl + num, inorder, il, inx - 1);
		node.right = creatTreeNode(preOrder, pl + num + 1, ph, inorder, inx + 1, ih);
		return node;
	}

   public void dfs(TreeNode root) {
	   if(root!=null) {
		   if(root.left==null&&root.right==null) {
			   System.out.println(root.val);
		   }else {
			   dfs(root.left);
			   dfs(root.right);
		   }
	   }
   }
}
