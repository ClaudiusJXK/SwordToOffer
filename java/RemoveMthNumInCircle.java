package question45;

/**
 * Created by Claudius on 2017/7/6.
 * 圆圈中最后剩下的数字。
 * 0～n-1 一共n个数围成一个圈，从0开始，每次移动m位，然后去掉对应的该值
 * 最后剩下一个数的时候，求这个数
 */
public class RemoveMthNumInCircle {
    public static void main(String[] args) {
        RemoveMthNumInCircle removeMthNumInCircle = new RemoveMthNumInCircle();
        System.out.println(removeMthNumInCircle.remove(3,15));
    }

    /**
     *
     * @param n
     * @param m
     * @return
     */
    public int remove(int n, int m) {
        if (n < 1 || m < 1)
            return -1;
        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;
    }
}
