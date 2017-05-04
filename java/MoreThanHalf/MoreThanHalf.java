package question29;

/**
 * Created by Claudius on 2017/5/3.
 * 判断一个数组中，某个数是否出现次数超过数组的一半，若有，则 输出该数，若无，则返回0
 * 使用快速排序的partition函数，确定数组middle位置的数字，如果这个数字超过了数组长度的一半，那么middle位置的数字肯定是这个数字。
 * 最后再遍历依次数组，verify一下这个数组即可。
 */
public class MoreThanHalf {
    public static void main(String[] args) {
        int[] nums = {3, 3, 3, 3, 2, 2, 2, 2, 1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.print(caculator(nums));
    }

    public static int caculator(int[] nums) {
        int middle = nums.length >> 1;
        int start = 0;
        int end = nums.length - 1;
        int index = partition(nums, start, end);
        while (index != middle) {
            if (index > middle) {
                end = index - 1;
                index = partition(nums, start, end);
            } else {
                start = index + 1;
                index = partition(nums, start, end);
            }
        }
        int result = nums[index];
        if (verify(nums, result))
            return result;
        else
            return 0;
    }

    public static boolean verify(int nums[], int number) {
        int time = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] == number)
                time++;
        }
        if (time > length >> 1)
            return true;
        else
            return false;
    }

    public static int partition(int[] nums, int start, int end) {
        int value = nums[start];
        int left = start, right = end;
        while (left < right) {
            while (left < right && nums[right] >= value)
                right--;
            nums[left] = nums[right];
            while (left < right && nums[left] <= value)
                left++;
            nums[right] = nums[left];
        }
        nums[left] = value;
        return left;
    }
}
