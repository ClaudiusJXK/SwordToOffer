

import java.util.LinkedList;
import java.util.Queue;
/**
 * 广度遍历二叉树。（横向遍历）  使用queue实现，每次出队，就把当前结点的孩子入队。
 * 我的方法用了递归，不好，可以用循环，直接判断queue的size是否不为0作为循环判断条件。
 * @author Claudius
 *
 */
public class PrintTreeFromUpToDown {
	private Queue<BinaryTreeNode> queue = new LinkedList<>();
	public void print(BinaryTreeNode root){
		if (root==null) {
			return;
		}
		queue.add(root);
		printQueue(queue);;
		
	}
	public void printQueue(Queue<BinaryTreeNode> queue) {
		// TODO Auto-generated constructor stub
		if (queue.size()!=0) {
			BinaryTreeNode node = queue.poll();
			System.out.println(node.value);
			if (node.leftSon!=null) {
				queue.add(node.leftSon);
			}
			if (node.rightSon!=null) {
				queue.add(node.rightSon);
			}
			printQueue(queue);
		}
	}
}
