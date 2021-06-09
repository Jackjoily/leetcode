package newcoder;

import java.util.HashMap;
import java.util.Map;

public class NC61 {
	public int[] twoSum(int[] numbers, int target) {
		int a[] = new int[2];
		Map<Integer, Integer> set = new HashMap<>();
		for (int i = 0; i < numbers.length; i++) {
			if (set.size() == 0) {
				set.put(numbers[i], i);
			} else {
				int key = target - numbers[i];
				if (set.containsKey(key)) {
					a[0] = set.get(key)+1;
					a[1] = i+1;
					return a;
				}
				set.put(numbers[i], i);
			}
		}
		return a;
	}
}
