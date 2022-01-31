package GeeksForGeeks.array.coins_of_geekland;

/*
    Coins of Geekland

    https://practice.geeksforgeeks.org/problems/257a9e27fb3e58255622c8dcb06e0919cc1c6c11/1
    Medium

    Time Complexity: O()
    Space Complexity: O()
 */
public class CoinsOfGeekland {
    private static int maximumSum(int[][] arr, int N, int subGridSize) {
        int max = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                //System.out.println("i = " + i + "; j = " + j);
                sum = 0;
                int k = subGridSize;

                for (int p = i; p < arr.length && k > 0; k--, p++) {
                    int l = subGridSize;
                    for (int q = j; q < arr[i].length && l > 0; l--, q++) {
                        //System.out.println("p = " + p + "; q = " + q + "; sum= " + sum);
                        sum += arr[p][q];
                    }
                }
                //System.out.println("i = " + i + "; j = " + j + "; total sum= " + sum);
                max = Math.max(max, sum);
                //System.out.println();
            }
        }

        return max;
    }

    private static int maximumSumOptimized(int mat[][],int N,int k){
        int[][] sum = new int[N][N];
        sum[0][0] = mat[0][0];

        // pre-process first row
        for (int j = 1; j < N; j++) {
            sum[0][j] = mat[0][j] + sum[0][j - 1];
        }

        // pre-process first column
        for (int i = 1; i < N; i++) {
            sum[i][0] = mat[i][0] + sum[i - 1][0];
        }

        // pre-process rest of the matrix
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                sum[i][j] = mat[i][j] + sum[i - 1][j] + sum[i][j - 1]
                        - sum[i - 1][j - 1];
            }
        }

        int total, max = Integer.MIN_VALUE;


        // find maximum sum sub-matrix

        // start from cell (k — 1, k — 1) and consider each
        // submatrix of size k x k
        for (int i = k - 1; i < N; i++)
        {
            for (int j = k - 1; j < N; j++)
            {
                // Note (i, j) is bottom right corner coordinates of
                // square sub-matrix of size k

                total = sum[i][j];
                if (i - k >= 0) {
                total = total - sum[i - k][j];
            }

                if (j - k >= 0) {
                total = total - sum[i][j - k];
            }

                if (i - k >= 0 && j - k >= 0) {
                total = total + sum[i - k][j - k];
            }

                if (total > max) {
                    max = total;

                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] arr1 = { {1, 1, 1, 1, 1},
                {2, 2, 2, 2, 2},
                {3, 8, 6, 7, 3},
                {4, 4, 4, 4, 4},
                {5, 5, 5, 5, 5}};
        int[][] arr2 = {{4}};

        // print 2D array
        /*for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }*/

        assert maximumSum(arr1, arr1.length, 3) == 48;
        assert maximumSum(arr2, arr2.length, 1) == 4;

        assert maximumSumOptimized(arr1, arr1.length, 3) == 48;
        assert maximumSumOptimized(arr2, arr2.length, 1) == 4;
    }
}
