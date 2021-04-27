package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

/**
 * twosum
 * 
 * @author jackjoily
 *
 */
public class H_76 {
	public static void main(String[] args) {
		System.out.println(minWindow1("ADOBECODEBANC", "ABC"));
	}
	public static String minWindow(String s, String t) {
		int m = s.length();
		int n = t.length();
		char[] c = s.toCharArray();
		char[] c1 = t.toCharArray();
		int left = 0, right = 0;
		int res=Integer.MAX_VALUE;
		int count=0;
		int left1=0;
		int right1=0;
		Map<Character, Integer> s1 = new HashMap<>();
		Map<Character, Integer> t1 = new HashMap<>();
		for (int i = 0; i < n; i++) {
			t1.put(c1[i], t1.getOrDefault(c1[i], 0) + 1);
		}
		int res1=t1.size();
		while (right < m) {
			if (t1.containsKey(c[right])) {
				s1.put(c[right], s1.getOrDefault(c[right], 0) + 1);
				if(s1.get(c[right])==t1.get(c[right])) {
					count++;
				}
				while(count==res1) {
					int i = right-left+1;
					if(res>=i) {
						res=i;
						left1=left;
						right1=right+1;
					}
					if(s1.containsKey(c[left])) {
						Integer integer = s1.get(c[left]);
						if(integer>1) {
							s1.put(c[left], integer-1);
							if(s1.get(c[left])<t1.get(c[left])) {
								left++;
								count--;
								break;
							}
						}else if(integer==1) {
							s1.remove(c[left]);
							left++;
							count--;
							break;
						}
					}
					left++;
				}
			} 
			right++;
		}
		return s.substring(left1,right1);
	}

	public static boolean isContain(char c[], Map<Character, Integer> s1, Map<Character, Integer> t1) {
		if (s1.size() != t1.size())
			return false;
		else {
			for (int i = 0; i < c.length; i++) {
				if (s1.get(c[i]) < t1.get(c[i]))
					return false;
			}
		}
		return true;
	}
	

	public static  String minWindow1(String s, String t) {
    	 if (s == null || s.length() == 0 || t == null || t.length() == 0){
            return "";
        }
        int[] need = new int[128];
        //记录需要的字符的个数
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }
        //l是当前左边界，r是当前右边界，size记录窗口大小，count是需求的字符个数，start是最小覆盖串开始的index
        int l = 0, r = 0, size = Integer.MAX_VALUE, count = t.length(), start = 0;
        //遍历所有字符
        while (r < s.length()) {
            char c = s.charAt(r);
            if (need[c] > 0) {//需要字符c
                count--;
            }
            need[c]--;//把右边的字符加入窗口
            if (count == 0) {//窗口中已经包含所有字符
                while (l < r && need[s.charAt(l)] < 0) {
                    need[s.charAt(l)]++;//释放右边移动出窗口的字符
                    l++;//指针右移
                }
                if (r - l + 1 < size) {//不能右移时候挑战最小窗口大小，更新最小窗口开始的start
                    size = r - l + 1;
                    start = l;//记录下最小值时候的开始位置，最后返回覆盖串时候会用到
                }
                //l向右移动后窗口肯定不能满足了 重新开始循环
                need[s.charAt(l)]++;
                l++;
                count++;
            }
            r++;
        }
        return size == Integer.MAX_VALUE ? "" : s.substring(start, start + size);
    }
}
