package leetcode.misc._1291_sequential_digits;

import java.util.*;

/*
    1291. Sequential Digits

    https://leetcode.com/problems/sequential-digits/
    Medium

    Time complexity: O()
    Space complexity: O()
 */
public class SequentialDigits {
    private static List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        for (int digit = 1; digit < 9; ++digit) {
            int next = digit, n = next;
            while (n <= high && next < 10) {
                if (n >= low) {
                    res.add(n);
                }
                n = n * 10 + ++next;
            }
        }
        Collections.sort(res);
        return res;
    }

    public static void main(String[] args) {
        // [123,234]
        ArrayList<Integer> result1 = new ArrayList<>();
        result1.add(123);
        result1.add(234);
        assert sequentialDigits(100, 300).equals(result1);

        // [1234,2345,3456,4567,5678,6789,12345]
        ArrayList<Integer> result2 = new ArrayList<>();
        result2.add(1234);
        result2.add(2345);
        result2.add(3456);
        result2.add(4567);
        result2.add(5678);
        result2.add(6789);
        result2.add(12345);
        assert sequentialDigits(1000, 13000).equals(result2);
    }

    // another approach
    public List<Integer> sequentialDigits2(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        if(low <= 0 && high >= 0) ans.add(0);
        for(int i = 1; i < 10; i++) q.add(i);
        while(q.size() > 0){
            int curr = q.remove();
            if(curr >= low && curr <= high) ans.add(curr);
            int onesDigit = curr % 10;
            if(onesDigit < 9 && curr * 10 + onesDigit + 1 <= high) q.add(curr * 10 + onesDigit + 1);
        }
        return ans;
    }
}
