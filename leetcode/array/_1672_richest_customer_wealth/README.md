# 1672. Richest Customer Wealth
### Easy

https://leetcode.com/problems/richest-customer-wealth/

You are given an m x n integer grid accounts where accounts[i][j] is the amount of money the i​​​​​​​​​​​th​​​​ customer has in the j​​​​​​​​​​​th​​​​ bank. Return the wealth that the richest customer has.

A customer's wealth is the amount of money they have in all their bank accounts. The richest customer is the customer that has the maximum wealth.

 

#### Example 1:

Input: 

accounts = [[1,2,3],[3,2,1]]

Output: 6

Explanation:

1st customer has wealth = 1 + 2 + 3 = 6

2nd customer has wealth = 3 + 2 + 1 = 6

Both customers are considered the richest with a wealth of 6 each, so return 6.


#### Example 2:

Input: accounts = [[1,5],[7,3],[3,5]]

Output: 10

Explanation: 

1st customer has wealth = 6

2nd customer has wealth = 10 

3rd customer has wealth = 8

The 2nd customer is the richest with a wealth of 10.


#### Example 3:

Input: 

accounts = [[2,8,7],[7,1,3],[1,9,5]]

Output: 17
 


### Constraints:

m == accounts.length

n == accounts[i].length

1 <= m, n <= 50

1 <= accounts[i][j] <= 100


## Solution

### Approach: Row Sum Maximum

The solution described above can be broken down into two steps:

Find the wealth of each customer and store it in a list.

Find and return the greatest wealth contained in the list.

#### Algorithm

1) Iterate over the customers i.e., accounts.
2) For each account in accounts, we iterate over the money deposited in different banks and add it to currCustomerWealth.
3) Compare currCustomerWealth with maxWealthSoFar. If currCustomerWealth is greater than maxWealthSoFar then update maxWealthSoFar.
4) Return maxWealthSoFar.

#### Complexity Analysis

Let MM be the number of customers and NN be the number of banks.

##### Time complexity: O(M * N)

For each of the MM customers, we need to iterate over all NN banks to find the sum of his/her wealth. Inside each iteration, operations like addition or finding maximum take O(1)O(1) time. Hence, the total time complexity is O(M \cdot N)O(M⋅N).

##### Space complexity: O(1)

We only need two variables currCustomerWealth and maxWealthSoFar to store the wealth of the current customer, and the highest wealth we have seen so far respectively. Therefore, the space complexity is constant.