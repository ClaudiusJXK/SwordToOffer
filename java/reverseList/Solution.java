package reverseList;
/**
 * 
 * @author Claudius
 *	翻转链表
 */
public class Solution {
	public static ListNode reverseList(ListNode node){
		ListNode preNode = null;
		ListNode pNext = null;
		if (node == null) {        //如果为空，则直接返回
			return null;
		}
		while(node.m_pnext != null){  //依次遍历，一个记录next，一个记录pre
			pNext = node.m_pnext;         //next
			node.m_pnext = preNode;       //当前node指向pre
			preNode = node;               //当前node赋值给pre
			node = pNext;                 //next赋值给node
		}
		node.m_pnext = preNode;           //node的next指向前一个
		return node;
	}
	/**
	 * 测试
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode node = new ListNode(0);
		ListNode first = node;
		for(int i = 1;i<=5;i++){
			ListNode next = new ListNode(i);
			node.m_pnext = next;
			node = next;
		}
		node = reverseList(first);
		while(node !=null && node.m_pnext != null){
			System.out.println(node.m_nKey);
			node = node.m_pnext;
		}
	}
}
