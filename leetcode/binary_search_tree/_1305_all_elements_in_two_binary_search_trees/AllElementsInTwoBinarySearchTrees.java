package leetcode.binary_search_tree._1305_all_elements_in_two_binary_search_trees;

import util.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
    1305. All Elements in Two Binary Search Trees

    https://leetcode.com/problems/all-elements-in-two-binary-search-trees/
    Medium

    Time Complexity: O()
    Space Complexity: O()
 */
public class AllElementsInTwoBinarySearchTrees {
    private static List<Integer> getAllElements(Node root1, Node root2) {
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();

        List<Integer> res = new ArrayList<>();

        while(root1 != null || root2 != null || !st1.empty() || !st2.empty()){
            while(root1 != null){
                st1.push(root1);
                root1 = root1.getLeft();
            }
            while(root2 != null){
                st2.push(root2);
                root2 = root2.getLeft();
            }
            if(st2.empty() || (!st1.empty() && st1.peek().getData() <= st2.peek().getData())){
                root1 = st1.pop();
                res.add(root1.getData());
                root1 = root1.getRight();
            }
            else{
                root2 = st2.pop();
                res.add(root2.getData());
                root2 = root2.getRight();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Node root1 = new Node(2);
        root1.setLeft(new Node(1));
        root1.setRight(new Node(4));

        Node root2 = new Node(1);
        root2.setLeft(new Node(0));
        root2.setRight(new Node(3));

        ArrayList<Integer> result1 = new ArrayList<>(Arrays.asList(0,1,1,2,3,4));
        assert getAllElements(root1, root2).equals(result1);
    }
}
