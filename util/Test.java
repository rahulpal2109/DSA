package util;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        System.out.println("hello world");
        int[][] points = new int[3][3];
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
    }
}
