package leetcode_tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.sun.xml.internal.ws.wsdl.parser.InaccessibleWSDLException;

/**
 * 
 * @author jackjoily
 *
 */
public class M_449 {
	public static void main(String[] args) {
		TreeNode n2 = new TreeNode(2);
		TreeNode n1 = new TreeNode(1);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		n2.left = n1;
		n2.right = n3;
		n3.right = n4;
		M_449 m = new M_449();
		String str = m.serialize(n2);
		TreeNode n = m.deserialize(str);
		TreeNode.InOrder(n);
	}

	private Map<Integer, Integer> map = new HashMap<>();

	public StringBuilder dfs(TreeNode root, StringBuilder sb) {
		if (root == null) {
			return sb;
		}
		dfs(root.left, sb);
		dfs(root.right, sb);
		sb.append(root.val);
		sb.append(" ");
		return sb;
	}

	public String serialize(TreeNode root) {
		if (root == null) {
			return null;
		} else {
			return dfs(root, new StringBuilder()).toString();
		}
	}

	public int[] getarray(String str) {
		if (str == null) {
			return null;
		} else {
			String[] split = str.split(" ");
			int a[] = new int[split.length];
			for (int i = 0; i < split.length; i++) {
				a[i] = Integer.valueOf(split[i]);
			}
			return a;
		}

	}

	public TreeNode deserialize(String data) {
		int p[] = getarray(data);
		int in[] = p.clone();
		Arrays.sort(in);
		for (int i = 0; i < in.length; i++) {
			map.put(in[i], i);
		}
		return createNode(p, in, 0, p.length - 1, 0, in.length - 1);
	}

	public TreeNode createNode(int post[], int in[], int pl, int ph, int il, int ih) {
		if (pl > ph || pl < 0) {
			return null;
		} else {
			TreeNode node = new TreeNode(post[ph]);
			int k = map.get(post[ph]);
			// 中序右边的个数
			int num = ih - k;
			node.left = createNode(post, in, pl, ph - num - 1, il, k - 1);
			node.right = createNode(post, in, ph - num, ph - 1, k + 1, ih);
			return node;
		}

	}

}
