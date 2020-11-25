package leetcode_string;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串 s， 返回其最后一个单词的长度。如果字符串从左向右滚动显示， 那么最后一个单词就是最后出现的单词。
 * 如果不存在最后一个单词，请返回 0 。
 * 
 * @author jackjoily
 *
 */
public class E_58 {
	public static void main(String[] args) {
		System.out.println(lengthOfLastWord1("        a   "));
	}

	public static int lengthOfLastWord(String s) {
		if (s.equals("") || s.equals(" "))
			return 0;
		String[] split = s.split("\\s+");
		Arrays.sort(split, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o2.length() - o1.length();
			}
		});
		return split[0].trim().length();
	}

	public static int lengthOfLastWord1(String s) {
		boolean flag1=false;
		if (s.equals("") || s.equals(" "))
			return 0;
		char[] charArray = s.toCharArray();
		int flag = 0;
		int i = charArray.length - 1;
		while (i >= 0) {
			flag = 0;
			while (i >= 0 && charArray[i] != ' ') {
				flag++;
				i--;
				flag1=true;
			}
			if ((i+1)<charArray.length&& charArray[i+1]!=' '&&flag1) {
				return flag;
			}
			i--;
		}

		return 0;
	}
}
