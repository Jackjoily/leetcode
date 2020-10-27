package dac;

/**
 * 
 * @author jackjoily
 *
 */
public class Hanoitower {

	public static void main(String[] args) {
		haniTower(64, 'A', 'B', 'C');
	}

	// 使用分治算法
	/**
	 * 
	 * @param num
	 * @param a
	 * @param b
	 * @param c
	 */
	public static void haniTower(int num, char a, char b, char c) {
		if (num == 1) {
			System.out.println("第1个盘从 " + a + " ----> " + c);
		} else {
			// 最下面盘之上的所有盘从a移动到b
			haniTower(num - 1, a, c, b);
			// 把最后一个盘从a移动到c
			System.out.println("第" + num + "个盘从" + a + " ----> " + c);
			//最下面盘之上的所有盘从b移动到c
			haniTower(num - 1, b, a, c);
		}
	}

}
