package leetcode_string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * 给你一份旅游线路图，该线路图中的旅行线路用数组 paths 表示，其中 paths[i] = [cityAi, cityBi] 表示该线路将会从
 * cityAi 直接前往 cityBi 。请你找出这次旅行的终点站，即没有任何可以通往其他城市的线路的城市。
 * 
 * 题目数据保证线路图会形成一条不存在循环的线路，因此只会有一个旅行终点站。
 * 
 * 
 * 
 * @author jackjoily
 *
 */
public class E_1436 {
	public static void main(String[] args) {
		List<List<String>> paths = new ArrayList();
		List<String> list1 = new ArrayList<>();
		list1.add("B");
		list1.add("C");
		// List<String> list2 = new ArrayList<>();
		// list2.add("D");
		// list2.add("B");
		// List<String> list3 = new ArrayList<>();
		// list3.add("C");
		// list3.add("A");
		paths.add(list1);
		// paths.add(list2);
		// paths.add(list3);
		System.out.println(destCity(paths));
	}

	public static String destCity(List<List<String>> paths) {
		if (paths.size() == 1)
			return paths.get(0).get(1);
		for (int i = 0; i < paths.size(); i++) {
			boolean flag1 = false, flag2 = true;
			for (int j = 0; j < paths.size(); j++) {
				if (i != j) {
					if (paths.get(j).get(0).equals(paths.get(i).get(1))) {
						flag2 = false;
					}
					if (paths.get(j).get(1).equals(paths.get(i).get(0))) {
						flag1 = true;
					}
				}
			}
			if (flag1 && flag2) {
				return paths.get(i).get(1);
			}
		}
		return null;
	}
}
