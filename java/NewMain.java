package ali;

import java.util.Arrays;

/**
 * 
 * @author Claudius
 * 给一个正整数数组，砍掉三个数，分为四个段，查看是否存在着三个数，让这四个段之和相等。如果存在则返回true。
 * 阿里的笔试题。
 */

public class NewMain {

/** 请完成下面这个函数，实现题目要求的功能 **/
 /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static boolean resolve(int[] A) {
    	int length = A.length;
    	if (length <= 7) {                //数组中数的数量至少有七个
			return false;
		}               
         //先对两个和rightSum和leftSum赋值，分别为左端与右端赋值给两段的和
    	for(int left = 1,right = length - 2,rightSum = A[length - 1],leftSum = A[0];left <= right - 4; ){ //从两端开始遍历，直到左端与右端下标距离
    		if (leftSum < rightSum) {                     //哪个大，移动哪个                                                                                                          //（必须保证中间的数还可以分为两段）
				leftSum += A[left];
				left++;
				continue;
			}else if (leftSum > rightSum) {
				rightSum += A[right];
				right--;
				continue;
			}
    		if(right - left  + 2 <= 2*leftSum  ){
    			return false;
    		}
    		//此时leftSum  和rightSum相等，left 和 right 分别对应需要跳过的下标
    		int middleLeft,middleRight,middleLeftSum;
    		// middleRight 代表中间最右值的下标
    		//将左起第一个值赋值给middleLeftSum，累加循环，直到middleLeftSum大于等于leftSum 或者 距离右端只有两个值时
    		for( middleLeft = left+2,middleRight = right - 1,middleLeftSum = A[left + 1];middleLeft < middleRight-1; middleLeft++){
        		if (middleLeftSum >= leftSum) {               //如果要是相等，或者比leftSum大，则跳出循环
    				break;
    			}else if (middleLeftSum < leftSum) {          //如果要是小于，则继续循环
    				middleLeftSum += A[middleLeft];
    			}
    		}
    		
    		
    		if (middleLeftSum < leftSum) {                   //小于代表着中间值加完了还是小于，所以最外圈循环再加下去会更小，没有必要再继续了
				return false;
			}else if (middleLeftSum == leftSum) {             //相等，判断剩下的值之和是否相等，如果不相等，则继续外圈循环   
				int middleRightSum = 0;
				//因为相等了，所以必然是从middleLeft + 1开始的，因为要空过下一个下标
				for(int index = middleLeft + 1;index <= middleRight;index++){
					middleRightSum += A[index];
				}
				//判断是否相等
				if (middleRightSum == rightSum) {
					return true;
				}else {
					continue;
				}
			}else {                                       //大于，给左边继续加，然后继续循环
				leftSum += A[left];
				left++;
			} 
    	}
    	return false;
    }

    public static void main(String[] args){
//        ArrayList<Integer> inputs = new ArrayList<Integer>();
//        Scanner in = new Scanner(System.in);
//        String line = in.nextLine();
//        while(line != null && !line.isEmpty()) {
//            int value = Integer.parseInt(line.trim());
//            if(value == 0) break;
//            inputs.add(value);
//            line = in.nextLine();
//        }
//        int[] A = new int[inputs.size()];
//        for(int i=0; i<inputs.size(); i++) {
//            A[i] = inputs.get(i).intValue();
//        }
    	int [] A = {2,2,5,1,2,1,1,3,1,10,1,1,1,1};
        Boolean res = resolve(A);

        System.out.println(String.valueOf(res));
    }
}