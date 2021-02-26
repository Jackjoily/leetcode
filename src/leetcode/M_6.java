package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import javafx.scene.shape.Line;
import leetcode_list.ListNode;
import leetcode_tree.TreeNode;

/**
 * 
 * @author jackjoily
 *
 */
public class M_6 {
	public static void main(String[] args) {
		convert("PAYPALISHIRING", 4);
	}

	public static String convert(String s, int numRows) {
		char[] ch = s.toCharArray();
		int k = s.length();
		if (k == 1 || numRows == 1)
			return s;
		char c[][] = new char[numRows][k];
		int j = 0;
		int count = 0;
		int col = 0;
		while (j < k) {
			if (count % 2 == 0) {
				for (int i = 0; i < numRows - 1 && j < k; i++) {
					c[i][col] = ch[j];
					j++;
				}
			} else {
				for (int i = col - numRows + 1, l = numRows - 1; l >= 1 && j < k; i++, l--) {
					c[l][i] = ch[j];
					j++;
				}
			}
			col += numRows - 1;
			count++;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < c.length; i++) {
			for (int l = 0; l < c[0].length; l++) {
                   if(c[i][l]!='\u0000') {
                	   sb.append(c[i][l]);
                   }
			}
		}
		return sb.toString();
	}
}
