package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * twosum
 * 
 * @author jackjoily
 *
 */
public class H_127 {
	public static void main(String[] args) {
		H_127 h = new H_127();
		List<String> asList = Arrays.asList("ymann","yycrj","oecij","ymcnj","yzcrj","yycij","xecij","yecij","ymanj","yzcnj","ymain");
		System.out.println(h.ladderLength("ymain", "oecij", asList));
	}

	static Set<String> wordSet;
	static Set<String> visited;
	static Queue<String> q;

	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		int count = 1;
		if (beginWord.equals(endWord))
			return count;
		wordSet = new HashSet<>(wordList);
		if (!wordSet.contains(endWord))
			return 0;
		q = new ArrayDeque<>();
		q.add(beginWord);
		visited = new HashSet<>();
		visited.add(beginWord);
		while (!q.isEmpty()) {
			for (int i = q.size(); i > 0; i--) {
				String poll = q.poll();
				if (isOkay(poll, endWord, wordSet, visited)) {
					return count + 1;
				}
			}
			count++;
		}
		return visited.contains(endWord) ? count : 0;
	}

	public static boolean isOkay(String str, String endWord, Set<String> wordSet, Set<String> visited) {
		char[] c = str.toCharArray();
		for (int j = 0; j < c.length; j++) {
			char temp = c[j];
			for (char i = 'a'; i <='z'; i++) {
				if (c[j] == i)
					continue;
				c[j] = i;
				String s = new String(c);
				if (!visited.contains(s) && wordSet.contains(s)) {
					if (endWord.equals(s)) {
						return true;
					}
					q.add(s);
					visited.add(s);
				}
			}
			c[j] = temp;
		}
		return false;
	}
}
