package question61;


import java.util.*;

/**
 * 按照之字形打印二叉树
 * 1
 * 2 3
 * 4 5 6 7
 * 8 9 10 11 12 13 14 15
 * 打印结果为
 * 1
 * 3 2
 * 4 5 6 7
 * 15 14 13 12 11 10 9 8
 * Created by Claudius on 2017/7/14.
 */
public class PrintTreeInSpecialWay {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        /**
         * 使用队列进行二叉树构建
         * 队列中存储根节点，一出队，则新建两个树节点赋值给根节点的左右孩子，然后将两个孩子入队。
         * 即：父节点出队，新建两个子节点并入队。
         */
        TreeNode root = new TreeNode(1);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        for (int i = 2; i <= 10; i++) {
            int num1 = in.nextInt();
            int num2 = in.nextInt();
            TreeNode node = queue.poll();
            node.leftSon = new TreeNode(num1);
            node.rightSon = new TreeNode(num2);

            queue.add(node.leftSon);
            queue.add(node.rightSon);
        }

        //执行打印
        print(root);
    }

    /**
     * 根据例子，可以使用两个栈实现
     * 父节点一层为一个栈，子节点一层为一个栈
     * 并记录层数。
     * 逆序父层的孩子结点入栈的时候，记得颠倒左右子树的存入顺序即可。
     *
     * @param root
     */
    public static void print(TreeNode root) {
        if (root == null)
            return;
        ArrayDeque<TreeNode> stackFather = new ArrayDeque<>();
        ArrayDeque<TreeNode> stackSon = new ArrayDeque<>();
        stackFather.addFirst(root);
        int lineNum = 0;   //用该值记录行数，从而判断入栈时是左孩子还是右孩子先入栈
        while (!stackFather.isEmpty()) {
            TreeNode node = stackFather.poll();
            System.out.print(node.value + " ");

            if (lineNum % 2 == 0) {
                if (node.leftSon != null)
                    stackSon.addFirst(node.leftSon);
                if (node.rightSon != null)
                    stackSon.addFirst(node.rightSon);
            } else {
                if (node.rightSon != null)
                    stackSon.addFirst(node.rightSon);
                if (node.leftSon != null)
                    stackSon.addFirst(node.leftSon);
            }

            //父栈为空，则交换父子栈，并输出换行
            if (stackFather.isEmpty()) {
                System.out.println();
                ArrayDeque<TreeNode> temp = stackSon;
                stackSon = stackFather;
                stackFather = temp;
                lineNum++;
            }
        }
    }

}

class TreeNode {
    TreeNode leftSon;
    TreeNode rightSon;
    int value;

    TreeNode(int value) {
        this.value = value;
    }

}