package GeeksForGeeks.tree.maximum_sum_of_non_adjacent_nodes;

import util.Node;
import util.TreeTraversal;

/*
    Maximum sum of Non-adjacent nodes

    https://practice.geeksforgeeks.org/problems/maximum-sum-of-non-adjacent-nodes/1#
    Medium

 */
public class MaximumSumOfNonAdjacentNodes {
    static Pair getMaxSumHelper(Node node) {
        if (node == null) {
            return new Pair(0, 0);
        }
        Pair pair1 = getMaxSumHelper(node.getLeft());
        Pair pair2 = getMaxSumHelper(node.getRight());

        Pair pair = new Pair(0,0);
        pair.first = node.getData() + pair1.second + pair2.second;
        pair.second = Math.max(pair1.first, pair1.second) +
                Math.max(pair2.first, pair2.second);

        return pair;
    }

    //Function to return the maximum sum of non-adjacent nodes.
    static int getMaxSum(Node root)
    {
        Pair p = getMaxSumHelper(root);
        return Math.max(p.first, p.second);
    }

    static class Pair {
        int first;
        int second;

        public Pair(int a, int b) {
            this.first = a;
            this.second = b;
        }
    }

    public static void main(String[] args) {
        Node root1 = new Node(1);
        root1.setLeft(new Node(2));
        root1.setRight(new Node(3));

        root1.getLeft().setLeft(new Node(1));

        root1.getRight().setLeft(new Node(4));
        root1.getRight().setRight(new Node(5));

        System.out.println("Test Case 1 -");
        System.out.println("Input: \n");
        TreeTraversal.inOrder(root1);
        System.out.println();

        int result = getMaxSum(root1);
        System.out.println("Output: " + result);
        assert result == 11;

        System.out.println();
        System.out.println("------------------------------------------------");
        System.out.println();

    }
}
