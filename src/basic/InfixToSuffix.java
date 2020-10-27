package basic;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 将中缀表达达式转换为后缀表达式
 * 
 * @author jackjoily
 *
 */
public class InfixToSuffix {

	public static void main(String[] args) {
		String infixExpression = "( 1 + 2 ) * 3 - ( 1 + 2 ) / 4";
		String suffixExpression=InfixToSuffix(getStringList(infixExpression));
		System.out.println(suffixExpression);
	}

	public static List<String> getStringList(String str) {
		String strs[] = str.split(" ");
		List<String> list = Arrays.asList(strs);
		return list;
	}

	public static String InfixToSuffix(List<String> list) {
		Stack<String> resultStack = new Stack<>();
		Stack<String> operStack = new Stack<>();
		for (String item : list) {
			// 匹配数字
			if (item.matches("\\d+")) {
				resultStack.push(item);
			} else {
				// 如果这是一个运算符的话
				if (isOperator(item)) {
					// 和操作符栈顶的操作符进行对比
					boolean flag = true;
					while (flag) {
						if (!operStack.isEmpty()) {
							if (priority(item) > priority(operStack.peek())) {
								operStack.push(item);
								flag = false;
							} else {
								resultStack.push(operStack.pop());
							}
						} else {
							operStack.push(item);
							flag = false;
						}
					}

				} else {
					// 扫描到左括号的情况
					if ("(".equals(item)) {
						operStack.push(item);
					} else {
						// 扫描到右括号情况
						while (!"(".equals(operStack.peek())) {
							resultStack.push(operStack.pop());
						}
						operStack.pop();
					}

				}
			}
		}
		while(!operStack.isEmpty()) {
			resultStack.push(operStack.pop());
		}
		StringBuilder sb = new StringBuilder("");
		while (!resultStack.isEmpty()) {
			sb.append(resultStack.pop() + " ");
		}
		return sb.reverse().toString();
	}

	public static boolean isOperator(String str) {
		char c = str.charAt(0);
		return c == '+' || c == '-' || c == '*' || c == '/';
	}

	public static int priority(String oper) {
		if (oper.equals("*") || oper.equals("/")) {
			return 1;
		} else if (oper.equals("+") || oper.equals("-")) {
			return 0;
		} else {
			return -1;
		}
	}
}
