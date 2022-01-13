package leetcode.array._452_Minimum_Number_of_Arrows_to_Burst_Balloons;

import java.util.Arrays;

/*
    452. Minimum Number of Arrows to Burst Balloons

    https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
    Medium

    Time complexity: O(N log N)
    Space complexity: O(1)
 */
public class MinimumNumberOfArrowsToBurstBalloons {
    public static void main(String[] args) {
        int[][] test1 = {{0,16},{2,8},{1,6},{7,12}};
        assert findMinArrowShots(test1) == 2;

        int[][] test2 = {{1,2},{3,4},{5,6},{7,8}};
        assert findMinArrowShots(test2) == 4;

        int[][] test3 = {{1,2},{2,3},{3,4},{4,5}};
        assert findMinArrowShots(test3) == 2;
    }

    public static int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int end = points[0][1];
        int arrows = 1;

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) {
                arrows++;
                end = points[i][1];
            }
        }
        return arrows;
    }
}
