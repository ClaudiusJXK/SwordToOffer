package question53;

/**
 * Created by Claudius on 2017/7/13.
 * 课本上的思路
 */
public class RegexExpressionInBook {
    public static void main(String[] args) {
        String str = "abbaa";
        String regex = "ab*bac*a";
        System.out.println(match(str, regex));
    }

    /**
     * 先判断二者是否为空
     *
     * @param str
     * @param regex
     * @return
     */
    public static boolean match(String str, String regex) {
        if (str == null || regex == null)
            return false;
        return matchCore(str, regex, 0, 0);
    }

    public static boolean matchCore(String str, String regex, int strIndex, int regexIndex) {
        int strLength = str.length();
        int regexLength = regex.length();

        //str结束  regex结束
        if (strIndex >= strLength && regexIndex >= regexLength)
            return true;


        //str没结束，regex结束
        if (strIndex < strLength && regexIndex >= regexLength)
            return false;

        //以下全部属于：
        //str没结束，regex没结束
        //str结束，regex没结束


        //str结束，但是regex下一个是*
        //str没结束，但是regex下一个是*
        if (regexIndex < regexLength - 1 && regex.charAt(regexIndex + 1) == '*') {
            /**
             * aba
             * ab*ba
             * b比对的时候，下面的b*可以为0个，接下来比对 strIndex 与 regexIndex + 2
             *             下面的b*可以为重复多个，接下来比对 strIndex + 1 与regexIndex
             */
            //str没结束并且regex为.或者与str的下标对应值相等。
            if (strIndex < strLength && (str.charAt(strIndex) == regex.charAt(regexIndex) ||
                    regex.charAt(regexIndex) == '.')) {
                return matchCore(str, regex, strIndex, regexIndex + 2) || //此处*表示有0个 这种情况用来针对a*b这种情形
                        matchCore(str, regex, strIndex + 1, regexIndex);  //此处*表示该值在这里重复
            } else {     //str结束或者regex的下标与str的下标不匹配
                return matchCore(str, regex, strIndex, regexIndex + 2);
            }
        }

        //以下全部属于：
        //str结束或者不结束，regex下一个不是*

        //regex下一个不是*，str不结束。 如果二者匹配，则各加1，继续循环下去
        if (strIndex < strLength && (regex.charAt(regexIndex) == '.' || regex.charAt(regexIndex) == str.charAt(strIndex)))
            return matchCore(str, regex, strIndex + 1, regexIndex + 1);

        //regex下一个不是*，str结束了或者str没结束但是不匹配
        return false;

    }
}
