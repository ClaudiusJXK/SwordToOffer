package question39;

/**
 * Created by Claudius on 2017/6/27..
 * 1、查询一棵树的深度
 * 2、判断一棵树是否是平衡二叉树
 */
public class DepthOfBinaryTree {
    private static boolean flag = true;

    public static void main(String[] args) {
        BinaryTreeNode father = new BinaryTreeNode(8);
        BinaryTreeNode fatherSon2 = new BinaryTreeNode(8);
        BinaryTreeNode fatherSon3 = new BinaryTreeNode(7);
        father.leftSon = fatherSon2;
        father.rightSon = fatherSon3;
        BinaryTreeNode fatherSon4 = new BinaryTreeNode(9);
        BinaryTreeNode fatherSon5 = new BinaryTreeNode(2);
        fatherSon2.leftSon = fatherSon4;
        fatherSon2.rightSon = fatherSon5;
        BinaryTreeNode fatherSon6 = new BinaryTreeNode(4);
        BinaryTreeNode fatherSon7 = new BinaryTreeNode(7);
        fatherSon5.leftSon = fatherSon6;
        fatherSon5.rightSon = fatherSon7;


        ifBalanceSerTree(father);
        System.out.print(flag);
    }

    /**
     * 通过递归，先查看该节点的左子树和右子树的深度，然后返回较大深度+1即为当前结点的开始的深度。
     *
     * @param root
     * @return
     */
    public static int TreeDepth(BinaryTreeNode root) {
        if (root == null)
            return 0;
        int left = TreeDepth(root.leftSon);
        int right = TreeDepth(root.rightSon);
        return left > right ? (left + 1) : (right + 1);
    }

    /**
     * 后序递归，查看左子树和右子树的深度，然后比较二者差值多大
     * 如果超过1，则flag设置为false;
     * @param node
     * @return
     */
    public static int ifBalanceSerTree(BinaryTreeNode node) {
        //当前结点为空，则深度为0
        if (node == null)
            return 0;
        int left, right;
        if (flag) {
            //左子树的深度
            left = ifBalanceSerTree(node.leftSon);
            //右子树的深度
            right = ifBalanceSerTree(node.rightSon);

            //比较二者差值，判断其是否为平衡二叉树
            int diff = left - right;
            if (diff > 1 || diff < -1)
                flag = false;
            //返回最大深度
            return left > right ? left + 1 : right + 1;
        }
        return -1;
    }
}
