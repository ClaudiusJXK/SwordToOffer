package question33;


/**
 * Created by Claudius on 2017/6/8.
 * 将数组中的所有数组成一个数，返回最小的那个数。
 *
 * 使用了快排，排序大小比较方式为 a+b 与 b+a  的字典序比较。
 * 不能只比较ab，防止3 321 比较，产生3小于321的效果。
 */
public class MinNumOfArray {
    public static void main(String[] args) {
        int[] N = {174,13, 32, 321, 30789};
        int length = N.length;
        String[] nums = new String[length];
        for (int i = 0; i < length; i++) {
            nums[i] = String.valueOf(N[i]);
        }
        quickSort(nums, 0, length - 1);
        for (String num : nums) {
            System.out.print(num + " ");
        }
    }

    public static void quickSort(String[] nums, int left, int right) {
        if (left >= right)
            return;
        int part = partition(nums, left, right);
        quickSort(nums, left, part - 1);
        quickSort(nums, part + 1, right);
    }

    public static int partition(String[] nums, int left, int right) {
        String num = nums[left];
        while (left < right) {
            while (left < right && (num + nums[right]).compareTo(nums[right] + num) <= 0)
                right--;
            nums[left] = nums[right];
            while (left < right && (num + nums[right]).compareTo(nums[left]+num) >= 0)
                left++;
            nums[right] = nums[left];
        }
        nums[left] = num;
        return left;
    }
}
