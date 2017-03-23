package bstree;
/**
 * 判断一个数组是否是二叉搜索树的后续遍历结果。
 * 如果是二叉搜索树的后续遍历结果，那么这个数组会分为两段，前一段比根节点（数组最后一个点）小，后一段比根节点大。
 * 然后分别递归前半段与后半段
 * @author Claudius
 *
 */
public class JudgeBSTree {
	public static boolean judge(int[] nums,int begin,int end){
		if (nums == null ) {
			return false;
		}
		/**
		 * 如果剩下两个了，那么怎么都对
		 */
		if (end - begin <= 2) {
			return true;
		}
		int middle;
		int index;
		/**
		 * 先找出后半段大于根节点的，然后记录下标到middle
		 */
		for(index = end - 1;index >= begin && nums[index] > nums[end];index--){}
		middle = index;
		/**
		 * 如果前半段必须全都小于根节点，如果有大于根节点则直接返回false
		 */
		for(;index >= begin;index --){
			if (nums[index] > nums[end]) {
				return false;
			}
		}
		/**
		 * 递归前半段，如果都正确，那么返回true，否则直接返回false
		 */
		if(!judge(nums, begin, middle)){
			return false;
		}
		/**
		 * 同上
		 */
		if (!judge(nums, middle+1, end-1)) {
			return false;
		}
		//最后说明前后半段都是true，则返回true
		return true;
		
		
	}
	public static void main(String [] args) {
		int[] nums={7,4,6,5};
//		int[] nums={5,7,6,9,11,10,8};
		System.out.println(judge(nums, 0, nums.length-1));
	}
}
