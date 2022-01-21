package GeeksForGeeks.misc.binary_number_to_decimal_number;

/*
    Binary number to decimal number

    https://practice.geeksforgeeks.org/problems/binary-number-to-decimal-number3525/1#
    Basic

    Time complexity: O(n)
    Space complexity: O(1)

 */
public class BinaryNumberToDecimalNumber {
    private static int binary_to_decimal_logic(String str)
    {
        if (str == null || str.isEmpty()) return 0;

        int result = 0;
        int mul = 1;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (Character.getNumericValue(str.charAt(i)) == 1) {
                result += mul;
            }
            mul *= 2;
        }
        return result;
    }

    private static int binary_to_decimal_method(String str)
    {
        return Integer.parseInt(str, 2);
    }

    public static void main(String[] args) {
        String t1 = "10001000";
        assert binary_to_decimal_logic(t1) == 136;
        assert binary_to_decimal_method(t1) == 136;

        String t2 = "101100";
        assert binary_to_decimal_logic(t2) == 44;
        assert binary_to_decimal_method(t2) == 44;
    }
}
