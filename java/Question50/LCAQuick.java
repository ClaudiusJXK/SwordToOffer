package Question50;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Claudius on 2017/7/12.
 */
public class LCAQuick {
    private static List<Tree> path1;
    private static List<Tree> path2;
    private static boolean flag1 = false;
    private static boolean flag2 = false;

    public static void main(String[] args) {
        path1 = new LinkedList<>();
        path2 = new LinkedList<>();

        Tree head = buildTree(20);

        findPath(head, new Tree(10), new Tree(7));

        Tree node = findLCSByList();
        if (node != null)
            System.out.print(node.getValue());

    }

    /**
     * 寻找两个target的path
     * flag标志表示是否找到。
     * 使用先序遍历方式，如果没找到，则当前结点加入path，该节点返回时仍未找到，remove该节点。
     * 如果找到了，则不再加入path。
     *
     * @param node
     * @param target1
     * @param target2
     */
    public static void findPath(Tree node, Tree target1, Tree target2) {
        if (node == null || (flag1 && flag2))
            return;

        //如果没找到，当前结点加入path
        if (!flag1) {
            path1.add(node);
            if (node.getValue() == target1.getValue()) {
                flag1 = true;
            }
        }

        if (!flag2) {
            path2.add(node);
            if (node.getValue() == target2.getValue())
                flag2 = true;
        }

        //找左子节点
        findPath(node.getLeft(), target1, target2);

        //找右子节点
        findPath(node.getRight(), target1, target2);

        //如果仍未找到，说明当前结点及其子节点不包含target，则返回时移除该节点
        if (!flag1) {
            path1.remove(node);
        }
        if (!flag2) {
            path2.remove(node);
        }

    }


    public static Tree findLCSByList() {
        Iterator<Tree> iterator1 = path1.iterator();
        Iterator<Tree> iterator2 = path2.iterator();
        Tree preNode = null;
        while (iterator1.hasNext() && iterator2.hasNext()) {
            Tree node1 = iterator1.next();
            Tree node2 = iterator2.next();
            if (node1.getValue() == node2.getValue()) {
                preNode = node1;
            } else
                break;
        }
        return preNode;
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
