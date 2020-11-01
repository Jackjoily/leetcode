package JianZhiOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 找出数组中重复的数字。
 * 
 * 
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。 斐波那契数列的定义如下：数字。
 * 
 * 
 * @author jackjoily
 *
 */
public class JianZhiOffer10_I {
	public static void main(String[] args) {
     System.out.println(fib(45));
	}
/**
 * 小技巧
 * (a∗b)%c=((a%c)∗(b%c))%c
 * 
 * 求余运算规则： 设正整数 x, y, px,y,p ，求余符号为 % ，则有
 *  (x + y) %p = (x% p + y % p)%p。

 * @param n
 * @return
 */
	public static int fib(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		int a = 0, b = 1, c = 0;
		for (int i = 2; i <= n; i++) {
			c = (a + b)%1000000007;
			a = b;
			b = c;
		}
		return c;
	}
}
