package leetcode_array;

import java.util.Arrays;

public class E_977 {
	public int[] sortedSquares(int[] A) {
			for (int k = 0; k < A.length; k++) {
				A[k] = A[k] * A[k];
			}
			Arrays.sort(A);
			return A;
		}
}
