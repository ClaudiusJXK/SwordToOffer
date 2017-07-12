package Question50;

/**
 * 树中两个节点的最低公共祖先，本办法找
 * Created by Claudius on 2017/7/11.
 */
public class LCA {
    public static void main(String[] args) {
        Tree node = buildTree(20);
        Tree target1 = new Tree();
        Tree target2 = new Tree();
        target1.setValue(3);
        target2.setValue(11);
        //先判断根节点是否包含两个目标点，若是则进行find递归
        int num = Traverse(node, target1, target2, 0);
        if (num == 2)
            System.out.print(find(node, target1, target2).getValue());
    }

    /**
     * 从根节点开始，已知node包含这两个target值，
     * 则遍历其两个子节点是否某一个子节点只包含一个，（考虑到：如果两个点中，其中一个结点为另一个结点的父节点）
     * 如果不是，则遍历其包含两个的结点的子节点。
     *
     * @param node node及其子树包含这两个值
     * @return
     */
    public static Tree find(Tree node, Tree target1, Tree target2) {
        int num1 = Traverse(node.getLeft(), target1, target2, 0);
        int num2 = Traverse(node.getRight(), target1, target2, 0);
        if (num1 == 1 || num2 == 1)
            return node;
        else if (num1 == 2)
            return find(node.getLeft(), target1, target2);
        else
            return find(node.getLeft(), target1, target2);

    }

    /**
     * 中序遍历查找结点数量
     *
     * @param node    根节点
     * @param target1 目标值1
     * @param target2 目标值2
     * @param num     已找到几个目标值
     * @return 返回当前node情况找到的目标值
     */
    public static int Traverse(Tree node, Tree target1, Tree target2, int num) {
        if (node == null || num == 2)
            return num;
        num = Traverse(node.getLeft(), target1, target2, num);
        if (node.getValue() == target1.getValue() || node.getValue() == target2.getValue())
            num++;
        num = Traverse(node.getRight(), target1, target2, num);
        return num;
    }

    /**
     * 建树   保证一定是奇数才能建树，而且每个树节点的value不同。
     * 0
     * 1          2
     * 3   4     5     6
     * 7 8 9 10 11 12 13 14
     *
     * @return
     */
    public static Tree buildTree(int n) {
        Tree[] trees = new Tree[n + 1];
        for (int i = 0; i <= n; i++) {
            trees[i] = new Tree();
            trees[i].setValue(i);
        }
        for (int i = (n - 1) / 2; i >= 0; i--) {
            trees[i].setLeft(trees[i * 2 + 1]);
            trees[i].setRight(trees[i * 2 + 2]);
        }
        return trees[0];
    }

}
