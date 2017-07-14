package question53;

import java.util.Scanner;

/**
 * 实现.*的正则表达式，. 匹配任意一个字符  a* 表示匹配0-无穷个a
 * Created by Claudius on 2017/7/13.
 * <p>
 * 自己实现，无法保证.*时的匹配
 */
public class RegexExpression {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String str = in.nextLine();
            String regex = in.nextLine();
            System.out.println(regex = formatRegex(regex));
            System.out.println(judge(str, regex));

        }
    }

    /**
     * 将regex格式化出来
     * a*a 改成aa*，方便遍历时进行依次比对
     * 否则a*较难匹配到多个
     *
     * @param regex
     * @return
     */
    public static String formatRegex(String regex) {
        String[] strs = regex.split("\\*");
        int length = strs.length;
        for (int i = 0; i < length - 1; i++) {
            char end = strs[i].charAt(strs[i].length() - 1);
            char begin = strs[i + 1].charAt(0);
            if (end == begin) {
                int secondLength = strs[i + 1].length();
                int j = 1;
                for (; j < secondLength; ) {
                    if (end == strs[i + 1].charAt(j))
                        j++;
                    else
                        break;
                }
                strs[i] = strs[i] + strs[i + 1].substring(0, j);
                strs[i + 1] = strs[i + 1].substring(j);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length - 1; i++) {
            stringBuilder.append(strs[i]).append("*");
        }
        stringBuilder.append(strs[length - 1]);
        return stringBuilder.toString();
    }

    public static boolean judge(String str, String regex) {
        int length = str.length();
        int regexLength = regex.length();
        for (int i = 0, j = 0; i < length; ) {
            if (j >= regexLength)
                return false;
            if (str.charAt(i) != regex.charAt(j) && regex.charAt(j) != '.') {
                if ((str.charAt(i) == regex.charAt(j - 1) || regex.charAt(j - 1) == '.') && regex.charAt(j) == '*') {
                    i++;
                    continue;
                } else if (j + 1 < regexLength && regex.charAt(j + 1) == '*') {
                    j += 2;
                } else
                    return false;
            }
            i++;
            j++;
        }
        return true;
    }

}

