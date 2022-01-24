package GeeksForGeeks.array.next_permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*

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
        ArrayList<Integer> res=new ArrayList<Integer>();
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
        int[] res1 = {1, 2, 4, 3, 5, 6};
        assert nextPermutation(arr1.length, arr1).equals(Arrays.asList(res1));
    }
}
