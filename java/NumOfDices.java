package question43;

/**
 * Created by Claudius on 2017/7/2.
 * n个骰子掷下，和为s，求和的分布情况。
 */
public class NumOfDices {
    public static void main(String[] args) {
        NumOfDices numOfDices = new NumOfDices();
        numOfDices.computeDistribute(2);
    }

    /**
     *
     * @param num 骰子数量
     *            思路为动态规划。
     *            当骰子只有一个的时候和为1，2，3，4，5，6 均为i；
     *            当骰子再加一个的时候，和为n的数量为 n-1 n-2 n-3 n-4 n-5 n-6的数量之和
     *            累加之下，求出骰子数最多的结果
     */
    public void computeDistribute(int num) {
        int lowest = num;
        int highest = num * 6;
        int[] preTime = new int[highest + 1];
        int[] time = new int[highest + 1];
        for (int i = 1; i <= num; i++) {
            if (i == 1) {
                for (int j = 1; j <= 6; j++) {
                    preTime[j] = 1;

                }
            } else {
                int end = 6 * i;
                for (int j = 1; j <= end; j++) {
                    int low = j - 6;
                    for (int k = j - 1; k > 0 && k >= low; k--) {
                        time[j] += preTime[k];
                    }
                }
                int[] temp = preTime;
                preTime = time;
                time = temp;
            }
        }
        for (int i = 0; i <= highest; i++) {
            System.out.print(preTime[i]+" ");
        }
    }
}
