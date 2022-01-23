package GeeksForGeeks.string.rearrange_a_string;

/*
    Rearrange a string

    https://practice.geeksforgeeks.org/problems/rearrange-a-string4100/1#
    Easy

    Time complexity: O()
    Space complexity: O()
 */
public class RearrangeAString {
    static final int MAX_CHAR = 26;
    private static String arrangeString(String s)
    {
        int alpha_count[] = new int[MAX_CHAR];
        int strlen = s.length();
        int int_sum = 0;
        for (int i = 0; i < strlen; i++) {
            if (Character.isUpperCase(s.charAt(i)))
                alpha_count[s.charAt(i) - 'A']++;
            else
                int_sum += s.charAt(i) - '0';
        }
        String result = "";
        for (int i = 0; i < MAX_CHAR; i++) {
            char ch = (char) ('A' + i);
            while (alpha_count[i]-- != 0)
                result += ch;
        }
        if (int_sum > 0)
            result += int_sum;
        return result;
    }

    public static void main(String[] args) {
        assert arrangeString("AC2BEW3").equals("ABCEW5");
        assert arrangeString("ACCBA10D2EW30").equals("AABCCDEW6");
    }
}
