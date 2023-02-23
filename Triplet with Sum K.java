// https://www.hackerrank.com/contests/smart-interviews/challenges/si-triplet-with-sum-k


import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int target = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            boolean ans = sol(a, target);
            if (ans == true) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        }

    }
    static boolean sol(int[] a, int target) {
        int N = a.length;
        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    if (a[i] + a[j] + a[k] == target) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}