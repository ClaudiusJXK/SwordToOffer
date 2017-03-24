package pathOfBinaryTree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 输入一个数，然后查找所有叶子节点的路径，如果当前叶子节点的路径上所有结点和与该值相等，打印路径
 * 
 * 方法：先序遍历根结点，然后每遍历一个结点就给链表添加结点，并求sum，返回的时候删除这个结点。
 *     如果这个结点的左右孩子都是空，则其为叶子节点，然后进行判断，否则继续遍历其孩子结点
 * @author Claudius
 *
 */
public class Path {
	private static List<BinaryTreeNode> nodesList= new LinkedList<>();
	public static void print(List<BinaryTreeNode> nodes){
		if (nodes == null || nodes.size() == 0) {
			return;
		}
		Iterator<BinaryTreeNode> iter = nodes.iterator();
		while(iter.hasNext()){
			BinaryTreeNode node = iter.next();
			System.out.print(node.value + " ");
		}
		System.out.println();
	}
	public static void traverse(BinaryTreeNode node ,int sum ,int expect) {
		if (node == null) {
			return;
		}
		/**
		 * 添加当前结点，和增加
		 */
		nodesList.add(node);
		sum+= node.value;
		/**
		 * 当前结点不为叶子节点时，进行孩子结点的递归
		 * 如果是叶子节点，则进行判断
		 */
		if (node.leftSon != null || node.rightSon != null){
			if (node.leftSon != null) {
				traverse(node.leftSon , sum ,expect);
			}
			if (node.rightSon != null) {
				traverse(node.rightSon,sum,expect);
			}
		}else if (sum == expect) {
			print(nodesList);
		}
		//最后返回时从链表删除这个结点
		nodesList.remove(node);
	}
	public static void main(String [] args) {
		BinaryTreeNode father = new BinaryTreeNode(8); 
		BinaryTreeNode fatherSon2 = new BinaryTreeNode(8);
		BinaryTreeNode fatherSon3 = new BinaryTreeNode(7);
		father.leftSon= fatherSon2;
		father.rightSon = fatherSon3;
		BinaryTreeNode fatherSon4 = new BinaryTreeNode(9);
		BinaryTreeNode fatherSon5 = new BinaryTreeNode(2);
		fatherSon2.leftSon = fatherSon4;
		fatherSon2.rightSon = fatherSon5;
		BinaryTreeNode fatherSon6 = new BinaryTreeNode(4);
		BinaryTreeNode fatherSon7 = new BinaryTreeNode(7);
		fatherSon5.leftSon = fatherSon6;
		fatherSon5.rightSon = fatherSon7;

		
		traverse(father, 0, 22);
	}
}
