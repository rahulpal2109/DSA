package GeeksForGeeks.recursion.handshakes;

/*
    Handshakes

    https://practice.geeksforgeeks.org/problems/handshakes1303/1#
    Medium

    Time Complexity: O()
    Space Complexity: O()
 */
public class Handshakes {
    private static int count(int N)
    {
        if(N == 2 || N == 0)
            return 1;
        int left = 0; int right = N-2; int ans = 0;
        while(right >= 0){
            ans += count(left)*count(right);
            left += 2;
            right -= 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        assert count(2) == 1;
        assert count(4) == 2;
    }
}
