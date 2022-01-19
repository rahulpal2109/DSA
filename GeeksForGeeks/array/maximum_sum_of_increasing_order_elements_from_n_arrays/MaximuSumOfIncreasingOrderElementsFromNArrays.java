package GeeksForGeeks.array.maximum_sum_of_increasing_order_elements_from_n_arrays;

/*
    Maximum sum of increasing order elements from n arrays

    https://practice.geeksforgeeks.org/problems/maximum-sum-of-increasing-order-elements-from-n-arrays4848/1
    Easy

    Time Complexity: O(n*m)
    Space Complexity: O(1)
 */
public class MaximuSumOfIncreasingOrderElementsFromNArrays {
    private static int maximumSum (int n, int m, int arr[][]) {
        boolean found = false;
        int result = 0;

        int max = Integer.MAX_VALUE;

        for (int i = n - 1; i >= 0; i--) {
            int tempMax = Integer.MIN_VALUE;
            for (int j = 0; j < m; j++) {
                if (arr[i][j] < max && arr[i][j] > tempMax) {
                    tempMax = arr[i][j];
                }
            }
            if (tempMax == Integer.MIN_VALUE) {
                return 0;
            }
            result += tempMax;
            max = tempMax;
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] arr1 = {{1,7,4,3}, {4,2,5,1}, {9,5,1,8}};
        assert maximumSum(3, 4, arr1) == 18;

        int[][] arr2 = {{9,8,7}, {6,5,4}, {3,2,1}};
        assert maximumSum(3, 3, arr2) == 0;
    }
}
