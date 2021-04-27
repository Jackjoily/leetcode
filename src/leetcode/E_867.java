package leetcode;

import java.util.Arrays;
import java.util.HashMap;

import javax.swing.plaf.basic.BasicBorders.MarginBorder;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

/**
 * twosum
 * 
 * @author jackjoily
 *
 */
public class E_867 {
	public int[][] transpose(int[][] matrix) {
		  int m = matrix.length, n = matrix[0].length;
	        int[][] transposed = new int[n][m];
	        for (int i = 0; i < m; i++) {
	            for (int j = 0; j < n; j++) {
	                transposed[j][i] = matrix[i][j];
	            }
	        }
	        return transposed;
	}
}
