package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.swing.plaf.basic.BasicBorders.MarginBorder;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

/**
 * twosum
 * 
 * @author jackjoily
 *
 */
public class JianZhiOffer04 {

	public boolean findNumberIn2DArray(int[][] matrix, int target) {
		int m = matrix.length;
		if (m == 0)
			return false;
		int n = matrix[0].length;
		if (n == 0)
			return false;
		for (int i = 0; i < n;i++) {
			for (int j = m - 1; j >= 0;j--) {
				if (matrix[j][i] == target)
					return true;
				else if (matrix[j][i] < target) {
					break;
				} 
			}
		}
		return false;
	}
}
