package leetcode_string;

import java.util.HashMap;
import java.util.Map;

import leetcode_tree.TreeNode;
import leetcode_tree.TreeUtils;

/**
 * 
 * 你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
 * 
 * 空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-string-from-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author jackjoily
 *
 */
public class E_606 {
	public static void main(String[] args) {
		E_606 e = new E_606();
		// TreeNode createTree = TreeUtils.createTree(4);
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		n1.left = n2;
		n1.right = n3;
		n2.right = n4;
		StringBuilder sb = new StringBuilder();
		e.preOrder(n1, sb, null);
		System.out.println(sb.toString());
	}

	public String tree2str(TreeNode t) {
		StringBuilder sb = new StringBuilder();
		if (t == null)
			return "";
		preOrder(t, sb, null);
		return sb.toString();
	}

	public void preOrder(TreeNode t, StringBuilder sb, TreeNode parent) {
		if (t != null) {
			if (parent == null) {
				sb.append(t.val);
				preOrder(t.left, sb, t);
				preOrder(t.right, sb, t);
			} else {
				sb.append("(");
				sb.append(t.val);
				preOrder(t.left, sb, t);
				preOrder(t.right, sb, t);
				sb.append(")");
			}
		} else {
			if (parent.left == null && parent.right != null) {
				sb.append("(" + ")");
			}
		}
	}
}
