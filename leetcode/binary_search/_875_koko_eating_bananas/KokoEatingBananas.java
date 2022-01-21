package leetcode.binary_search._875_koko_eating_bananas;

/*
    875. Koko Eating Bananas

    https://leetcode.com/problems/koko-eating-bananas/
    Medium

    Brute force:
        Time Complexity: O(n*m)
            n -> length of input array
            m -> max height of a pile
        Space Complexity: O(1)

    Binary Search:
        Time Complexity: O(n log m)
            n -> length of input array
            m -> max height of a pile
        Space Complexity: O(1)
 */
public class KokoEatingBananas {
    private static int minEatingSpeedBinarySearch(int[] piles, int h) {
        if (piles.length == 1 && h == 1) return 1;

        int speedMin = 1;
        int speedMax = 1;
        int sum = 0;
        for (int pile : piles) {
            speedMax = Math.max(speedMax, pile);
            sum += pile;
        }
        // Mathematically, minimum speed has to be the average speed of eating all piles
        // Koko can never finish eating all piles if speed < avg speed.
        speedMin = (int) Math.ceil((double)sum/h);
        int speed = getNextSpeed(speedMin, speedMax);
        // Binary Search impl
        while (speedMin < speedMax) {
            int hours = 0;
            int i=0;

            for (int pile : piles) {
                // typecast to double to prevent lossy transformation.
                // As ceil is involved, might give wrong result.
                hours += Math.ceil((double)pile/speed);
                // Early termination of loop
                if (hours > h) {
                    break;
                }
            }
            if (hours > h) {
                speedMin = speed + 1;
                speed = getNextSpeed(speedMin, speedMax);
            } else {
                speedMax = speed;
                speed = getNextSpeed(speedMin, speedMax);
            }
        }
        return speedMin;
    }

    private static int minEatingSpeedBruteForce(int[] piles, int h) {
        if (piles.length == 1 && h == 1) return 1;

        int speed = 1;
        while (true) {
            int hours = 0;
            int i=0;
            //System.out.println("hours = " + hours + "; speed = " + speed);
            while (i < piles.length) {
                int val = piles[i];
                while (val > 0) {
                    val -= speed;
                    hours++;
                }
                i++;
            }
            //System.out.println("hours = " + hours);
            if (hours > h) {
                speed++;
            } else {
                break;
            }
        }
        return speed;
    }

    private static int getNextSpeed(int left, int right) {
        return (left+right)/2;
    }

    public static void main(String[] args) {
        int[] piles1 = {3,6,7,11};
        assert minEatingSpeedBruteForce(piles1, 8) == 4;
        assert minEatingSpeedBinarySearch(piles1, 8) == 4;

        int[] piles2 = {30,11,23,4,20};
        assert minEatingSpeedBruteForce(piles2, 5) == 30;
        assert minEatingSpeedBinarySearch(piles2, 5) == 30;

        int[] piles3 = {30,11,23,4,20};
        assert minEatingSpeedBruteForce(piles3, 6) == 23;
        assert minEatingSpeedBinarySearch(piles3, 6) == 23;
    }
}
