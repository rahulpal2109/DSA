package leetcode.misc._290_word_pattern;

import java.util.HashMap;
import java.util.HashSet;

/*
    290. Word Pattern

    https://leetcode.com/problems/word-pattern/
    Easy

    Time complexity: O(N)
    Space complexity: O(N)
 */
public class WordPattern {
    private static boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map = new HashMap();
        HashSet<String> set = new HashSet();
        StringBuilder sb = new StringBuilder();
        String[] str = s.split(" ");
        if (pattern.length() != str.length) {
            return false;
        }
        int len = pattern.length();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(pattern.charAt(i))){
                if (!str[i].equals(map.get(pattern.charAt(i)))) {
                    return false;
                }
            } else {
                map.put(pattern.charAt(i), str[i]);
                if (!set.add(str[i])) {
                    return false;
                }
            }
            sb.append(" ");
            sb.append(str[i]);
        }
        String newStr = sb.substring(1);
        if (newStr.equals(s)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String pattern1 = "abba";
        String str1 = "dog cat cat dog";
        assert wordPattern(pattern1, str1);

        String pattern2 = "abba";
        String str2 = "dog cat cat fish";
        assert !wordPattern(pattern2, str2);

        String pattern3 = "aaaa";
        String str3 = "dog cat cat dog";
        assert !wordPattern(pattern3, str3);
    }
}
