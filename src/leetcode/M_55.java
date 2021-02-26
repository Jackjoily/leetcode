package leetcode;

import java.util.Arrays;
import java.util.HashMap;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import leetcode_list.ListNode;

public class M_55 {
	public static void main(String[] args) {
	}

	public boolean canJump(int[] nums) {
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i > index)
				return false;
			index = Math.max(index,i + index);
		}
		return true;
	}
}
