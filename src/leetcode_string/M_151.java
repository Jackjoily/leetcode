package leetcode_string;

public class M_151 {

	public static void main(String[] args) {
		System.out.println(reverseWords(""));
	}

	/**
	 * 无空格字符构成一个 单词 。 输入字符串可以在前面或者后面包含多余的空格， 但是反转后的字符不能包括。
	 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
	 * 
	 * @param s
	 * @return
	 */
	public static String reverseWords(String s) {
		if (s.length() == 1)
			return s;
		String[] split = s.split("\\s+");
		if (split.length == 0||split.length==1)
			return s;
		StringBuilder sb = new StringBuilder("");
		for (int i = split.length - 1; i >= 0; i--) {
			if (split[i].equals("") || split[i].equals(" ")) {

			} else {
				sb.append(split[i].trim() + " ");
			}
		}
		String string = sb.toString();
		return string.substring(0, string.length() - 1);
	}
}
