package question40;

/**
 * Created by Claudius on 2017/6/28.
 * 一个数组，有两个值出现一次，其余所有值出现两次，求出这两个值
 * 解法：
 * <p>
 * 异或，任何数异或自己结果为0
 * <p>
 * 异或整个数组，最后结果为只出现一次的两个值的异或结果，并且该结果 != 0
 * <p>
 * 找到该异或结果自右向左第一个不为0的bit位。
 * <p>
 * 即数组中，这两个出现一次的值，在该bit为不同。
 * <p>
 * 通过对该bit位不为0的值进行求与，将数组分为了两类，该bit位为0的与该bit为不为0的
 * <p>
 * 然后将这两类数字与该类的其他数字进行异或，结果即为只出现一次的那个数。
 */
public class OnceInArray {
    public static void main(String[] args) {
        int i = 1;
        OnceInArray onceInArray = new OnceInArray();
        int[] nums = {1, 1, 2, 2, 3, 3, 4, 5, 6, 6};
        onceInArray.findOut(nums);

    }

    /**
     * @param nums 要找到只出现一次的那两个值的数组
     */
    public void findOut(int[] nums) {
        if (nums == null)
            return;
        //先求出来数组整体异或值  即两个只出现了一次的两个值的异或值
        int xorResult = xor(nums);

        //找到第一个不为0的bit位，即这两个值在该位不一样
        int i = computeBit(xorResult);

        int A = 0; //记录该位为0的异或结果
        int B = 0; //记录该位不为0的异或结果
        int length = nums.length;
        for (int j = 0; j < length; j++) {

            if ((nums[j] & i) == 0)
                A = A ^ nums[j];
            else
                B = B ^ nums[j];
        }
        System.out.print(A + " " + B);
    }

    /**
     * @param nums 需要异或的数组
     * @return 返回所有值的异或结果
     */
    public int xor(int[] nums) {
        if (nums == null)
            return 0;
        int length = nums.length;
        int result = 0;
        for (int i = 0; i < length; i++) {
            result = result ^ nums[i];
        }

        return result;
    }

    /**
     * @param num 给定一个异或结果
     * @return 返回自右向左第一个bit位不为0时，该bit位对应的值。
     */
    public int computeBit(int num) {
        int i = 1;
        for (int j = 0; j < 31; j++) {
            if ((num & i) != 0)
                return i;
            i <<= 1;
        }
        return 3;
    }
}
