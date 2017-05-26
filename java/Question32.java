package swordToOffer.question32;

/**
 * Created by claudius on 17-5-25.
 * 给定一个数n，求1-n过程中1出现的次数。
 * 比如21345
 * 先求1346-21345. 求最高位1出现的次数，再依次求低位各个位出现的次数
 * 最高位出现的次数通过判断最高位值是否为1分为两部分讨论。
 * 然后递归1-1345中出现的值。
 */
public class Question32 {
    public static void main(String[] args) {
        int sum = 0;
        System.out.print(caculate("21345",sum));
    }

    public static int caculate(String nums, int sum) {
        int length = nums.length();
        if (length == 1)
            return sum += (Integer.valueOf(nums) == 0 ? 0 : 1);
        String first = nums.substring(0, 1);
        String lowBit = nums.substring(1);
        int firstNum = Integer.valueOf(first);


        if (firstNum == 1) {
            sum += Integer.valueOf(lowBit)+1;
            sum += (length - 1) * Math.pow(10, length - 2);
            return caculate(lowBit, sum);
        } else {
            sum += Math.pow(10, length - 1);
            sum += firstNum * (length - 1) * Math.pow(10, length - 2);
            return caculate(lowBit, sum);
        }


    }
}
