package Vivo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author jackjoily
 *
 */
public class Test2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int i = 0;
		int j = str.length() - 1;
		if (isOkay(str)) {
			System.out.println(str);
			return;
		}
		while (i < j) {
			if (str.charAt(i) == str.charAt(j)) {
				i++;
				j--;
			} else {
				StringBuilder sb = new StringBuilder();
				String string = sb.append(str).deleteCharAt(i).toString();
				String string2 = sb.append(str).deleteCharAt(j).toString();
				if (isOkay(string)) {
					System.out.println(string);
					break;
				} else if (isOkay(string2)) {
					System.out.println(string2);
					break;
				} else {
					System.out.println("false");
					break;
				}
			}
		}
	}

	public static boolean isOkay(String str) {
		int low = 0;
		int high = str.length() - 1;
		while (low < high) {
			if (str.charAt(low) != str.charAt(high)) {
				return false;
			}
			low++;
			high--;
		}
		return true;
	}

}
