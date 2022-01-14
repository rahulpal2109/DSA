package leetcode.string._8_string_to_integer_atoi;

import java.math.BigInteger;

/*
    8. String to Integer (atoi)

    https://leetcode.com/problems/string-to-integer-atoi/
    Medium

    Time Complexity: O(N)
    Space Complexity: O(1)

    Points:
    1. White Space - ignore preceding whitespaces
    2. Sign (+,-)
    3. String doesn't exist
    4. String containing non-numeric values
    5. Starts with a word - does not contain whitespace/sign/non-numeric
    6. Out of range:
        Positive number: > 2^31 - 1
        Negative number: < - 2^31

    Note - Read solution in Leetcode post or more insight.
*/
public class String_To_Integer_ATOI {

    public static int myAtoi(String s) {
        boolean isPositive = true;
        int len = s.length();
        int result = 0;

        if (s == null || s.isEmpty()) return result;

        int i = 0;
        while (i < len && ' ' == s.charAt(i)) {
            i++;
        }
        if (i < len) {
            StringBuilder sb = new StringBuilder();
            if ('-' == s.charAt(i)) {
                isPositive = false;
                i++;
            } else if ('+' == s.charAt(i)) {
                i++;
            }
            while (i < len) {
                char c = s.charAt(i);
                if (!Character.isDigit(c)) {
                    break;
                }
                sb.append(c);
                i++;
            }
            if (sb.toString().isEmpty()) return result;

            BigInteger bigInteger = new BigInteger(sb.toString());
            BigInteger bigIntegerMax = new BigInteger(Integer.toString(Integer.MAX_VALUE));

            boolean isMax = false;
            if (bigInteger.compareTo(bigIntegerMax) > 0) {
                isMax = true;
            }
            if (isMax) {
                if (isPositive) {
                    result = Integer.MAX_VALUE;
                } else {
                    result = Integer.MIN_VALUE;
                }
            } else {
                if (isPositive) {
                    result = bigInteger.intValue();
                } else {
                    result = 0 - bigInteger.intValue();
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String input1 = "42";
        assert myAtoi(input1) == 42;

        String input2 = "   -42";
        assert myAtoi(input2) == -42;

        String input3 = "4193 with words";
        assert myAtoi(input3) == 4193;

        String input4 = "20000000000000000000";
        assert myAtoi(input4) == 2147483647;

        String input5 = "-20000000000000000000";
        assert myAtoi(input5) == -2147483648;
    }
}
