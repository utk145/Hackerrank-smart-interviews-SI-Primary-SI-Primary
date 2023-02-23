// https://www.hackerrank.com/contests/smart-interviews/challenges/si-sum-of-subarrays


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// *** Preferred Approach ***
public class Solution {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static Scanner sc = new Scanner( in );
  static StringBuilder out = new StringBuilder();
  public static void main(String[] args) throws IOException {

    int n = sc.nextInt();
    int[] nums = new int[n];
    for (int i = 0; i < n; i++) {
      nums[i] = sc.nextInt();
    }
    long[] perfix = new long[n];
    perfix[0] = nums[0];
    for (int i = 1; i < n; i++) {
      perfix[i] = 1L * perfix[i - 1] + nums[i];
    }
    int q = sc.nextInt();
    while (q--> 0) {
      int i = sc.nextInt();
      int j = sc.nextInt();
      if (i != 0) {
        out.append(perfix[j] - perfix[i - 1] + "\n");
      } else {
        out.append(perfix[j] + "\n");
      }
    }
    System.out.println(out);
  }
}