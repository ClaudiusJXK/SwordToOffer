package treeToList;

/**
 * 
 * @author Claudius
 *  不新建结点，将bstTree变成排序双向链表。。由此可知，通过中序遍历，并记录pre结点为上一个结点，依次对各个结点的leftson与rightson进行赋值操作。
 */
public class BSTToList {
	/**
	 * 保存上一步遍历结点
	 */
	private static BinaryTreeNode pre = null;
	/**
	 * 中序遍历，并生成双向链表，返回尾结点（即pre结点，最后一个遍历结点）
	 * @param node 根节点
	 */
	public static void traverse(BinaryTreeNode node) {
		if (node == null) {
			return;
		}
		
		traverse(node.leftSon);
		/**
		 * pre不为空，则pre的rightSon 为当前结点，当前结点leftSon为pre结点
		 */
		if (pre != null) {
			pre.rightSon = node;
			node.leftSon = pre;
		}
		//pre结点赋值为当前结点
		pre = node;

		traverse(node.rightSon);
	}
	/**
	 * 根据数组构建一个bst
	 * @param nums
	 * @return
	 */
	public static BinaryTreeNode buildBst(int [] nums){
		int length = nums.length;
		BinaryTreeNode head = new BinaryTreeNode(nums[0]);
		for(int i = 1 ;i<length;i++){
			BinaryTreeNode newNode = new BinaryTreeNode(nums[i]);
			BinaryTreeNode node = head;
			while(node != null){
				if ( newNode.value > node.value) {
					if (node.rightSon != null) {
						node = node.rightSon;
					}else {
						node.rightSon = newNode;
						break;
					}
					
				}else {
					if (node.leftSon != null) {
						node = node.leftSon; 
					}else {
						node.leftSon = newNode;
						break;
					}
				}
			}
			node = newNode;
		}
		return head;
	}
	public static  void main(String [] args) {
		int[] nums ={2,3,5,1,7,4,9,8};
		BinaryTreeNode head = buildBst(nums);
		traverse(head);
		while(pre != null){
			System.out.print(pre.value + " ");
			pre = pre.leftSon;
		}
	}
}
