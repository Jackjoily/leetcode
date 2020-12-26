package leetcode_dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class M_139 {
	public static void main(String[] args) {
		List<String> l = new ArrayList<>();
		l.add("cat");
		l.add("sand");
		l.add("og");
		String s = "catsandog";
		System.out.println(wordBreak1(s, l));
	}

	public static boolean wordBreak1(String s, List<String> wordDict) {
		int length = s.length();
		if (wordDict.size() == 0 || length == 0)
			return false;
		Set<String> set = new HashSet<>(wordDict);
		int dp[] = new int[length];
		dp[0] = set.contains(s.substring(0, 1)) == true ? 1 : 0;
		for (int i = 1; i < length; i++) {
			if (set.contains(s.substring(0, i + 1))) {
				dp[i] = 1;
			}else {
				for (int j = 0; j < i; j++) {
					if (dp[j] == 1 && set.contains(s.substring(j+1, i + 1))) {
						dp[i] = 1;
						break;
					}
				}
			}
		}
		return dp[length - 1] == 1;
	}

	public boolean wordBreak(String s, List<String> wordDict) {
		if (wordDict.size() == 0 || s.length() == 0)
			return false;
		Set<String> set = new HashSet<>(wordDict);
		int length = s.length();
		int dp[][] = new int[length][length];
		int i = 0;
		for (int j = 0; j < length; j++) {
			for (i = j; i < length; i++) {
				if (set.contains(s.subSequence(i, j))) {
					dp[j][i] = 1;
				}
			}
		}
		int l = 0;
		while (l < length) {
			for (i = 0; i < length - 1; i++) {
				if (dp[0][i] == 1) {
					for (int j = i + 1; j < length; j++) {
						if (dp[i + 1][j] == 0) {

						}
					}
				}
			}
		}
		return false;
	}
}
