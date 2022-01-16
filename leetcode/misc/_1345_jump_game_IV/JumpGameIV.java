package leetcode.misc._1345_jump_game_IV;

import java.util.*;

/*
    1345. Jump Game IV

    https://leetcode.com/problems/jump-game-iv/
    Hard

 */
public class JumpGameIV {
    private static int minJumps(int[] arr) {
        int n = arr.length;

        if(n == 1) return 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        int step = 0;

        // fill the map
        for(int i = 0; i < n; i++){
            map.computeIfAbsent(arr[i], v -> new ArrayList()).add(i);
        }
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);

        while(!q.isEmpty()){
            step++;
            int size = q.size();
            for(int i = 0; i < size; i++){
                int j = q.poll();

                if(j - 1 >= 0 && map.containsKey(arr[j - 1])){
                    q.offer(j - 1);
                }

                if(j + 1 < n && map.containsKey(arr[j + 1])){
                    if(j + 1 == n - 1) return step;
                    q.offer(j + 1);
                }

                if(map.containsKey(arr[j])){
                    for(int k : map.get(arr[j])){
                        if(k != j){
                            if(k == n - 1) return step;
                            q.offer(k);
                        }
                    }
                }
                map.remove(arr[j]);
            }
        }

        return step;
    }

    public static void main(String[] args) {
        int[] arr1 = {100,-23,-23,404,100,23,23,23,3,404};
        assert minJumps(arr1) == 3;

        int[] arr2 = {7};
        assert minJumps(arr2) == 0;

        int[] arr3 = {7,6,9,6,9,6,9,7};
        assert minJumps(arr3) == 1;
    }
}
