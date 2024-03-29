package GeeksForGeeks.graph.steps_by_knight;

import java.util.Vector;

/*
    Steps by Knight

    https://practice.geeksforgeeks.org/problems/steps-by-knight5927/1#
    Medium

    Time Complexity: O(N^2)
    Space Complexity: O(N^2)

    Ref:
    1. https://www.geeksforgeeks.org/minimum-steps-reach-target-knight/
    2. https://www.youtube.com/watch?v=ce4vjUVfrhU
 */
public class StepsByKnight {
    // Class for storing a cell's data
    static class cell {
        int x, y;
        int dis;

        public cell(int x, int y, int dis)
        {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }

    // Utility method returns true if (x, y) lies
    // inside Board
    private static boolean isInside(int x, int y, int N)
    {
        if (x >= 1 && x <= N && y >= 1 && y <= N)
            return true;
        return false;
    }

    //Function to find out minimum steps Knight needs to reach target position.
    private static int minStepToReachTarget(int knightPos[], int targetPos[], int N)
    {
        // Code here
        // x and y direction, where a knight can move
        int dx[] = { -2, -1, 1, 2, -2, -1, 1, 2 };
        int dy[] = { -1, -2, -2, -1, 1, 2, 2, 1 };

        // queue for storing states of knight in board
        Vector<cell> q = new Vector<>();

        // push starting position of knight with 0 distance
        q.add(new cell(knightPos[0], knightPos[1], 0));

        cell t;
        int x, y;
        boolean visit[][] = new boolean[N + 1][N + 1];

        // make all cell unvisited
        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= N; j++)
                visit[i][j] = false;

        // visit starting state
        visit[knightPos[0]][knightPos[1]] = true;

        // loop until we have one element in queue
        while (!q.isEmpty()) {
            t = q.firstElement();
            q.remove(0);

            // if current cell is equal to target cell,
            // return its distance
            if (t.x == targetPos[0] && t.y == targetPos[1])
                return t.dis;

            // loop for all reachable states
            for (int i = 0; i < 8; i++) {
                x = t.x + dx[i];
                y = t.y + dy[i];

                // If reachable state is not yet visited and
                // inside board, push that state into queue
                if (isInside(x, y, N) && !visit[x][y]) {
                    visit[x][y] = true;
                    q.add(new cell(x, y, t.dis + 1));
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        int boardSize = 6;
        int[] knightPos1 = {4, 5};
        int[] targetPos1 = {1, 1};

        int steps1 = minStepToReachTarget(knightPos1,targetPos1, boardSize);
        assert steps1 == 3;
    }
}
