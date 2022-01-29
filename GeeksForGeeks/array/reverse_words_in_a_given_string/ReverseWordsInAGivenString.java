package GeeksForGeeks.array.reverse_words_in_a_given_string;

/*
    Reverse words in a given string

    https://practice.geeksforgeeks.org/problems/reverse-words-in-a-given-string5459/1
    Easy

    Time Complexity: O(n)
    Space Complexity: O(n)
 */
public class ReverseWordsInAGivenString {
    private static String reverseWords(String S)
    {
        if (S == null || S.isEmpty()) return null;
        if (S.indexOf('.') < 0) return S;
        String[] arr = S.split("\\.");
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            sb.append(arr[i]);
            sb.append(".");
        }
        String result = sb.toString();
        //System.out.println("Before strip: " + result);
        result = result.substring(0, result.length() - 1);
        //System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        assert reverseWords("i.like.this.program.very.much").equals("much.very.program.this.like.i");
        assert reverseWords("pqr.mno").equals("mno.pqr");
        assert reverseWords("hi").equals("hi");
    }
}
