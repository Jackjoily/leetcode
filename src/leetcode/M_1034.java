package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import javafx.scene.shape.Line;
import leetcode_list.ListNode;
import leetcode_tree.TreeNode;

/**
 * 
 * @author jackjoily
 *
 */
public class M_1034 {
	boolean visited[][];
    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
    	int m=grid.length;
    	if(m==0)return grid;
    	int n=grid[0].length;
    	if(n==0)return grid;
    	int oriColor=grid[r0][c0];
    	visited=new boolean[m][n];
    	f(grid,r0,c0,oriColor,color,m,n);
		return grid;
    }
    public int f(int [][]a,int x,int y,int oriColor,int color,int m,int n) {
    	if(!inArea(m, n, x, y))return 0;
    	if(visited[x][y])return 1;
    	if(a[x][y]!=oriColor)return 0;
    	visited[x][y]=true;
    	int sum=f(a,x-1,y,oriColor,color,m,n)+
    			f(a,x,y-1,oriColor,color,m,n)+
    			f(a,x+1,y,oriColor,color,m,n)+
    			f(a,x,y+1,oriColor,color,m,n);
    	if(sum<4) {
    	   a[x][y]=color;
    	}
		return 1;
    }
    public boolean inArea(int m,int n,int x,int y) {
    	if(x<0||y<0||x>=m||y>=n)return false;
    	return true;
    }
}
