package Violence;

public class KMPAlgotithm {
	public static void main(String[] args) {
		String str1 = "BBC ABCDAB ABCDABCDABDE";
		String str2 = "ABCDABD";
		System.out.println(kmpSearch(str1, str2, getNext(str2)));
	}

	// 获取到一个字符串的部分匹配

	public static int[] getNext(String str) {
		int next[] = new int[str.length()];
		next[0] = 0;
		for (int i = 1, j = next[0]; i < str.length(); i++) {
			while (j > 0 && str.charAt(i) != str.charAt(j)) {
				j = next[j - 1];
			}
			if (str.charAt(i) == str.charAt(j)) {
				j++;
			}
			next[i] = j;
		}
		return next;
	}

	/**
	 * 
	 * @param str1 主串
	 * @param str2 子串
	 * @param next 部分匹配值
	 * @return -1就是没有匹配到
	 */
	public static int kmpSearch(String str1, String str2, int[] next) {
		for (int i = 0, j = 0; i < str1.length(); i++) {
			while (j > 0 && str1.charAt(i) != str2.charAt(j)) {
				j = next[j - 1];
			}
			if (str1.charAt(i) == str2.charAt(j)) {
				j++;
			}
			if (j == str2.length()) {
				return i - j + 1;
			}
		}
		return -1;
	}

}
