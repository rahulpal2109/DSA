package GeeksForGeeks.heap.gadgets_of_doraland;

import java.util.*;

/*
    Gadgets of Doraland

    https://practice.geeksforgeeks.org/problems/bbd15e2da95880979ce65acc7360e2c5681664e65520/1
    Easy

    Expected Time Complexity: O(n)
    Expected Space Complexity: O(n)
 */
public class GadgetsOfDoraland {
    private static ArrayList<Integer> TopK(ArrayList<Integer> did, int k)
    {
        Map<Integer,Integer> m = new HashMap<>();

        for(int i=0;i<did.size();i++){
            m.put(did.get(i),1+m.getOrDefault(did.get(i),0));
        }
        List<Map.Entry<Integer,Integer>> l=new ArrayList<>(m.entrySet());

        Collections.sort(l,(o1, o2)->o2.getKey().compareTo(o1.getKey())); //descending keys

        Collections.sort(l,(o1,o2)->o2.getValue().compareTo(o1.getValue())); // descending values

        ArrayList<Integer> ans=new ArrayList<>();

        for(int i=0;i<k;i++) {
            ans.add(l.get(i).getKey());
        }
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList1 = new ArrayList<>(Arrays.asList(1, 1, 1, 2, 2, 3));
        ArrayList<Integer> arrayListRes1 = new ArrayList<>(Arrays.asList(1, 2));
        assert TopK(arrayList1, 2).equals(arrayListRes1);

        ArrayList<Integer> arrayList2 = new ArrayList<>(Arrays.asList(1, 1, 2, 2, 3, 3, 3, 4));
        ArrayList<Integer> arrayListRes2 = new ArrayList<>(Arrays.asList(3, 2));
        assert TopK(arrayList2, 2).equals(arrayListRes2);
    }
}
