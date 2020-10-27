package basic;

import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 波兰表达式计算器
 * 
 * @author jackjoily
 *
 */

public class PolandNotation {

	public static void main(String[] args) {
		// 先定义一个逆波兰表达式
		String suffixExperssion = "1 2 3 + 4 * + 5 -";
		System.out.println(calculate(getListString(suffixExperssion)));
	}

	// 将一个逆波兰表达式，依次将数据和运算符放入到ArrayList中
	public static List<String> getListString(String suffixExperssion) {
		String[] spilt = suffixExperssion.split(" ");
		List<String> list = Arrays.asList(spilt);
		return list;
	}
/**
 * 后缀表达式进行计算
 * @param ls
 * @return
 */
	public static int calculate(List<String> ls) {
		// 创建一个栈
		Stack<String> stack = new Stack<String>();
		for (String string : ls) {
			// 匹配多位数
			if (string.matches("\\d+")) {
				stack.push(string);
			} else {
				// pop出两个数
				int res = 0;
				int num2 = Integer.valueOf(stack.pop());
				int num1 = Integer.valueOf(stack.pop());
				if (string.equals("+"))
					res = num2 + num1;
				else if (string.equals("-"))
					res = num1 - num2;
				else if (string.equals("*"))
					res = num1 * num2;
				else if(string.equals("/"))
					res = num1 / num2;
				else throw new RuntimeException("运算符有问题");
				stack.push(res+"");
			}
		}
		return Integer.parseInt(stack.pop());
	}

}
