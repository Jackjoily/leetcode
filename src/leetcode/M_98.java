package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import leetcode_list.ListNode;
import leetcode_tree.TreeNode;

/**
 * 
 * @author jackjoily
 *
 */
public class M_98 {
	public static void main(String[] args) {
		M_98 m = new M_98();
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		n3.left = n2;
		n2.left = n1;
		n3.right = n5;
		n5.left = n4;
		Info process = m.process(n3);
		System.out.println(process);
	}

	public static class Info {
		boolean flag;
		int max;
		int min;

		public Info(boolean flag) {
			this.flag = flag;
		}

		public Info() {
		}

		public boolean isFlag() {
			return flag;
		}

		public void setFlag(boolean flag) {
			this.flag = flag;
		}

		public int getMax() {
			return max;
		}

		public void setMax(int max) {
			this.max = max;
		}

		public int getMin() {
			return min;
		}

		public void setMin(int min) {
			this.min = min;
		}

		@Override
		public String toString() {
			return "Info [flag=" + flag + ", max=" + max + ", min=" + min + "]";
		}

	}

	public boolean isValidBST(TreeNode root) {
		return process(root).flag;
	}

	public Info process(TreeNode root) {
		if (root == null) {
			return null;
		}
		Info info = new Info();
		info.max = root.val;
		info.min = root.val;
		Info left = process(root.left);
		Info right = process(root.right);
		if (left == null && right == null) {
			info.setFlag(true);
			return info;
		} else if (left == null || right == null) {
			if (left == null) {
				if (right.min > root.val) {
					info.flag = true;
					info.max = right.max;
					return info;
				} else {
					info.flag = false;
					return info;
				}
			} else {
				if (left.max < root.val) {
					info.flag = true;
					info.min = left.min;
					return info;
				} else {
					info.flag = false;
					return info;
				}
			}
		} else {
			if (left.flag && right.flag) {
				if (left.max < root.val && right.min > root.val) {
					info.flag = true;
					info.max = right.max;
					info.min = left.min;
					return info;
				} else {
					info.flag = false;
					return info;
				}
			} else {
				info.setFlag(false);
				return info;
			}
		}
	}
}
