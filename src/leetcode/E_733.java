package leetcode;

import java.util.Arrays;
import java.util.HashMap;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

/**
 * twosum
 * 
 * @author jackjoily
 *
 */
public class E_733 {
	int direction[][] = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 }, };
	boolean visted[][];

	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		int m = image.length;
        if(m==0)return image;
		int n = image[0].length;
		   if(n==0)return image;
		int c=image[sr][sc];
		visted = new boolean[m][n];
		f(image,sr,sc,c,newColor,m,n);
		return image;
	}

	public void f(int a[][], int x, int y, int b, int c,int m,int n) {
		visted[x][y] = true;
		a[x][y]=c;
		for (int i = 0; i < 4; i++) {
			int newx=x+direction[i][0];
			int newy=y+direction[i][1];
			if (newx>=0&&newx<m&&newy>=0&&newy<n&&!visted[newx][newy]&&a[newx][newy]==b) {
                  f(a,newx,newy,b,c,m,n);
			}
		}
	}
}
