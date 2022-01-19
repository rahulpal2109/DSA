package util;

public class ListNode {

    int val;
    ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    static void print(ListNode node) {
        System.out.println("Printing Linked List");
        while (node != null) {
            System.out.print(node.getVal() + " ");
            node = node.getNext();
        }
        System.out.println();
    }
}
