package question38;

/**
 * Created by Claudius on 2017/6/24.
 * 找出一个排序数组中某值出现几次。
 * 通过二分查找原理进行查找。
 *
 */
public class GetTimesOfNum {

    public static void main(String[] args) {
        GetTimesOfNum getTimesOfNum = new GetTimesOfNum();
        int[] nums = {1, 2, 3, 3, 4, 6, 8};
        int start = getTimesOfNum.findFirst(nums, 0, nums.length, 3);
        int last = getTimesOfNum.findLast(nums, 0, nums.length, 3);
        if (start != -1 && last != -1)
            System.out.print(last - start + 1);
    }

    public int findFirst(int[] nums, int begin, int end, int num) {
        if (begin > end)
            return -1;
        int index = (begin + end) / 2;
        //如果当前中值为num  那么判断该值前一个数是否为num，若不是，则该值为当前数组中值为num的第一个值
        if (nums[index] == num) {
            //如果该值非数组第一个，并且其前一个值仍为num
            if (index > 0 && nums[index - 1] == num) {
                end = index - 1;
            } else {
                return index;
            }
        } else if (nums[index] > num) { //该值大于num
            end = index - 1;
        } else {                        //该值小于num
            begin = index + 1;
        }

        return findFirst(nums, begin, end, num);  //递归，使用尾递归
    }

    public int findLast(int[] nums, int begin, int end, int num) {
        if (begin > end)
            return -1;
        int index = (begin + end) / 2;
        //如果当前中值为num  那么判断该值后一个数是否为num，若不是，则该值为当前数组中值为num的最后一个值
        if (nums[index] == num) {
            //如果该值非数组最后一个值，并且后一个值仍为num
            if (index < (nums.length - 1) && nums[index + 1] == num) {
                begin = index + 1;
            } else {
                return index;
            }
        } else if (nums[index] > num) { //该值大于num
            end = index - 1;
        } else {                        //该值小于num
            begin = index + 1;
        }

        return findLast(nums, begin, end, num);  //递归，使用尾递归
    }
}
