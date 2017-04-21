package question28;

/**
 * 给定一个字符串，输出其所有字符的排列可能
 * 方法：先确定第一个字符有多少种可能，然后将整个串分为第一个，与后面所有的，然后固定第一个，求后面的串有多少种可能，
 * 然后再确定第二个串有多少种可能，固定前两个，继续找后面子串有多少种可能，
 * 直到最后一个字符的各种可能性确定，
 * 然后打印字符串。
 * 
 * @author Claudius
 *
 */
public class SubStrings {
	public static void compute(char[] strs, int start, int length) {
		if (start == length - 1) {
			System.out.println(String.valueOf(strs));
		} else {
			// compute(strs, start + 1, length);
			for (int i = start; i < length; i++) {
				char temp = strs[start];
				strs[start] = strs[i];
				strs[i] = temp;
				compute(strs, start + 1, length);
				strs[i] = strs[start];
				strs[start] = temp;
			}
		}
	}

	public static void main(String[] args) {
		String str = "abcd";
		compute(str.toCharArray(), 0, str.length());
	}
}
