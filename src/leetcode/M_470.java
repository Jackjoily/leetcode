package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 
 * @author jackjoily
 *
 */
public class M_470 {

	public int rand10() {
		int a = rand10();
		int b = rand10();
		int inx = ((a - 1) * 7 + b - 1);
		while (inx > 40) {
			a = rand10();
			b = rand10();
			inx = ((a - 1) * 7 + b - 1);
		}
		return inx % 10;
	}
}
