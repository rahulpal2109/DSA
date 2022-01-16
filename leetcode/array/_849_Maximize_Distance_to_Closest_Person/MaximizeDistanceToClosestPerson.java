package leetcode.array._849_Maximize_Distance_to_Closest_Person;

/*
    849. Maximize Distance to Closest Person

    https://leetcode.com/problems/maximize-distance-to-closest-person/
    Medium

    Time complexity: O()
    Space complexity: O()
 */
public class MaximizeDistanceToClosestPerson {
    private static int maxDistToClosest(int[] seats) {
        int result = 0;
        int diff = 0;
        int size = seats.length;
        for (int i = 0; i < size; i++) {
            if (seats[i] == 0) {
                diff++;
                result = Math.max(result, (diff+1)/2);
            } else {
                diff = 0;
            }
        }

        for (int i = 0; i < size; i++) {
            if (seats[i] == 1) {
                result = Math.max(result, i);
                break;
            }
        }

        for (int i = size - 1; i >= 0; i--) {
            if (seats[i] == 1) {
                result = Math.max(result, size - 1 - i);
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] seats1 = {1,0,0,0,1,0,1};
        assert maxDistToClosest(seats1) == 2;

        int[] seats2 = {1,0,0,0};
        assert maxDistToClosest(seats2) == 3;

        int[] seats3 = {0,1};
        assert maxDistToClosest(seats3) == 1;

        int[] seats4 = {0,0,1};
        assert maxDistToClosest(seats4) == 2;

        int[] seats5 = {0,1,0,0,0,0};
        assert maxDistToClosest(seats5) == 4;
    }
}
