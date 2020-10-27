package basic;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 
 * @author jackjoily
 *
 */
public class FullPermutation {
	static LinkedList<Integer> track = new LinkedList<Integer>();

	public static void main(String[] args) {
		int a[] = new int[10];
		for (int i = 0; i < a.length; i++) {
			a[i] = i + 1;
		}
		f(a,track);
	}

	public static void f(int a[], LinkedList<Integer> track) {
		if (a.length == track.size()) {
			System.out.println(track);
		}
		for (int i = 0; i < a.length; i++) {
			if (track.contains(a[i]))
				continue;
			track.add(a[i]);
			f(a, track);
			track.removeLast();
		}

	}

}
