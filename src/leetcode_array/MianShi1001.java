package leetcode_array;

import java.lang.reflect.Array;

/**
 * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
 * 
 * 初始化 A 和 B 的元素数量分别为 m 和 n。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/sorted-merge-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author jackjoily
 *
 */
public class MianShi1001 {
	public static void main(String[] args) {
		int a[] = { 1,2,4,5,6,0 };
		int b[] = { 3 };
		MianShi1001 m = new MianShi1001();
		m.merge(a,5, b, 1);
	}

	public void merge(int[] A, int m, int[] B, int n) {
		if (m == 0 || n == 0)
			return;
		int i = 0, j = 0, k = 0;
		int[] clone = A.clone();
		while (i < m && j < n) {
			if (clone[i] > B[j]) {
				A[k] = B[j];
				j++;

			} else {
				A[k] = clone[i];
				i++;
			}
			k++;
		}
		while (k < A.length && j < n) {
			A[k] = B[j];
			k++;
			j++;
		}
		while (k < A.length && i < m) {
			A[k] = clone[i];
			k++;
			i++;
		}
	}
}
