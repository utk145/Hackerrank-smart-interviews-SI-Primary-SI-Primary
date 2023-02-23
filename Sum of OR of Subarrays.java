// https://www.hackerrank.com/contests/smart-interviews/challenges/si-sum-of-or-of-subarrays

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String st = br.readLine();
            String[] res = st.split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(res[i]);
            }

            long sum = 0;
            for (int i = 0; i < 31; i++) { // ith index
                int cnt = 0;
                for (int j = 0; j < n; j++) {
                    if (checkbit(a[j], i)) {
                        sum += (n - j) * (Math.pow(2, i)) * (cnt + 1);
                        cnt = 0; // reset count
                    } else {
                        cnt++;
                    }
                }

            }

            System.out.println(sum);

        }
    }
    static boolean checkbit(int ele, int i) {
        return ((ele >> i) & 1) == 1;
    }
}


/*
    EXPLANATION:

    The problem requires finding the sum of bitwise OR of all subarrays of an array of size N. In other words, for each bit position i (0<=i<=30), we need to count the number of subarrays in which the i-th bit is set and add (2^i * count) to the sum. Finally, we return the sum.
    For each element a[j], the code checks whether the i-th bit is set using the checkbit() function. If the i-th bit is set, it means we have found a subarray that contributes to the sum. We then calculate the count of the number of subarrays that can be formed by considering the remaining elements to the right of j, in which the i-th bit is set. We add (2^i * count) to the sum and reset the count to zero.

    If the i-th bit is not set, we increment the count as we are looking for consecutive subarrays with the i-th bit not set.

    Finally, after iterating over all the bit positions and elements in the array, the code prints the sum.

*/
