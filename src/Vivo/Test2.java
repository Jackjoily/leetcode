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
 * 一个完整的软件项目往往会包含很多由代码和文档组成的源文件。 编译器在编译整个项目的时候，可能需要按照依赖关系来依次编译每个源文件。 比如，A.cpp 依赖
 * B.cpp，那么在编译的时候，编译器需要先编译 B.cpp，才能再编译 A.cpp。 假设现有 0，1，2，3
 * 四个文件，0号文件依赖1号文件，1号文件依赖2号文件，3号文件依赖1号文件， 则源文件的编译顺序为 2,1,0,3 或
 * 2,1,3,0。现给出文件依赖关系，如 1,2,-1,1， 表示0号文件依赖1号文件，1号文件依赖2号文件，2号文件没有依赖，3号文件依赖1号文件。
 * 请补充完整程序，返回正确的编译顺序。 注意如有同时可以编译多个文件的情况，按数字升序返回一种情况即可，比如前述案例输出为：2,1,0,3
 * 
 * @author jackjoily
 *
 */
public class Test2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		char[] c = str.toCharArray();
		if (str.length() == 1) {
			System.out.println(str);
			return;
		}
		if (isOkay(str)) {
			System.out.println(str);
			return;
		}
		int i = 0;
		StringBuilder s = new StringBuilder(str);
		StringBuilder s1 = new StringBuilder();
		int j = str.length() - 1;
		while (i < j) {
			if (str.charAt(i) != str.charAt(j)) {
				String str1 = s.substring(i, j);
				String str2 = s.substring(i + 1, j + 1);
				if (isOkay(str1)) {
					for (int k = 0; k < str.length(); k++) {
						if (k != j) {
							s1.append(str.charAt(k));
						}
					}
					System.out.println(s1.toString());
					return;
				} else if (isOkay(str2)) {
					for (int k = 0; k < str.length(); k++) {
						if (k != j + 1) {
							s1.append(str.charAt(k));
						}
					}
					System.out.println(s1.toString());
					return;
				} else {
					System.out.println("false");
					return;
				}
			} else {
				i++;
				j--;
			}
		}
		System.out.println("false");
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
