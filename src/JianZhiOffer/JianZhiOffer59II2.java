package JianZhiOffer;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值， 要求函数max_value、push_back 和 pop_front
 * 的均摊时间复杂度都是O(1)
 *
 */
public class JianZhiOffer59II2 {
	public static void main(String[] args) {
		MaxQueue ma = new MaxQueue();
		ma.push_back(1);
		ma.push_back(2);
		ma.push_back(3);
		ma.push_back(4);
		System.out.println(ma.pop_front());
	}
}

class MaxQueue {
	int[] q = new int[20000];
	int begin = 0, end = 0;

	public MaxQueue() {

	}

	public int max_value() {
		int ans = -1;
		for (int i = begin; i != end; ++i) {
			ans = Math.max(ans, q[i]);
		}
		return ans;
	}

	public void push_back(int value) {
		q[end++] = value;
	}

	public int pop_front() {
		if (begin == end) {
			return -1;
		}
		return q[begin++];
	}
}
