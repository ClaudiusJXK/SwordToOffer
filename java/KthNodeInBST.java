package question63;

/**
 * 二叉搜索树的第K个结点
 * 对二叉搜索树进行中序遍历，返回第k个遍历点
 * Created by Claudius on 2017/7/15.
 */
public class KthNodeInBST {
    private static int k = 3;

    public static void main(String[] args) {

    }

    public static TreeNode findKthNode(TreeNode root) {
        TreeNode node = null;
        if (root.leftSon != null) {
            node = findKthNode(root.leftSon);
        }
        if (node == null) {
            k--;
            if (k == 0) {
                return root;
            }
        }
        if (node != null && node.rightSon != null) {
            node = findKthNode(root.rightSon);
        }
        return node;

    }
}

class TreeNode {
    int value;
    TreeNode leftSon;
    TreeNode rightSon;
}
