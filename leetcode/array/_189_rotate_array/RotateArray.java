package leetcode.array._189_rotate_array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    189. Rotate Array

    https://leetcode.com/problems/rotate-array/
    Medium

    Time Complexity: O(n)
    Space Complexity: O(1)

    Logic:
    input:  [1,2,3,4,5,6,7]; k=3
    result: [5,6,7,1,2,3,4]

    1) Reverse entire array -> [7,6,5,4,3,2,1]
    2) Reverse start to k-1 -> [5,6,7,4,3,2,1]
    3) Reverse k to end     -> [5,6,7,1,2,3,4]
 */
public class RotateArray {
    private static void rotate(int[] nums, int k) {
        k = k % nums.length;

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length - 1);

        /*
        while (k-- > 0) {
            swapArr(nums);
        }
        */
    }

    private static void reverse(int[] arr, int start, int end) {
        if (arr == null || arr.length < 2) return;

        while (start < end) {
            int temp = arr[end];
            arr[end] = arr[start];
            arr[start] = temp;

            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4,5,6,7};
        rotate(nums1, 3);
        int[] op1 = {5,6,7,1,2,3,4};
        assert Arrays.equals(nums1, op1);

        int[] nums2 = {-1,-100,3,99};
        rotate(nums2, 2);
        int[] op2 = {3,99,-1,-100};
        assert Arrays.equals(nums2, op2);

    }

}
