package adjust;
import java.util.Scanner;

/**
 * 网易在线笔试题
 * 将输入下标只有B或者G的字符串，调整为BBBBGGG或者GGGBBB的形式，求最小的调整次数。
 * BBGGB 调整次数为 2
 * @author Claudius
 * 方法：记录B或者G的下标，然后下标相加，再减去每次多加的数（1到num-1之和，num为B或者G的数量）
 *     记录B或者G的下标，然后最后一个下标与下标之差相加，再减去每次多加的数（1到num-1之和，num为B或者G的数量）
 *     最后比较二者的值，返回小的那个
 */
public class Adjust {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String text = in.nextLine();
		if (text.length() <= 2) {
			System.out.println(0);
		}else {
			System.out.println(compute(text));
		}
		
	}
	public  static int  compute(String text){
		char[] s = text.toCharArray();
		int length = s.length;
		int leftTime = 0 ,rightTime = 0 , num = 0 , delete = 0;
		for(int i = 0;i<length;i++){
			if (s[i] == 'B') {
				num ++;
				leftTime += i;
				rightTime += (length-1 -i );
			}
		}
		if (num > 0) {
			delete = (num-1)*num/2;
		}
		leftTime -= delete;
		rightTime -= delete;
		return leftTime > rightTime ?rightTime:leftTime;
	}
}
