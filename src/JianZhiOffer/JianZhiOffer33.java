package JianZhiOffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import leetcode_tree.TreeNode;

/**
 * 
 * 
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。 如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 * 
 * @author jackjoily
 *
 */
public class JianZhiOffer33 {
	public static void main(String[] args) {
		int a[] = { 4, 8, 6, 12, 16, 14, 10 };
		JianZhiOffer33 j = new JianZhiOffer33();
		boolean verifyPostorder = j.verifyPostorder(a);
		System.out.println(verifyPostorder);
	}

	public boolean verifyPostorder(int[] postorder) {
		return f(postorder, 0, postorder.length - 1);
	}

	public boolean f(int[] post, int low, int high) {
		if (high <= low)
			return true;
		int p = low;
		while (post[p] < post[high])
			p++;
		int m = p;
		while (post[p] > post[high])
			p++;
		return p == high ? f(post, low, m - 1) && f(post, m, high-1) : false;
	}

}
