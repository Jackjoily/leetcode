package leetcode;

import java.util.Arrays;
import java.util.HashMap;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

/**
 * twosum
 * 
 * @author jackjoily
 *
 */
public class E_836 {

	public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
		if (rec1[0] == rec1[2] || rec1[1] == rec1[3] || rec2[0] == rec2[2] || rec2[1] == rec2[3]) {
			return false;
		}
		return !(rec1[2] <= rec2[0] || // left
				rec1[3] <= rec2[1] || // bottom
				rec1[0] >= rec2[2] || // right
				rec1[1] >= rec2[3]); // top
	}
}
