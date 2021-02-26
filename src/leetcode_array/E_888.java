package leetcode_array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 根糖果棒的大小，B[j] 是鲍勃拥有的第 j 根糖果棒的大小。
 * 
 * 因为他们是朋友，所以他们想交换一根糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
 * 
 * 返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。
 * 
 * 如果有多个答案，你可以返回其中任何一个。保证答案存在。
 * 
 * @author jackjoily
 *
 */
public class E_888 {
	public static void main(String[] args) {
		int a[] = { 1, 2, 5 };
		int b[] = { 2, 4 };
		System.out.println(Arrays.toString(fairCandySwap(a, b)));
	}

	public static int[] fairCandySwap(int[] A, int[] B) {
		int a[] = new int[2];
		int m = 0;
		int n = 0;
		int i = 0;
		Set<Integer> set = new HashSet<>();
		for (; i < A.length; i++) {
			m += A[i];
		}
		for (i = 0; i < B.length; i++) {
			n += B[i];
			set.add(B[i]);
		}
			for (i = 0; i < A.length; i++) {
				int j = A[i]-(m-n)/2;
				if(set.contains(j)) {
					a[0] = A[i];
					a[1] = j;
					return a;
				}
			}
		return B;
}
	}
