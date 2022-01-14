package GeeksForGeeks.binary_search_tree.Add_all_greater_values_to_every_node_in_a_BST;

import util.Node;
import util.TreeTraversal;

public class AddAllGreaterValuesToEveryNodeInABST {

    // Apply Reverse In Order to the BST
    // modify the BST and return its root
    private static Node modify(Node root)
    {
        modifiedBST(root, 0);
        return root;
    }

    private static int modifiedBST(Node node, int prev) {
        if (node == null) {
            return 0;
        }
        int right = modifiedBST(node.getRight(), prev);

        // FOR RETURN PURPOSE
        int returnVal = node.getData() + right;

        // MODIFYING CURRENT NODE
        node.setData(node.getData() + prev + right);

        // ADDING LEFT SIDE
        int left = modifiedBST(node.getLeft(), node.getData());
        returnVal = returnVal + left;

        return returnVal;
    }

    public static void main(String[] args) {
        Node root1 = new Node(50);
        root1.setLeft(new Node(30));
        root1.setRight(new Node(70));

        root1.getLeft().setLeft(new Node(20));
        root1.getLeft().setRight(new Node(40));

        root1.getRight().setLeft(new Node(60));
        root1.getRight().setRight(new Node(80));

        System.out.println("Test Case 1 -");
        System.out.println("Input: \n");
        TreeTraversal.inOrder(root1);
        System.out.println();

        modify(root1);

        String root1Result = "350 330 300 260 210 150 80 ";
        System.out.println("Expected Result: \n" + root1Result);

        System.out.println("Actual result: ");
        TreeTraversal.inOrder(root1);

        System.out.println();
        System.out.println("------------------------------------------------");
        System.out.println();

        Node root2 = new Node(2);
        root2.setLeft(new Node(1));
        root2.setRight(new Node(5));

        root2.getRight().setLeft(new Node(4));
        root2.getRight().setRight(new Node(7));

        System.out.println("Test Case 2 -");
        System.out.println("Input: \n");
        TreeTraversal.inOrder(root2);
        System.out.println();

        modify(root2);

        String root2Result = "19 18 16 12 7 ";
        System.out.println("Expected Result: \n" + root2Result);

        System.out.println("Actual result: ");
        TreeTraversal.inOrder(root2);

        System.out.println();
        System.out.println("------------------------------------------------");
        System.out.println();
    }
}
