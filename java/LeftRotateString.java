package question42;

/**
 * Created by Claudius on 2017/7/2.
 * 将字符数组左旋n位
 *
 *
 */
public class LeftRotateString {
    public static void main(String[] args) {
        char[] str = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
        LeftRotateString leftRotateString = new LeftRotateString();
        leftRotateString.leftCircle(str, 2);
        System.out.print(String.valueOf(str));
    }

    /**
     *
     * @param str 字符数组
     * @param num  旋转数
     *             逆序整个数组，然后逆序第一段，在逆序第二段
     *             abcdefg
     *             gfedcba
     *             cdefg ab
     */
    public void leftCircle(char[] str, int num) {
        int end = str.length - 1;
        int begin = 0;
        inverse(str, begin, end);
        inverse(str, begin, end - num);
        inverse(str, end - num + 1, end);
    }

    public void inverse(char[] str, int begin, int end) {
        while (begin < end) {
            char temp = str[begin];
            str[begin] = str[end];
            str[end] = temp;
            begin++;
            end--;
        }

    }
}
