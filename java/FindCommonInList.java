package question37;

/**
 * Created by Claudius on 2017/6/21.
 * 返回两个链表的第一个公共结点。
 * 查找两个链表的长度，分别为m，n，长链表先走m-n次，然后两个依次往后走
 * 如果遇到同一结点，则返回。
 */
public class FindCommonInList {
    public static void main() {

    }

    public Node find(Node one, Node two) {
        Node head1 = one;
        Node head2 = two;
        Node longList = one, shortList = two;
        int num, num1 = 0, num2 = 0;
        while (head1 != null) {
            num1++;
            head1 = head1.getNext();
        }
        while (head2 != null) {
            num2++;
            head2 = head2.getNext();
        }
        num = num1 - num2;
        if (num1 < num2) {
            longList = head2;
            shortList = head1;
            num = num2 - num1;
        }

        for (int i = 0; i < num; i++) {
            longList = longList.getNext();
        }

        for (int i = 0; longList != null && shortList != null; i++) {
            longList = longList.getNext();
            shortList = shortList.getNext();
            if (longList == shortList)
                return longList;
        }
        return null;
    }
}

class Node {
    private int value;
    private Node next;

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getValue() {

        return value;
    }

    public Node getNext() {
        return next;
    }
}