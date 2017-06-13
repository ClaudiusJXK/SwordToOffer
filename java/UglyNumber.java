package question34;

/**
 * Created by Claudius on 2017/6/12.
 * 返回第n个丑数。
 * 丑数只能化简为2^n1*3^n2*5^n5次的形式。1也是丑数。
 * 依次添加丑数，从小到大，选取刚大于当前最大丑数的2,3,5倍的数中最小的一个来添加。
 */
public class UglyNumber {
    public int[] nums;
    private int index2, index3, index5;

    public static void main(String[] args) {
        UglyNumber uglyNumber = new UglyNumber();
        uglyNumber.result(1500);
        for (int i = 0; i < 1500; i++) {
            System.out.println(uglyNumber.nums[i]);
        }
    }

    public int result(int number) {
        nums = new int[number];
        index2 = 0;
        index3 = 0;
        index5 = 0;
        nums[0] = 1;
        int num2, num3, num5;
        for (int i = 1; i < number; i++) {
            while ((num2 = nums[index2] * 2) <= nums[i - 1]) {
                index2++;
            }
            while ((num3 = nums[index3] * 3) <= nums[i - 1]) {
                index3++;
            }
            while ((num5 = nums[index5] * 5) <= nums[i - 1]) {
                index5++;
            }
            nums[i] = compare(num2, num3, num5);
        }
        return nums[number - 1];
    }

    public int compare(int num2, int num3, int num5) {
        int min = num2 < num3 ? num2 : num3;
        return min < num5 ? min : num5;
    }
}
