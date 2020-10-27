package Violence;

/**
 * 暴力匹配方法
 * 
 * @author jackjoily
 *
 */
public class ViolenceMatch {

	public static void main(String[] args) {
		System.out.println(violenceMathc("abcdefhijklmnopqrstabcdefsferiea", "mnopqrst`"));
	}

	/**
	 * 暴力匹配算法
	 * 
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static int violenceMathc(String str1, String str2) {
		char[] s1 = str1.toCharArray();
		char[] s2 = str2.toCharArray();
		int a = s1.length;
		int b = s2.length;
		int i = 0;
		int j = 0;
		while (i < a && j < b) {
			if (s1[i] == s2[j]) {
				i++;
				j++;
			} else {
				i = i - (j - 1);
				j = 0;
			}
		}
		if (j == b) {
			return i - j;
		} else {
			return -1;
		}

	}
}
