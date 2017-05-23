package swordToOffer.question30;

/**
 * Created by claudius on 17-5-23.
 * 找出数组中最小的k个数
 * 利用partition函数进行循环计算，直到k值为分界值
 */

public class Question30 {
    public static void main(String[] args) {
        int[] nums = {4, 5, 1, 6, 2, 7, 3, 8};
        Question30.caculator(nums, 5);
    }

    public static void caculator(int[] nums, int k) {
        int length = 0;
        if (nums == null || (length = nums.length) < k)
            return;
        int end = length - 1;
        int start = 0;
        int value = partition(nums, start, end);
        while (value != k) {
            if (value > k)
                end = value - 1;
            else
                start = value + 1;
            value = partition(nums, start, end);
        }
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    /**
     * @param nums  数组
     * @param start
     * @param end   最后一个下标，非数组长度
     * @return
     */
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
