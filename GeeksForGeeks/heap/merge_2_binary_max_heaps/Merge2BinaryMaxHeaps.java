package GeeksForGeeks.heap.merge_2_binary_max_heaps;

/*
    Merge two binary Max heaps

    https://practice.geeksforgeeks.org/problems/merge-two-binary-max-heap0144/1
    Easy

    Time complexity: O(N Log N)
    Space complexity: O(n+m)
 */
public class Merge2BinaryMaxHeaps {
    public static int[] mergeHeaps(int[] a, int[] b, int n, int m) {
        // your code here
        int[] merged = new int[m + n];

        mergeHeapsImpl(merged, a, b, n, m);
        return merged;
    }

    public static void maxHeapify(int[] arr, int n,
                                  int i)
    {
        // Find largest of node and its children
        if (i >= n) {
            return;
        }
        int l = i * 2 + 1;
        int r = i * 2 + 2;
        int max;
        if (l < n && arr[l] > arr[i]) {
            max = l;
        }
        else
            max = i;
        if (r < n && arr[r] > arr[max]) {
            max = r;
        }

        // Put maximum value at root and
        // recur for the child with the
        // maximum value
        if (max != i) {
            int temp = arr[max];
            arr[max] = arr[i];
            arr[i] = temp;
            maxHeapify(arr, n, max);
        }
    }

    // Merges max heaps a[] and b[] into merged[]
    public static void mergeHeapsImpl(int[] arr, int[] a,
                                      int[] b, int n, int m)
    {
        for (int i = 0; i < n; i++) {
            arr[i] = a[i];
        }
        for (int i = 0; i < m; i++) {
            arr[n + i] = b[i];
        }
        n = n + m;

        // Builds a max heap of given arr[0..n-1]
        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeapify(arr, n, i);
        }
    }

    public static void main(String[] args) {
        int[] a = {10, 5, 6, 2};
        int[] b = {12, 7, 9};
        System.out.println("a: ");
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();

        System.out.println("b: ");
        for (int i = 0; i < b.length; i++)
            System.out.print(b[i] + " ");
        System.out.println();


        int[] merged = mergeHeaps(a, b, a.length, b.length);
        System.out.println("Merged: ");
        for (int i = 0; i < a.length + b.length; i++)
            System.out.print(merged[i] + " ");
        System.out.println();
    }
}
