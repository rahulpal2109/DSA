package leetcode.trie._421_maximum_xor_of_two_numbers_in_an_array;

import java.util.Arrays;

class TrieT {
    TrieNode root;

    TrieT() {
        root = new TrieNode();
    }

    void add(String word) {
        if (word == null || word.isEmpty()) return;
        TrieNode node = root;
        for (char c: word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.isEOW = true;
    }

    boolean search(String word) {
        if (word == null || word.isEmpty()) return false;
        TrieNode node = root;
        for (char c: word.toCharArray()) {
            if (c == '.') {
                for (TrieNode n: node.children) {
                    if (n != null) {
                        return n.isEOW;
                    }
                }
            }
            if (node != null && node.children[c - 'a'] != null) {
                node = node.children[c - 'a'];
            } else {
                return false;
            }
        }
        if (node.isEOW) {
            return true;
        }
        return false;
    }
}

class TrieNode {
    TrieNode[] children;
    boolean isEOW;

    TrieNode() {
        children = new TrieNode[26];
        Arrays.fill(children, null);
    }
}

public class Solution {
    public static void main(String[] args) {
        System.out.println((int) 'a');
        System.out.println((int) 'A');

        TrieT trie = new TrieT();
        trie.add("rahul");
        trie.add("ram");

        //System.out.println(trie.search("rahul"));

        String s = "i.like.this.program.very.much";
        String[] arr = s.split(".");
        System.out.println("Size: " + arr.length);
    }
}
