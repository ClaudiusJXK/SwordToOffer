package question29;

/**
 * Created by Claudius on 2017/5/3.
 */
public class MoreThanHalf {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2};
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
            nums[left++] = nums[right];
            while (left < right && nums[left] <= value)
                left++;
            nums[right--] = nums[left];
        }
        nums[left] = value;
        return left;
    }
}
