package leetcode_string;

/**
 * 
 * 实现 strStr() 函数。 给定一个 haystack 字符串和一个 needle 字符串， 在 haystack 字符串中找出 needle
 * 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author jackjoily
 *
 */
public class E_28 {
	public static void main(String[] args) {
		System.out.println(strStr1("hello", "llo"));
	}

	public static int strStr(String haystack, String needle) {
		if ("".equals(needle))
			return 0;
		if ("".equals(haystack))
			return -1;
		int i = 0, temp = 0, k = 0;
		k = needle.length();
		while (i < haystack.length()) {
			temp = i;
			if ((i + k) <= haystack.length() && haystack.subSequence(i, i + k).equals(needle)) {
				return i;
			}
			i++;
		}
		return -1;
	}

	public static int strStr1(String haystack, String needle) {
		if ("".equals(needle))
			return 0;
		if ("".equals(haystack))
			return -1;
		int i = 0, j = 0;
		while (i < haystack.length()) {
			j = 0;
			while (i < haystack.length() && j < needle.length() && needle.charAt(j) == haystack.charAt(i)) {
				i++;
				j++;
			}
			if (j == needle.length())
				return i - j;
			i = (i-j+1);
		}
		return -1;
	}

}
