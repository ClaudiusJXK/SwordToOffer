package swordToOffer.question31;

/**
 *
 * Created by claudius on 17-5-23.
 * 查找数组中连续子数组的和
 */
public class Question31 {
    public static void main(String[] args) {
        int[] nums = {3, 10, -4, 7, 2};
        System.out.print(caculator2(nums));
    }

    /**
     * 根据数组特性进行计算。
     * 一直累加，记录和值，若当前和值大于最大值，则最大值记录。
     * 在上行累加过程中，若遇到和值为负值，则下一个和值记录为下一个数组值
     * @param nums
     * @return 最大和的值
     */
    public static int caculator(int[] nums) {
        int sum = 0, greatSum = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (sum < 0)
                sum = nums[i];
            else
                sum += nums[i];
            if (sum > greatSum)
                greatSum = sum;
        }
        return greatSum;
    }


    /**
     * f(i)为以下标i结束的子数组。最后对比以每个i结束的最大值
     * f(i) = nums[i] i=0 或 f(i-1)<=0
     * f(i) = f(i-1)+nums[i] i!=0 或 f(i-1) > 0
     * @param nums
     * @return
     */
    public static int caculator2(int[] nums) {
        int length = nums.length;
        int[] sums = new int[length];
        for (int i = 0; i < length; i++) {
            if (i == 0 || sums[i - 1] < 0)
                sums[i] = nums[i];
            else if (sums[i - 1] > 0)
                sums[i] = sums[i - 1] + nums[i];
        }
        int sum = Integer.MIN_VALUE;
        for (int i = 0; i <length ; i++) {
            if (sum < sums[i] )
                sum = sums[i];
        }
        return sum;
    }
}
