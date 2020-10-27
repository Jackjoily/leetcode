package leetcode_tree;

/**
 * @ClassName E_1486
 * @Description
 * @Author Jackjoily
 * @Date 2020年6月26日 下午4:42:22
 */
public class E_1486 {

	public static void main(String[] args) {
		System.out.println(		xorOperation(1,7));
	}

	public static int xorOperation(int n, int start) {
		int nums[] = new int[n];
		int result = 0;
		for (int i = 0; i < n; i++) {
			nums[i] = start + 2 * i;
			if(i==0){
				result=nums[0];
			}
			if (i == 1) {
				result = nums[1] ^ nums[0];
			}
			if (i > 1) {
				result ^= nums[i];
			}
		}
		return result;
	}
}
