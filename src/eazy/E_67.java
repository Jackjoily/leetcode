package eazy;

import com.sun.xml.internal.ws.util.StringUtils;

/**
 * @ClassName E_67
 * @Description 
 *  给你两个二进制字符串，返回它们的和（用二进制表示）。
        输入为 非空 字符串且只包含数字 1 和 0。
 * @Author Jackjoily
 * @Date 2020年6月23日 下午7:18:02
 */
public class E_67 {
	public static void main(String[] args) {
		System.out.println(addBinary("11", "1"));
	}

	public static String addBinary(String a, String b) {
		int res = 0, cin = 0;
		int i = a.length() - 1;
		int j = b.length() - 1;
		StringBuilder sb = new StringBuilder();
		if (i > j) {
			for (; j > -1; j--, i--) {
				res = ((a.charAt(i) - '0') + (b.charAt(j) - '0') + cin) % 2;
				cin = ((a.charAt(i) - '0') + (b.charAt(j) - '0') + cin)  / 2;
				sb.append(res);
			}
			if (cin == 1) {
				for (; i > -1; i--) {
					res = (a.charAt(i) - '0' + cin) % 2;
					cin = (a.charAt(i) - '0' + cin) / 2;
					sb.append(res);
				}
				if (cin == 1) {
					sb.append(1);
				}
			} else {
				for (int k = a.length() - b.length() - 1; k > -1; k--) {
					sb.append(a.charAt(k));
				}
			}

		} else if (i == j) {
			for (; j > -1; j--) {
				res = ((a.charAt(j) - '0') + (b.charAt(j) - '0') + cin) % 2;
				cin = ((a.charAt(j) - '0') + (b.charAt(j) - '0') + cin) / 2;
				sb.append(res);
			}
			if (cin == 1) {
				sb.append(1);
			}
		} else {
			for (; i > -1; i--, j--) {
				res = ((b.charAt(j) - '0') + (a.charAt(i) - '0') + cin) % 2;
				cin = ((b.charAt(j) - '0') + (a.charAt(i) - '0') + cin) / 2;
				sb.append(res);
			}
			if (cin == 1) {
				for (; j > -1; j--) {
					res = ((b.charAt(j)-'0') + cin) % 2;
					cin = ((b.charAt(j)-'0') + cin) / 2;
					sb.append(res);
				}
				if (cin == 1) {
					sb.append(1);
				}
			} else {
				for (int k = b.length() - a.length() - 1; k > -1; k--) {
					sb.append(b.charAt(k));
				}
			}

		}

		return sb.reverse().toString();
	}
}
