package checkStack;

import java.util.LinkedList;

/**
 * @author Claudius 给定入栈与出栈顺序，根据入栈顺序，判断出栈顺序是否有可能
 * 思路为，给定一个栈，然后按照出栈顺序出栈，没有的话就按照入栈顺序先入栈，再出栈，直到出栈顺序遍历结束或者全部入栈但是无法出栈。
 */
public class CheckStack {
	private LinkedList<Integer> stack = new LinkedList<>();

	/**
	 * 判断是否有可能以该顺序出栈
	 * 
	 * @param in
	 * @param out
	 * @return
	 */
	public boolean check(int[] in, int[] out) {
		if (in == null || out == null || in.length != out.length) {
			return false;
		}
		int length = in.length;
		/**
		 * 以出栈下标进行循环判断
		 */
		for (int inIndex = 0, outIndex = 0; outIndex < length; ) {
			/**
			 * 如果栈不为空，且栈顶元素与当前值相同，则出栈，出栈数组下标++
			 */
			if (stack.size() != 0 && stack.peekLast() == out[outIndex]){
				stack.pollLast();
				outIndex++;             //outIndex++之所以写在这儿不是写在循环里是有道理的，防止下面循环结束后没有找到，却可以继续主循环，这样只有出栈的最后一个数不正确时会返回错误
			}
			/**
			 * 如果已全部入栈，但是栈顶元素不是这个值，则返回false
			 */
			else if (inIndex == length) {
				return false;
			} else {
				/**
				 * 没有全部入栈，然后依次入栈，直到全入栈或者找到与当前出栈值相同的值，此时直接让二者下标都+1，表示已入栈出栈过
				 */
				for (; inIndex < in.length; inIndex++) {
					if (in[inIndex] == out[outIndex]) {
						inIndex++;
						outIndex++;
						break;
					}
					stack.addLast(in[inIndex]);
				}
			}

		}
		//出栈顺序遍历完，返回正确
		return true;
	}

	public static void main(String[] args) {
		CheckStack stack = new CheckStack();
		int[] in = { 1, 2, 3, 4, 5 };
		int[] out = { 4, 3, 2, 1, 5};
		System.out.print(stack.check(in, out));
	}
}
