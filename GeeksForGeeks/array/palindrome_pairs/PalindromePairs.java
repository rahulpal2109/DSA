package GeeksForGeeks.array.palindrome_pairs;

/*
    Palindrome Pairs

    https://practice.geeksforgeeks.org/problems/palindrome-pairs/1
    Hard

    Target:
    Time Complexity: O(N * l^2)
    Space Complexity: O(N * l^2)
    where l is the length of the longest string in the input array

    Naive solution:
    Time Complexity: O(N^2)
    Space Complexity: O(N^2)

    Efficient solution:
    https://www.geeksforgeeks.org/palindrome-pair-in-an-array-of-words-or-strings/
 */
public class PalindromePairs {

    static int palindromepair(int N, String arr[]) {
        if (N==1) {
            return 0;
        }
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (i==j) continue;
                if (isPalindrome(arr[i] + arr[j])) {
                    return 1;
                } else if (isPalindrome(arr[j] + arr[i])) {
                    return 1;
                }
            }
        }
        return 0;
    }

    static boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) return false;
        int i = 0;
        int j = s.length() - 1;

        for (; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] arr1 = {"geekf", "geeks", "or","keeg", "abc", "bc"};
        assert palindromepair(arr1.length, arr1) == 1;

        String[] arr2 = {"abc", "xyxcba", "geekst", "or", "bc"};
        assert palindromepair(arr1.length, arr2) == 1;
    }
}
