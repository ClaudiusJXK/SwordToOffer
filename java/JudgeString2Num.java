package question54;

import java.util.Scanner;

/**
 * 判断一个字符串是否可以转换为数字
 * +100 5e2 -123 3.1416 -1E-16 是
 * 12e  1a3.14 1.2.3 +-5 12e+5.4 不是
 *
 *
 * Created by Claudius on 2017/7/14.
 */
public class JudgeString2Num {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String str = in.nextLine();
            System.out.println(judge(str));
        }
    }

    /**
     * 遍历整个字符串，设定标志位flags，用来确定是否遇到了 +- eE . 等
     * flags[0] 确定首位的+-合法性，由于直接判断下标是否为0即可，所以没用到
     * @param str
     * @return
     */

    public static boolean judge(String str) {
        if (str == null || str.length() == 0)
            return false;
        /**
         * 分别代表
         * 0:e之前的 .
         * 1: e/E
         *
         */
        boolean[] flags = new boolean[2];


        for (int i = 0; i < 2; i++) {
            flags[i] = false;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            //正常数字
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9')
                continue;
            //如果为e
            if (str.charAt(i) == 'e' || str.charAt(i) == 'E')
                if (flags[1] == false && i != length - 1)
                    flags[1] = true;
                else
                    return false;
                //如果为.
            else if (str.charAt(i) == '.')
                //.在e之前，并且是遇到的第一个.
                if (flags[1] == false && flags[0] == false)
                    flags[0] = true;
                else
                    return false;
                //如果为+-
            else if (str.charAt(i) == '+' || str.charAt(i) == '-') {
                //如果在e之后遇到+-
                if (flags[1] == true) {
                    //保证该+-号前一位必须是e/E
                    if ( str.charAt(i - 1) == 'e' || str.charAt(i - 1) == 'E') {
                        continue;
                    } else
                        return false;
                } else {
                    if (i != 0)
                        return false;
                }
            } else
                return false;

        }
        return true;
    }
}
