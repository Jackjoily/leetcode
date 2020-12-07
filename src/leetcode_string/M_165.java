package leetcode_string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class M_165 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString("1.0.1".split("\\.")));
		System.out.println(compareVersion("1.0.1", "1"));
	}

	public static int compareVersion(String version1, String version2) {
		String[] split = version1.split("\\.");
		String[] split1 = version2.split("\\.");
		int i = 0, k = 0;
		while (i < split.length && k < split1.length) {
			if (Integer.valueOf(split[i]) > Integer.valueOf(split1[k])) {
				return 1;
			} else if (Integer.valueOf(split[i]) == Integer.valueOf(split1[k])) {
				i++;
				k++;
			} else {
				return -1;
			}
		}
		if (split.length == split1.length)
			return 0;
		else if (split.length < split1.length) {
			while (k < split1.length) {
				if (Integer.valueOf(split1[k]) != 0)
					return -1;
				k++;
			}
		} else {
			while (i < split.length) {
				if (Integer.valueOf(split[i]) != 0)
					return 1;
				i++;
			}
		}
		return 0;
	}
}
