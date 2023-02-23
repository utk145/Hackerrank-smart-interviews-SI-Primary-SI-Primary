// https://www.hackerrank.com/contests/smart-interviews/challenges/si-finding-the-floor


import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        MS(a, 0, n - 1);
        int q = sc.nextInt();
        while (q-- > 0) {
            int x = sc.nextInt();
            System.out.println(floor(a, n, x));
        }


    }
    static int floor(int[] a, int n, int x) {
        int low = 0, high = n - 1, ans = Integer.MIN_VALUE;
        int mid = 0;
        while (low <= high) {
            mid = low - (low - high) / 2;
            if (a[mid] <= x) {
                ans = a[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
    public static void MS(int[] ar, int low, int high) {
        if (low == high)
            return;
        int mid = (low + high) / 2;
        MS(ar, low, mid);
        MS(ar, mid + 1, high);
        merge(ar, low, mid, high);
    }
    public static void merge(int[] ar, int low, int mid, int high) {
        int i = low, j = mid + 1, k = 0;
        int[] temp = new int[high - low + 1];
        while (i <= mid && j <= high) {
            if (ar[i] < ar[j])
                temp[k++] = ar[i++];
            else
                temp[k++] = ar[j++];
        }
        while (i <= mid)
            temp[k++] = ar[i++];
        while (j <= high)
            temp[k++] = ar[j++];
        for (int a = low; a <= high; a++)
            ar[a] = temp[a - low];
    }
}