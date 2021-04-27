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
		List<String> asList = Arrays.asList("hot","dog");
		System.out.println(h.ladderLength("hot", "dog", asList));
	}

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if (!wordList.contains(endWord))
			return 0;
		Set<String> set = new HashSet<>();
		Set<String> visitd = new HashSet<>();
		set.addAll(wordList);
		ArrayDeque<String> q = new ArrayDeque<>();
		q.add(beginWord);
		visitd.add(beginWord);
		int count = 1;
		while (q.size() != 0) {
			for (int i = q.size(); i > 0; i--) {
				String poll = q.poll();
				if (isOkay(poll, endWord, set, visitd, q)) {
					return count + 1;
				}
			}
			count++;
		}
		return !visitd.contains(endWord)?0:count;

	}

	public boolean isOkay(String word, String endWord, Set<String> set, Set<String> visited, Queue<String> q) {
		char[] c = word.toCharArray();
		for (int j = 0; j < c.length; j++) {
			char ch = c[j];
			for (char i = 'a'; i <= 'z'; i++) {
				if (ch != i) {
					c[j] = i;
					String str = new String(c);
					if (set.contains(str) && !visited.contains(str)) {
						if (str.equals(endWord))
							return true;
						q.add(str);
						visited.add(str);
					}
				}
			}
			c[j] = ch;
		}
		return false;
	}
}
