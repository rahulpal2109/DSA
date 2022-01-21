package leetcode.array._134_Gas_Station;

/*
    134. Gas Station

    https://leetcode.com/problems/gas-station/
    Medium

    Time Complexity: O(n)
    Space Complexity: O(1)
 */
public class GasStation {
    private static int canCompleteCircuit(int[] gas, int[] cost) {
        int size = gas.length;
        for (int i=0; i < size; i++) {
            int totalFuel = 0;
            int count = 0;
            int j = i;
            while (count < size) {
                totalFuel += gas[j%size] - cost[j%size];
                if (totalFuel < 0) {
                    // optimization to not iterate over all i values as in case of brute force
                    // in case there is a deficit, it means if started at all previous indices from start till current
                    // it will still be a deficit. So, ignoring those indices for prospective starts.
                    i = j;

                    break;
                }
                count++;
                j++;
            }
            if (count == size && totalFuel >= 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] gas1 = {1,2,3,4,5};
        int[] cost1 = {3,4,5,1,2};

        assert canCompleteCircuit(gas1, cost1) == 3;

        int[] gas2 = {2,3,4};
        int[] cost2 = {3,4,3};

        assert canCompleteCircuit(gas2, cost2) == -1;
    }
}
