package question44;

import java.util.Arrays;

/**
 * Created by Claudius on 2017/7/4.
 * 扑克牌选5张，大小王可以替代任意牌，判断该五张牌能否凑成序列。
 */
public class SequenceOfCard {
    public static void main(String[] args) {
        SequenceOfCard sequenceOfCard = new SequenceOfCard();
        int[] nums = {5,1,3,0,0};
        System.out.print(sequenceOfCard.judgeSequence(nums));
    }

    /**
     * 方法
     * 排序，统计0（大小王）的个数  与 序列间间隔的数之和
     * 判断0的个数是否大于序列间隔数，如果大于则true，否则false
     * @param nums
     * @return
     */
    public boolean judgeSequence(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);
        int zero = 0;
        int blank = 0;
        int pre = -1;
        for (int i = 0; i < length; i++) {
            if (nums[i] == 0)
                zero++;
            else if (pre == -1)
                pre = nums[i];
            else {
                if (nums[i] == pre)
                    return false;
                blank += (nums[i] - nums[i - 1] -1);
            }
        }
        if (blank > zero)
            return  false;
        return  true;
    }
}
