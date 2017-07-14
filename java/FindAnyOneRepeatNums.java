package question51;

/**
 * 包含n个值的数组，其中数字为0-n-1，可能有重复的，返回一个重复的数字即可
 * <p>
 * Created by Claudius on 2017/7/12.
 */
public class FindAnyOneRepeatNums {
    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 2, 5, 4, 2};
        System.out.print(findDuplicate(nums));
    }

    /**
     * 依次遍历数组，从下标0开始，将0处的值m与nums[m]交换。
     *
     * @param nums
     * @return
     */
    public static int findDuplicate(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            while (nums[i] != i) {
                int m = nums[i];
                if (m == nums[m])
                    return m;
                else {
                    nums[i] = nums[m];
                    nums[m] = m;
                }
            }
        }
        return -1;
    }
}
