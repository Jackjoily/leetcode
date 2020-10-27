package leetcode_day;

/*
 *你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，
 *而字符可能被输入 1 次或多次。

你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），
那么就返回 True。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/long-pressed-name
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 
 */
public class E_925 {
	public static void main(String[] args) {
		E_925 e = new E_925();
		System.out.println(e.isLongPressedName("laiden", "laiden"));

	}
	public boolean isLongPressedName(String name, String typed) {
		if (name == null || typed == null || name.equals(" ") || typed.equals(" ") || name.length() == 0
				|| typed.length() == 0)
			return false;
		int i = 0, j = 0;
		for (; i < name.length() - 1; i++) {
			boolean flag = false;
			char c = name.charAt(i);
			char b = name.charAt(i + 1);
			if (b == c)
				flag = true;
			if (j < typed.length() && typed.charAt(j) != c) {
				return false;
			}
			while (j < typed.length() && typed.charAt(j) == c) {
				if (!flag) {
					j++;
				} else {
					if (typed.charAt(j + 1) == c) {
						j = j + 1;
						break;
					} else {
						return false;
					}
				}
			}
		}
		if (j == typed.length()) {
			return false;
		}else {
			char c = name.charAt(i);
			while (j < typed.length() ) {
				if(typed.charAt(j) == c)j++;
				else return false;
			}
		}
		return true;
	}
}
