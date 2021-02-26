package leetcode_array;

import java.util.HashMap;
import java.util.Map;

/**
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 * 
 * 给出两个整数 x 和 y，计算它们之间的汉明距离
 * 
 * @author jackjoily
 *
 */
public class E_461 {
	public int hammingDistance(int x, int y) {
		   int m = x ^ y;     
	        int num = 0;  
	        while(m>0)  
	        {  
	            m &= (m-1);  //逐位相与统计个数
	            num++;  
	        }  
	        return num;
	}
}
