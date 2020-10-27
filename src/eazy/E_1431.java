package eazy;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName E_1431
 * @Description
 * @Author Jackjoily
 * @Date 2020年6月26日 下午4:52:50
 */
public class E_1431 {
	public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
		List<Boolean> list = new ArrayList<>();
		int max = candies[0];
		for (int i = 1; i < candies.length; i++) {
			if (max < candies[i])
				max = candies[i];
		}
		for (int i = 0; i < candies.length; i++) {
			if (candies[i] + extraCandies >= max) {
				list.add(true);
			} else {
				list.add(false);
			}
		}
		return list;
	}
}
