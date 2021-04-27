package KuaiShou;

import java.util.*;

public class Test1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] str = null;
		int n = 0;
		n = sc.nextInt();
		sc.nextLine();
		str = sc.nextLine().split("\\s+");
		int a[] = new int[n];
		for (int i = 0; i < str.length; i++) {
				a[i] = Integer.valueOf(str[i]);
		}
		int res = 0;
		Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
		int i = 0, j = 0;
		for (i = 0; i < n; i++) {
			map.put(i, new HashMap<>());
			int cur = 0;
			for (j = i - 1; j >= 0; j--) {
				int key = a[i] - a[j];
				if (map.get(i).containsKey(key))
					continue;
				cur = map.get(j).getOrDefault(key, 0);
				if (cur == 0) {
					res = Math.max(res, 2);
					map.get(i).put(key, cur + 2);
				} else {
					res = Math.max(res, cur + 1);
					map.get(i).put(key, cur + 1);
				}
			}
		}
		System.out.println(res);
	}
}
