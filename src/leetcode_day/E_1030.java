package leetcode_day;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 *
 * 给出 R 行 C 列的矩阵，其中的单元格的整数坐标为 (r, c)，满足 0 <= r < R 且 0 <= c < C。
 * 
 * 另外，我们在该矩阵中给出了一个坐标为 (r0, c0) 的单元格。
 * 
 * 返回矩阵中的所有单元格的坐标，并按到 (r0, c0) 的距离从最小到最大的顺序排，其中，两单元格(r1, c1) 和 (r2, c2)
 * 之间的距离是曼哈顿距离，|r1 - r2| + |c1 - c2|。（你可以按任何满足此条件的顺序返回答案。）
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/matrix-cells-in-distance-order
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 *
 *
 *
 */
public class E_1030 {
	public static void main(String[] args) {
		System.out.println(Arrays.deepToString(allCellsDistOrder(2,2,0,1)));
	}

	public static int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
		if (R == 1 && C == 1) {
			return new int[1][1];
		} else {
			int n = R * C;
			int a[][] = new int[n][2];
			int k = 0;
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					a[k] = new int[] { i, j };
					k++;
				}
			}
			Arrays.sort(a, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					// TODO Auto-generated method stub
					return (Math.abs(o1[0] - r0) + Math.abs(o1[1] - c0))
							- (Math.abs(o2[0] - r0) + Math.abs(o2[1] - c0));
				}
			});
			return a;
		}
	
	}
}
