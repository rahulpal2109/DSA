package leetcode.linked_list._142_linked_list_cycle_II;

import util.ListNode;

/*
    142. Linked List Cycle II

    https://leetcode.com/problems/linked-list-cycle-ii/
    Medium

    Time Complexity: O(n).
    Space Complexity: O(1).
 */
public class LinkedListCycleII {
    public static ListNode detectCycle(ListNode head) {
        ListNode slowP, fastP = null;
        slowP = fastP = head;
        boolean loop = false;
        if (head == null) {
            return null;
        }
        while (fastP.getNext() != null && fastP.getNext().getNext() != null) {
            fastP = fastP.getNext().getNext();
            slowP = slowP.getNext();

            if (fastP == slowP) {
                loop = true;
                break;
            }
        }
        if (loop) {
            slowP = head;
            while (slowP != null && fastP != null) {
                if (slowP == fastP) {
                    return slowP;
                }
                slowP = slowP.getNext();
                fastP = fastP.getNext();
            }
        }
        return null;
    }

    static void print(ListNode node) {
        System.out.println("Printing Linked List");
        while (node != null) {
            System.out.print(node.getVal() + " ");
            node = node.getNext();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(3);
        ListNode n1 = new ListNode(2);
        head1.setNext(n1);

        ListNode n2 = new ListNode(0);
        n1.setNext(n2);

        ListNode n3 = new ListNode(-4);
        n2.setNext(n3);

        n2.setNext(n1);

        //print(head1);

        //System.out.println(detectCycle(head1).getVal());

        assert detectCycle(head1).getVal() == 2;
    }

}
