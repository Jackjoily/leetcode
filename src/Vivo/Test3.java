package Vivo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * 
 * @author jackjoily
 *
 */
public class Test3 {
	static int len;
	static int directions[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		len = sc.nextInt();
		int startx = sc.nextInt();
		int starty = sc.nextInt();
		int endx = sc.nextInt();
		int endy = sc.nextInt();
		sc.nextLine();
		int dp[][] = new int[len][len];
		char[][] c = new char[len][len];
		for (int i = 0; i < len; i++) {
			String str = sc.nextLine();
			for (int j = 0; j < len; j++) {
				c[i][j] = str.charAt(j);
				if (c[i][j] == '#' || c[i][j] == '@') {
					dp[i][j] = -1;
				} else {
					dp[i][j] = Integer.MAX_VALUE;
				}
			}
		}

		if (dp[endy][endx] == -1)
			System.out.println(dp[endy][endx]);
		f(dp, starty, startx, 0);

		if (dp[endy][endx] ==Integer.MAX_VALUE)
			System.out.println(-1);else {
				System.out.println(dp[endy][endx]);
			}
	
	}

	public static void f(int dp[][], int i, int j, int dis) {
		if (dis >= dp[i][j])
			return;
		dp[i][j] = dis;
		for (int k = 0; k < 4; k++) {
			int newx = i + directions[k][0];
			int newy = j + directions[k][1];
			if (newx < 0 || newx >= len || newy < 0 || newy >= len || dp[i][j] == -1)
				continue;
			else {
				f(dp, newx, newy, dis + 1);
			}
		}
	}
}
