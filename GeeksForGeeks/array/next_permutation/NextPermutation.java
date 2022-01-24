package GeeksForGeeks.array.next_permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Next Permutation

    https://practice.geeksforgeeks.org/problems/next-permutation5226/1#
    Medium

    Time complexity: O(n)
    Space complexity: O(1)
 */
public class NextPermutation {
    private static List<Integer> nextPermutation(int n, int arr[]) {
        // code here
        int i=n-1;
        for(i=n-1;i>0;i--) {
            if(arr[i]>arr[i-1]) {
                break;
            }
        }
        List<Integer> res=new ArrayList<>();
        if(i==0) {
            for(i=n-1;i>=0;i--) {
                res.add(arr[i]);
            }
        } else {
            int x=arr[i-1];
            int min=i;
            for(int j=i;j<n;j++) {
                if(arr[j]>x) {
                    min=j;
                }
            }
            swap(arr,i-1,min);
            reverse(arr,i,n);
            for(i=0;i<n;i++) {
                res.add(arr[i]);
            }
        }
        return res;
    }

    private static void swap(int a[],int i,int j) {
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }

    private static void reverse(int[] nums, int start,int end) {
        int i = start, j=end-1;
        while (i < j) {
            swap(nums, i,j);
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 6, 5, 4};
        List<Integer> resultList1 = Arrays.asList(1, 2, 4, 3, 5, 6);
        assert resultList1.equals(nextPermutation(arr1.length, arr1));

        int[] arr2 = {3, 2, 1};
        List<Integer> resultList2 = Arrays.asList(1, 2, 3);
        assert resultList2.equals(nextPermutation(arr2.length, arr2));

    }
}
