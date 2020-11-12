package JianZhiOffer;

import java.util.LinkedList;

/**
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 * 
 * @author jackjoily
 *
 */
public class JianZhiOffer62 {
	public static void main(String[] args) {
		JianZhiOffer62 j = new JianZhiOffer62();
		System.out.println(j.lastRemaining(10, 17));
	}

	/**
	 * 这种方法会超时
	 * 
	 * @param n
	 * @param m
	 * @return
	 */
	public int lastRemaining(int n, int m) {
		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			list.add(i);
		}
		int j = 0;
		while (n > 1) {
			j = (m - 1 + j) % list.size();
			System.out.println(list.remove(j));
			n--;
		}
		return list.get(0);
	}
}
