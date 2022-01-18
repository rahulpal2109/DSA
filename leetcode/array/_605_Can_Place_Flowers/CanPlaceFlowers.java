package leetcode.array._605_Can_Place_Flowers;

/*
    605. Can Place Flowers

    https://leetcode.com/problems/can-place-flowers/
    Easy

 */
public class CanPlaceFlowers {
    private static boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length && n > 0; i++) {
            if (flowerbed[i] == 0) {
                if (flowerbed.length == 1) {
                    flowerbed[i] = 1;
                    n--;
                } else if(i == 0) {
                    if (flowerbed[i+1] == 0) {
                        flowerbed[i] = 1;
                        n--;
                    }
                } else if (i == flowerbed.length - 1) {
                    if (flowerbed[i - 1] == 0) {
                        flowerbed[i] = 1;
                        n--;
                    }
                } else {
                    if (flowerbed[i-1] == 0 && flowerbed[i+1] == 0) {
                        flowerbed[i] = 1;
                        n--;
                    }
                }
            }
        }

        if (n == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] flowerbed1 = {1,0,0,0,1};
        assert canPlaceFlowers(flowerbed1, 1);

        int[] flowerbed2 = {1,0,0,0,1};
        assert !canPlaceFlowers(flowerbed2, 2);

        int[] flowerbed3 = {0,0,1,0,0};
        assert !canPlaceFlowers(flowerbed2, 1);
    }
}
