package printToMaxOfDigits;

/**
 *  给定一个整数n，输出从1到最大值的n为数，比如说输入3，输出1-999。考虑到整型不能表示的大数，所以按位用数组来输出
 * @author Claudius
 *
 */
public class PrintToMaxOfDigits {
	public static void main(String args[]) {
		PrintToMaxOfDigits ppp = new PrintToMaxOfDigits();
		ppp.printNum(100);
	}
	/**
	 * 打印数字
	 * @param n 位数
	 */
	public void printNum(int n) {
		if (n <= 0) {
			return;
		}
		int[] num = new int[n];
		while(!increment(num)){
			for(int everyBit : num)
				System.out.print(everyBit);
			System.out.println();
		}
	}
	/**
	 * 当前值加1
	 * @param num  数组 表示大数
	 * @return
	 */
	public boolean increment(int[] num) {
		boolean lastNumber = false;                     //是否最后一位产生了进位
		int length = num.length;                        //多少位数
		int carry = 0;                                  //进位
		for (int index = length - 1; index >= 0; index--) {
			if (index == length-1) {                    //最后一位则加1，如果其他位则不管
				num[index]++;
			} 
			num[index] += carry;                        //当前位的值加进位
			if (num[index] == 10) {                     //判断是否需要进位
				if (index == 0) {                       //如果是最高位需要进位，则已达到最大值，直接返回
					lastNumber = true;
					break;
				}
				num[index] = 0;                         //不是最高位，并且进位值取1
				carry = 1;
			}else { 
				carry = 0;                              //无需进位，carry赋值并跳出循环
				break;
			}
			
		}
		return lastNumber;
	}

}
