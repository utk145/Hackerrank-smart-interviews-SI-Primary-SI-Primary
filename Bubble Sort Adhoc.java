// https://www.hackerrank.com/contests/smart-interviews/challenges/si-bubble-sort/problem



import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int totalSwaps = sort(a, n);

            if (totalSwaps == 0) {
                // The array is already in sorted order
            }
            System.out.println(totalSwaps);


        }


    }

    static int sort(int array[], int n) {

        int swaps = 0;
        for (int i = 0; i < n - 1; ++i) {
            for (int j = 0; j < n - 1 - i; ++j) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    swaps++;
                }
            }
        }
        return swaps;
    }

}