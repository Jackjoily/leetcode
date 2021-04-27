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
public class M_205 {
	public boolean isIsomorphic(String s, String t) {
		if (s.length() != t.length())
			return false;
		for (int i = 0; i < s.length(); i++) {
			if (s.indexOf(s.charAt(i)) != t.indexOf(t.charAt(i))) {
				return false;
			}
		}
		return true;
	}
}
