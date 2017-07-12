package question46;

/**
 * Created by Claudius on 2017/7/10.
 * 如何实现不适用+-/*进行数字相加
 * 通过异或方式
 * 1、异或结果即为对应位相加结果
 * 2、二者求与再左移，即为进位值
 *
 */
public class Add {
    public static void main(String[] args) {
        System.out.println(add(5, -3));
    }

    /**
     *
     * @param num1
     * @param num2
     * @return
     *
     * 通过异或方式
     * 1、异或结果即为对应位相加结果
     * 2、二者求与再左移，即为进位值
     *
     * 将进位置赋值给num2，继续进行1,2循环，直到num2为0
     */
    public static int add(int num1, int num2) {
        while (num2 != 0) {
            int carry = num1 & num2;
            carry = carry << 1;
            num1 = num1 ^ num2;
            num2 = carry;
        }
        return num1;
    }
}
