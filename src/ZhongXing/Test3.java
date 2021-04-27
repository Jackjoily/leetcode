package ZhongXing;

import java.util.*;

public class Test3 {

	public static void main(String[] args) {
		Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
		for (int k = 1; k <= 5; k++) {
			map.put(k, new PriorityQueue<Integer>(new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return o2 - o1;
				}
			}));
		}
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count = 0;
		for (int i = 0; i < n; i++) {
			int j = sc.nextInt();
			if (map.get(j).size() == 0) {
				count++;
			}
			map.get(j).add(i + 1);
			if (map.size() == 5 && count == 5) {
				for (int k = 1; k <= 5; k++) {
					Integer poll = map.get(k).poll();
					if (map.get(k).size() == 0) {
						count--;
					}
					System.out.print(poll + " ");
				}
				System.out.println();
			} else {
				System.out.println(-1);
			}
		}

	}
}
