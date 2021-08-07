package Vivo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 一个完整的软件项目往往会包含很多由代码和文档组成的源文件。 编译器在编译整个项目的时候，可能需要按照依赖关系来依次编译每个源文件。 比如，A.cpp 依赖
 * B.cpp，那么在编译的时候，编译器需要先编译 B.cpp，才能再编译 A.cpp。 假设现有 0，1，2，3
 * 四个文件，0号文件依赖1号文件，1号文件依赖2号文件，3号文件依赖1号文件， 则源文件的编译顺序为 2,1,0,3 或
 * 2,1,3,0。现给出文件依赖关系，如 1,2,-1,1， 表示0号文件依赖1号文件，1号文件依赖2号文件，2号文件没有依赖，3号文件依赖1号文件。
 * 请补充完整程序，返回正确的编译顺序。 注意如有同时可以编译多个文件的情况，按数字升序返回一种情况即可，比如前述案例输出为：2,1,0,3
 * 
 * @author jackjoily
 *
 */
public class Test1 {

	public static void main(String[] args) {
		System.out.println(compileSeq("1,2,-1,1"));
	}

	public static String compileSeq(String input) {
		String[] split = input.split(",");
		int n = split.length;
		int indeges[] = new int[n];
		List<List<Integer>> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(new ArrayList<Integer>());
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < split.length; i++) {
			Integer valueOf = Integer.valueOf(split[i]);
			if (valueOf == -1) {
				pq.add(i);
			} else {
				list.get(valueOf).add(i);
				indeges[i]++;
			}
		}
		StringBuilder sb = new StringBuilder();
		while (!pq.isEmpty()) {
			int poll = pq.poll();
			sb.append(poll + ",");
			for (int num : list.get(poll)) {
				if (--indeges[num] == 0) {
					pq.add(num);
				}
			}
		}
		return sb.deleteCharAt(sb.length() - 1).toString();
	}
}
