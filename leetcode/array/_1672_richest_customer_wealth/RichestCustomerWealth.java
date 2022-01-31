package leetcode.array._1672_richest_customer_wealth;

/*
    1672. Richest Customer Wealth

    https://leetcode.com/problems/richest-customer-wealth/
    Easy

    Time Complexity: O(m*n)
    Space Complexity: O(1)
 */
public class RichestCustomerWealth {

    private static int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int i = 0; i < accounts.length; i++) {
            int sum = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                sum += accounts[i][j];
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] arr1 = {{1,2,3},{3,2,1}};
        assert maximumWealth(arr1) == 6;

        int[][] arr2 = {{1,5},{7,3},{3,5}};
        assert maximumWealth(arr2) == 10;

        int[][] arr3 = {{2,8,7},{7,1,3},{1,9,5}};
        assert maximumWealth(arr3) == 17;
    }
}
