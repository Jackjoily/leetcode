package leetcode_string;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author jackjoily
 *
 */
public class E_520 {
	public static void main(String[] args) {
		System.out.println(detectCapitalUse("CcZe"));
	}

	public static boolean detectCapitalUse(String word) {
		if (word.length() == 1) {
			return true;
		} else {
			// 开头小写字母
			if (word.charAt(0) > 'Z') {
				for (int i = 1; i < word.length(); i++) {
					if (word.charAt(i) < 'a')
						return false;
				}
				return true;
			} else {
				// 开头小写字母
				// 第二个字母是大写字母
				if (word.charAt(1) < 'Z') {
					for (int i = 2; i < word.length(); i++) {
						if (word.charAt(i) > 'Z')
							return false;
					}
					return true;
				} else {
					// 第二个字母是小写字母
					for (int i = 2; i < word.length(); i++) {
						if (word.charAt(i) <= 'Z')
							return false;
					}
					return true;
				}
			}
		}
	}
}
