package question41;

/**
 * Created by Claudius on 2017/7/2.
 * question1:
 * 给定一个递增数组，找出数组中两个和为sum的数。
 * question2:
 * 给定一个值，求出和为该值的整数序列。
 */
public class SumIsS {
    public static void main(String[] args) {
        SumIsS sumIsS = new SumIsS();
        int[] nums = {1, 2, 4, 7, 11, 15};
        sumIsS.sumInSequence(15);
    }

    /**
     * question1
     *
     * @param nums 递增数组
     * @param sum  整数
     *             方法：
     *             遍历整个数组，begin为数组头，end为数组尾，二者相加，如果大于sum，则end减小，如果小于sum，则begin增大
     *             如果相等，输出数组然后break
     */
    public void sumInArray(int[] nums, int sum) {
        int end = nums.length - 1;
        int begin = 0;
        while (begin < end) {
            if (nums[begin] + nums[end] < sum)
                begin++;
            else if (nums[begin] + nums[end] > sum)
                end--;
            else
                break;
        }
        if (begin != end) {
            System.out.println(nums[begin] + " " + nums[end]);
        }
    }

    /**
     * question2
     *
     * @param sum 目标值
     *            设定begin 与end 开始值均为0
     *            begin加到end之和与sum比较。
     *            如果相等，则输出begin到end序列，然后sum+=++end，
     *            如果小于，则sum+=++end;
     *            如果大于，则sum-=begin，begin--;
     */
    public void sumInSequence(int sum) {
        int length = (sum + 1) / 2;
        int begin = 0, end = 0;
        int recordSum = begin + end;
        while (begin < length) {
            if (recordSum == sum) {
                for (int i = begin; i <= end; i++) {
                    System.out.print(i + " ");
                }
                System.out.println();
                end++;
                recordSum += end;
            } else if (recordSum < sum) {
                end++;
                recordSum += end;
            } else {
                recordSum -= begin;
                begin++;
            }
        }

    }
}
