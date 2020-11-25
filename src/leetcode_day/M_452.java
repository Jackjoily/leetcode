package leetcode_day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import leetcode_list.ListNode;

public class M_452 {
	public static void main(String[] args) {
		M_452 m = new M_452();
		int a[][] = { { 3, 9 }, { 7, 12 }, { 3, 8 }, { 6, 8 }, { 9, 10 }, { 2, 9 }, { 0, 9 }, { 3, 9 }, { 0, 6 },
				{ 2, 8 } };
		System.out.println(findMinArrowShots(a));
	}

	public static int findMinArrowShots(int[][] points) {
		if (points.length == 0)
			return 0;
		if (points.length == 1)
			return 1;
		for (int i = 0; i < points.length + 1; i++) {
			for (int j = i + 1; j < points.length; j++) {
				if (points[i][1] > points[j][1]) {
					int a[] = points[i];
					points[i] = points[j];
					points[j] = a;
				}
			}
		}
		int i = 0, j = 0;
		int temp =0;
		while (i < points.length) {
              int right=points[i][1];
              i++;
              while(i<points.length&&right>=points[i][0]) {
            	  i++;
              }
              temp++;
	 	}
		return temp;
	}

}
