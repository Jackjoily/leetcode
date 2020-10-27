package leetcode_tree;

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * 
 * @author jackjoily
 *
 */
public class E_108 {
	/**
	 * 给了一个有序数组，相当于告诉一棵树的中序遍历了，所以此时的树任然是不确定的 ，再给一个限制条件平衡二叉树，这棵树任然可能含有多种情况
	 * 
	 * @param nums
	 * @return
	 */
	public TreeNode sortedArrayToBST(int[] nums) {
		return createNode(0, nums.length - 1, nums);
	}
   /**
    * 至于这里为什么是二叉平衡树，在1382 官方题解中有正确性好的证明
    * @param low
    * @param high
    * @param num
    * @return
    */
	// 这也是一种分治法的体现，与前面（前序，中序）以及（中序，后序）建立二叉树是同样的思想
	public TreeNode createNode(int low, int high, int[] num) {
		if (low > high) {
			return null;
		}
		int mid = (low + high) / 2;
		TreeNode root = new TreeNode(num[mid]);
		root.left = createNode(low, mid - 1, num);
		root.right = createNode(mid + 1, high, num);
		return root;
	}

}
