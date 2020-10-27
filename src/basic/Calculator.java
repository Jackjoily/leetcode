package basic;
/**
 *         中缀表达式，加减乘除运算
 * @author jackjoily
 *
 */
public class Calculator {

	public static void main(String[] args) {
		String exp = "10*2*4+2-5*6*4";
		String keepNum="";
		int tail = -1, tail1 = -1;
		int[] numstack = new int[10];
		int[] operstack = new int[10];
		for (int i = 0; i < exp.length(); i++) {
			keepNum="";
			if ('0' <= exp.charAt(i) && exp.charAt(i) <= '9') {
				keepNum+=exp.charAt(i);
                while((i+1)<exp.length()&&'0' <= exp.charAt(i+1) && exp.charAt(i+1) <= '9') {
                	keepNum+=exp.charAt(i+1);
                	i++;
                }
                numstack[++tail]=Integer.valueOf(keepNum);
			} else {
				if (tail1 != -1) {
					if (priority(operstack[tail1]) < priority(exp.charAt(i))) {
						operstack[++tail1] = exp.charAt(i);
					} else {
						int res = cal(numstack[tail--], numstack[tail--], operstack[tail1--]);
						numstack[++tail] = res;
						boolean flag = true;
						while (flag) {
							if (tail1 == -1) {
								flag = false;
								operstack[++tail1] = exp.charAt(i);
							} else {
								if (priority(operstack[tail1]) < priority(exp.charAt(i))) {
									operstack[++tail1] = exp.charAt(i);
									flag = false;
								} else {
									res = cal(numstack[tail--], numstack[tail--], operstack[tail1--]);
									numstack[++tail] = res;
								}
							}
						}
					}
				} else {
					operstack[++tail1] = exp.charAt(i);
				}
			}
		}
		while (tail1 != -1) {
			int res = cal(numstack[tail--], numstack[tail--], operstack[tail1--]);
			numstack[++tail] = res;
		}
		System.out.println(numstack[tail]);
	}

	// 返回运算符的优先级
	public static int priority(int oper) {
		if (oper == '*' || oper == '/') {
			return 1;
		} else if (oper == '+' || oper == '-') {
			return 0;
		} else {
			return -1;
		}
	}

	public static boolean isOper(char val) {
		return val == '+' || val == '-' || val == '*' || val == '/';
	}

	/**
	 * 
	 * @param num1先出栈的数
	 * @param num2后出栈的数
	 * @param oper
	 * @return
	 */
	public static int cal(int num1, int num2, int oper) {
		int res = 0;
		switch (oper) {
		case '+':
			res = num1 + num2;
			break;
		case '-':
			res = num2 - num1;
			break;
		case '*':
			res = num1 * num2;
			break;
		case '/':
			res = num2 / num1;
			break;
		default:
			break;
		}
		return res;
	}

}
