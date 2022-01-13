package GeeksForGeeks.queue.Reverse_First_K_Elements;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
    Reverse First K elements of Queue

    https://practice.geeksforgeeks.org/problems/reverse-first-k-elements-of-queue/1
    Easy

    Time complexity  - O(n+k)
    Space complexity - O(k)
 */
public class ReverseFirstKElements {
    public static void main(String[] args) {
        Queue<Integer> testQueue = new LinkedList<>();
        for (int i = 1; i <= 10; i++) {
            testQueue.offer(i * 10);
        }
        Queue<Integer> queue = modifyQueue(testQueue, 5);
        System.out.println("Original Q: " + testQueue);
        System.out.println("Modified Q: " + queue);
    }

    public static Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        Stack<Integer> stack = new Stack();
        int otherElements = q.size() - k;
        while (k-- >0) {
            stack.push(q.poll());
        }
        while (!stack.isEmpty()) {
            q.offer(stack.pop());
        }
        while (otherElements-- > 0) {
            q.offer(q.poll());
        }
        return q;
    }
}
