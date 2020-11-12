package leetcode_dp;

public class E_941 {
	public static void main(String[] args) {
		E_941 e = new E_941();
		int a[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(e.validMountainArray(a));

	}

	boolean flag = true;

	public boolean validMountainArray(int[] A) {
		if (A.length < 3) {
			return false;
		}
		int i = 0;
		while (i < A.length - 1) {
			while (i < A.length - 1 && A[i] < A[i + 1])
				i++;
			if (i==0||i == A.length - 1 || A[i] == A[i + 1])
				return false;
			while (i < A.length - 1 && A[i] > A[i + 1])
				i++;
			if (i < A.length - 1) {
				return false;
			}
		}

		return flag;
	}
}
