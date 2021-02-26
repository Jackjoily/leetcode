package leetcode_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个整数 n, 返回从 1 到 n 的字典顺序。
 * 
 * 例如，
 * 
 * 给定 n =13，返回 [1,10,11,12,13,2,3,4,5,6,7,8,9] 。 请尽可能的优化算法的时间复杂度和空间复杂度。
 * 输入的数据 n 小于等于 5,000,000。
 * 
 * @author jackjoily
 *
 */
public class M_386 {
	public List<Integer> lexicalOrder(int n) {
		 List<Integer> list = new ArrayList<>();
		    int num = 1;
		    list.add(1);
		    for(int i = 1;i<n;i++) {
		    	if(num*10 <=n)  {
		    		num*=10;
		    		list.add(num);
		    	}
		    	else {
		    		while(num%10 ==9 || num ==n) {
		    			num/=10;
		    		}
		    		num++;
		    		list.add(num);
		    	}
		    }
		    return list;
	}
}