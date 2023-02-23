// https://www.hackerrank.com/contests/smart-interviews/challenges/si-rearrange-sequence-2



import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] ar = new int[n];
            for (int i = 0; i < n; i++) {
                ar[i] = sc.nextInt();
            }
            System.out.println(sol(ar));

        }

    }
    static int sol(int[] ar) {
        int ans = Integer.MIN_VALUE;
        int n = ar.length;
        for (int i = 0; i < n; i++) {
            int a, b;
            a = b = ar[i];
            for (int j = i; j < n; j++) {
                if (ls(ar[j], ar, i, j - 1))
                    break;
                a = Math.min(a, ar[j]);
                b = Math.max(b, ar[j]);
                if (b - a + 1 == j - i + 1)
                    ans = Math.max(ans, j - i + 1);
            }
        }
        return ans;
    }
    static boolean ls(int k, int[] a, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (a[i] == k)
                return true;
        }
        return false;
    }
}


/*

    EXPLANATION:

        The sol function takes the input array and iterates through each element to check the longest contiguous subarray. It initializes the answer variable to the minimum integer value to avoid any possible edge cases.

        For each element i in the array, we compare it with all the elements from i to n-1 in the array. For all the elements that come before i, we check if it is the subsequence of the elements between i and j-1. If this condition is met, we break the loop and move to the next element i.

        If the element is not a subsequence, then we update two variables, a and b, to keep track of the smallest and largest element in the current subarray, respectively. We then check if the subarray between i and j is a contiguous sequence. If it is, then we update the answer variable to store the maximum length of the contiguous subarray.

*/