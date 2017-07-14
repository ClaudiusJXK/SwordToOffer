package question58;

/**
 * 给定一个二叉树和其中一个结点，找出中序遍历的下一个结点。
 * 该二叉树结点有指向父结点的指针
 * Created by Claudius on 2017/7/14.
 */
public class NextNode {
    public static void main(String[] args) {

    }

    /**
     * 该结点是父节点的左孩子：
     * 1、他有右子树，那么下一个是右子树的最左结点。
     * 2、他没有右子树，那么下一个是他的父节点
     * 该节点是父节点的右孩子：
     * 3、他有右子树，那么下一个是右子树的最左结点。
     * 4、他没有右子树，那么他需要一直向上找父节点，直到该节点为其父节点的左孩子
     *
     * @param node
     * @return
     */

    public static Node getNextNode(Node node) {
        if (node == null)
            return null;
        if (node.rightSon != null)
            return getLeftSon(node.rightSon);
        else if (node == node.father.leftSon)
            return node.father;
        else
            return getFatherIsLeft(node.father);
    }

    /**
     * 向左找，一直找到该节点的最左结点
     *
     * @param node
     * @return
     */
    public static Node getLeftSon(Node node) {
        if (node.leftSon != null)
            return getLeftSon(node.leftSon);
        else
            return node;
    }

    /**
     * 找到node的father结点，直到node是node.father的左结点，然后返回node.father
     *
     * @param node
     * @return
     */
    public static Node getFatherIsLeft(Node node) {
        if (node.father == null)
            return null;
        else if ( node == node.father.rightSon)
            return getFatherIsLeft(node.father);
        else
            return node.father;
    }
}

class Node {
    public int value;
    public Node father;
    public Node leftSon;
    public Node rightSon;

}
