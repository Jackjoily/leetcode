package leetcode_string;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/decode-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author jackjoily
 *
 */
public class M_394 {
	public static void main(String[] args) {
		System.out.println(decodeString("abc3[cd]xyz"));
	}

	public static String decodeString(String s) {
		int i = 0, j = s.length();
		Stack<String> stack = new Stack<>();
		Stack<Integer> stack1 = new Stack<>();
		StringBuilder sb = new StringBuilder();
		int val = 0;
		while (i < j) {
			char c = s.charAt(i);
			if (c == '[') {
				if (val != 0) {
					stack1.add(val);
					val = 0;
				}
				stack.add("[");
			} else if (c == ']') {
				StringBuilder sb2 = new StringBuilder();
				StringBuilder sb1 = new StringBuilder();
				int a = stack1.pop();
				while (!stack.peek().equals("[")) {
					sb1.append(stack.pop());
				}
				stack.pop();
				String string = sb1.reverse().toString();
				for (int l = 0; l < a; l++) {
					sb2.append(string);
				}
				if (stack1.size() > 0) {
					stack.add(sb2.reverse().toString());
				} else {
					sb.append(sb2.toString());
				}

			} else if (c >= '0' && c <= '9') {
				int k = c - '0';
				if (val == 0) {
					val = k;
				} else {
					val = val * 10 + k;
				}
			} else {
				if (stack.isEmpty()) {
					sb.append(c);
				} else {
					stack.push(c+"");
				}
			}
			i++;
		}
		return sb.toString();
	}

}
