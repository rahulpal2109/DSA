package GeeksForGeeks.tree.leaves_to_dll;

import util.Node;

/*
    Leaves to DLL

    https://practice.geeksforgeeks.org/problems/leaves-to-dll/1#
    Medium

    Expected Time Complexity: O(N)
    Expected Auxiliary Space: O(height of tree)
 */
public class LeavesToDLL {

    Node dllHead = new Node(-1);
    Node p = dllHead;

    // return the head of the DLL and remove those node from the tree as well.
    public Node convertToDLL(Node root)
    {
        calcDll(root);

        Node result = dllHead.getRight();
        result.setLeft(null);
        return result;
    }

    public boolean calcDll(Node node) {
        if (node == null) {
            return false;
        }
        if (node.getLeft() == null && node.getRight() == null) {
            p.setRight(node);
            node.setLeft(p);
            p = p.getRight();

            return true;
        }
        boolean lFlag = calcDll(node.getLeft());
        boolean rFlag = calcDll(node.getRight());
        if (lFlag) {
            node.setLeft(null);
        }
        if (rFlag) {
            node.setRight(null);
        }
        return false;
    }
}
