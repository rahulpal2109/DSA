package leetcode.trie._421_maximum_xor_of_two_numbers_in_an_array;

import java.util.HashMap;

/*
    421. Maximum XOR of Two Numbers in an Array

    https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/
    Medium

    Time Complexity: O()
    Space Complexity: O()
 */
public class MaximumXOROfTwoNumbersInAnArray {
    private static int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();
        trie.insert(nums);

        int max = 0;

        for(int num : nums) {
            Node curr = trie.root;
            int currSum = 0;
            for(int i=31;i>=0;i--) {
                int requiredBit = 1-((num >> i) & 1); // if A[i] is 0, we need 1 and if A[i] is 1, we need 0. Thus, 1 - A[i]
                if(curr.children.containsKey(requiredBit)) {
                    currSum |= (1<<i); // set ith bit of curr result
                    curr = curr.children.get(requiredBit);
                } else {
                    curr = curr.children.get(1-requiredBit);
                }
            }
            max = Math.max(max, currSum); // get max number
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr1 = {3,10,5,25,2,8};
        assert findMaximumXOR(arr1) == 28;

        int[] arr2 = {14,70,53,83,49,91,36,80,92,51,66,70};
        assert findMaximumXOR(arr2) == 127;
    }
}

class Node {
    HashMap<Integer, Node> children;
    Node() {
        this.children = new HashMap<>();
    }

}

class Trie {
    Node root;

    Trie() {
        this.root = new Node();
    }

    public void insert(int[] A) {
        for(int num : A) {
            Node curr = this.root;
            for(int i=31;i>=0;i--) {
                int currBit = (num >> i) & 1;
                if(!curr.children.containsKey(currBit))
                    curr.children.put(currBit, new Node());
                curr = curr.children.get(currBit);
            }
        }
    }
}