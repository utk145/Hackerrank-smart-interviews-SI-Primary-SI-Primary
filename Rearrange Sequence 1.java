// https://www.hackerrank.com/contests/smart-interviews/challenges/si-rearrange-sequence-1/problem


import java.io.*;
import java.util.*;

public class Solution {
    public static int ans(int[] a) {
        int n = a.length, len = -1;
        int min, max;
        for (int i = 0; i < n; i++) {
            min = a[i];
            max = a[i];
            for (int j = i; j < n; j++) {
                min = Math.min(min, a[j]);
                max = Math.max(max, a[j]);
                if (Math.abs(max - min) == Math.abs(j - i)) {
                    len = Math.max(len, (j - i) + 1);
                }
            }
        }
        if (n == 1) {

            return 1;

        }
        return len;
    }
    public static void main(String[] ags) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            System.out.println(ans(a));
        }
    }
}




/*  EXPLANATION:


For example, let's say the given array is {1, 3, 4, 2, 6, 5}. We can rearrange it to get the new sequence {1, 2, 3, 4, 5, 6}. Now, if we take any contiguous subarray of this sequence, the absolute difference between its maximum and minimum values is equal to the length of the subarray. For example, the subarray {1, 2, 3} has length 3 and the absolute difference between its maximum and minimum values is also 3.

The approach used in the given solution is as follows:

We iterate over all possible contiguous subarrays of the array and for each subarray, we check if it is a valid sequence or not. To check the validity of a subarray, we find its minimum and maximum values and calculate their absolute difference. If this absolute difference is equal to the length of the subarray, then we update the length of the longest valid sequence found so far. Finally, we return the length of the longest valid sequence.

The time complexity of this approach is O(n^3), where n is the size of the array. This is because we have three nested loops, where the outermost loop iterates over all possible starting indices, the middle loop iterates over all possible ending indices, and the inner loop finds the minimum and maximum values of the subarray. This approach will work for small input sizes, but may not be efficient for large input sizes.


*/