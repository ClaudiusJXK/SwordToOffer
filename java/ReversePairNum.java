package question36;


/**
 * Created by Claudius on 2017/6/15.
 * 找出一个数组中的逆序对。
 * {7,5,6,4} 逆序对{7 5} { 7 6} {7 4} { 5 4} { 6 4}
 * 一共五对
 * 使用方法，归并排序
 * <p>
 * merge的过程中比较
 * 如果左边数组中某个值L[i]大于右边数组中某个值R[j]，那么左边数组L[i]大于右边数组R[j]及R[j]到R[middle+1]的所有值
 * 两个数组间那么就有j-middle个逆序对。
 * 两个数组merge后再和其他数组进行比较。
 * 因为两个数组已经提取出了二者之间的所有逆序对，因为两个数组组成一起的新数组段无论怎么排序都不会再影响其他逆序对的选择。
 */
public class ReversePairNum {
    private int sum;

    public ReversePairNum() {
        sum = 0;
    }

    public static void main(String[] args) {
        ReversePairNum reversePairNum = new ReversePairNum();
        int[] nums = {7, 5, 6, 4};
        int legth = nums.length;
        reversePairNum.sort(nums, 0, legth - 1);

        for (int i = 0; i < legth; i++) {
            System.out.print(nums[i] + " ");
        }

        System.out.print(reversePairNum.sum);
    }

    public void sort(int[] array, int begin, int end) {
        if (begin >= end)
            return;
        int middle = (begin + end) / 2;
        sort(array, begin, middle);
        sort(array, middle + 1, end);
        merge(array, begin, middle, end);
    }

    public void merge(int[] array, int begin, int middle, int end) {
        int left = middle;
        int right = end;
        int index = end;
        int[] newArray = new int[end + 1];
        /**
         * 为了计算逆序对，因此要从两个数组段的最后开始循环。
         * 并且左边大于右边时需要sum加上右边剩下的值。
         */
        while (left >= begin && right >= middle + 1) {
            if (array[left] > array[right]) {
                newArray[index--] = array[left];
                sum += right - middle;
                left--;
            } else {
                newArray[index--] = array[right];
                right--;
            }
        }
        if (left >= begin) {

            for (int i = left; i >= begin; i--) {
                newArray[index--] = array[i];
            }
        } else {
            for (int i = right; i >= middle + 1; i--) {
                newArray[index--] = array[i];
            }
        }
        for (int i = begin; i <= end; i++) {
            array[i] = newArray[i];
        }
    }

}
