package GeeksForGeeks.binary_search.capacity_to_ship_packages_within_D_days;

/*
    Capacity To Ship Packages Within D Days

    https://practice.geeksforgeeks.org/problems/capacity-to-ship-packages-within-d-days/1#
    Medium

    Time Complexity: O(n log n)
    Expected Time Complexity: O(N*log(Sum of weights - max(list of weights))
    Space Complexity: O(1)
 */
public class CapacityToShipPackagesWithinDDays {
    static int leastWeightCapacity(int[] arr, int N, int D) {
        // get total weight
        int totalW = 0;
        for (int w: arr) {
            totalW += w;
        }
        // least weight capacity of boat -> 0 < capacity <= totalW
        int lowW = 1;
        int highW = totalW;
        int mid = 0;
        while (lowW < highW) {
            mid = (lowW + highW) / 2;
            if (isPossible(arr, N, D, mid, totalW)) {
                //System.out.println("Success: Mid: " + mid);
                highW = mid;
            } else {
                //System.out.println("Failed: Mid: " + mid);
                lowW = mid + 1;
            }
        }
        return lowW;
    }

    static boolean isPossible(int[] arr, int N, int D, int capacity, int totalW) {
        int i = 0;
        int days = 1;
        int totalSum = 0;
        //System.out.println("N: " + N + "; D: " + D + "; Capacity: " + capacity + "; totalW: " + totalW);
        while (i < N && days <= D) {
            int sumW = 0;

            while (i < N  && sumW + arr[i] <= capacity) {
                sumW += arr[i];

                //System.out.println("index: " + i + "; val: " + arr[i] + "; sumW: " + sumW);
                i++;
            }
            totalSum += sumW;
            //System.out.println("index: " + i + "; days: " + days);
            if (i == N && totalSum == totalW) {
                return true;
            }
            days++;
        }
        return false;
    }
}
