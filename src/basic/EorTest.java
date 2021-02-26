package basic;

import java.util.ArrayList;
import java.util.List;

public class EorTest {
	public static void main(String[] args) {
		int a[] = { 1, 1, 1, 2, 2, 3, 4, 4, 5, 5 };
		selectEven(a);
	}

	public  static void selectEven(int a[]) {
		int eor = 0;
		for (int i = 0; i < a.length; i++) {
			eor ^= a[i];
		}
		List<Integer> list = new ArrayList<>();
		List<Integer> list1 = new ArrayList<>();
		//取出最右边的1
		eor = eor & (~eor + 1);
		for (int i = 0; i < a.length; i++) {
			if ((a[i] & eor) !=0) {
				list.add(a[i]);
			} else {
				list1.add(a[i]);
			}
		}
		eor = 0;
		for (int i = 0; i < list.size(); i++) {
			eor ^= list.get(i);
		}
		System.out.println(eor);
		eor = 0;
		for (int i = 0; i < list1.size(); i++) {
			eor ^= list1.get(i);
		}
		System.out.println(eor);
	}
}
