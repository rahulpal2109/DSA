package leetcode.array._566_reshape_the_matrix;

/*
    566. Reshape the Matrix

    https://leetcode.com/problems/reshape-the-matrix/
    Easy

    Using temp 1D array:
        Time Complexity: O(2 * row * col) -> ~O(row * col)
        Space Complexity: O(row*col)

    Without Using temp 1D array:
        Time Complexity: O(row * col)
        Space Complexity: O(1)
 */
public class ReshapeTheMatrix {
    private static int[][] usingExtraSpace(int[][] mat, int r, int c) {

        int rows = mat.length;
        int cols = mat[0].length;

        if (rows*cols != r*c) return mat;
        if (rows==r && cols==c) return mat;

        // convert to temp 1D array
        int k = 0;
        int[] temp = new int[rows*cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                temp[k++] = mat[i][j];
            }
        }

        // convert from 1D array to result
        k = 0;
        int[][] result = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                result[i][j] = temp[k++];
            }
        }

        return result;
    }

    private static int[][] withoutExtraSpace(int[][] mat, int r, int c) {
        // Better approach without using 1D array
        int rows = mat.length;
        int cols = mat[0].length;

        if (rows*cols != r*c) return mat;
        if (rows==r && cols==c) return mat;

        int[][] result = new int[r][c];
        for (int i=0; i < rows*cols; i++) {
            result[i / c][i % c] = mat[i / cols][i % cols];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Test case 1: ");
        int[][] mat1 = {{1,2}, {3,4}};
        usingExtraSpace(mat1, 1, 4);
        withoutExtraSpace(mat1, 1, 4);
        System.out.println("Expected output");
        System.out.println("[[1,2,3,4]]");
        System.out.println();

        System.out.println("Test case 2: ");
        int[][] mat2 = {{1,2}, {3,4}};
        usingExtraSpace(mat2, 2, 4);
        withoutExtraSpace(mat2, 2, 4);
        System.out.println("Expected output");
        System.out.println("[[1,2],[3,4]]");
    }
}
