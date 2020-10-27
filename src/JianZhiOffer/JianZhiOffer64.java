package JianZhiOffer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句 （A?B:C）。
 */
public class JianZhiOffer64 {
	public static void main(String[] args) {
		JianZhiOffer64 j = new JianZhiOffer64();
		System.out.println();
	}

	public int sumNums(int n) {
		// 使用逻辑短路可以进行判断
		boolean x = n > 1 && (n += sumNums(n - 1)) > 0;
		return n;
	}
}
