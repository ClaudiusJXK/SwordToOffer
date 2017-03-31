package today;

import java.util.Scanner;



/**
 * 在一个数组中，找出先递增后递减的最大区间，返回其下标
 * @author Claudius
 *
 */
public class MaxSection {
	public static void main(String [] args) {
		Scanner in = new Scanner(System.in);
		int num =in.nextInt();
		int [] nums = new int[num];
		for(int i= 0;i<num;i++){
			nums[i] = in.nextInt();
		}
		compute(nums);
	}
	public static void compute(int[] nums){
		int leftIndex = -1;
		int rightIndex =  -1;
		boolean up = false;      //之前是否为递增
		int count = 0;           //目前区间的计数值
		int length = nums.length;   
		for(int i = 1;i<length;i++){     
			/**
			 * 从0与1 开始，判断前两个是递增还是递减
			 */
			if (i==1) {
				if (nums[1] >nums[0]) {
					up = true;
					count = 1;
				}
				
			}else if (nums[i] > nums[i-1]) {   //如果当前值为递增时
				if (up) {                      //如果之前就是递增的，那么现在继续+1
					count ++;
				}else {                        //如果之前是递减的，那么之前那个区间到头了，比较区间大小
					if (count > 0) {
						if (count > (rightIndex - leftIndex)) {
							leftIndex = i-count - 1;
							rightIndex = i - 1;
							
						}
					}
					count = 1;
				}
				up = true;
			} else {                             //当前值为递减时
				up = false;                 
				if (count > 0) {                       //如果有计数，说明当前还位于之前的区间，增加
					count ++ ;
				}
				
			}
			
			
		}
		if (count > rightIndex - leftIndex && !up) {        //计数到最后还需判断是否处于下降区间，否则不计
			leftIndex = length -1 -count;
			rightIndex = length - 1;
		}
		System.out.println(leftIndex+" " +rightIndex);
	}
}
