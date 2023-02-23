// https://www.hackerrank.com/contests/smart-interviews/challenges/si-rabin-karp-string-matching-algorithm


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
  static int w = (int) 1e9 + 7;
  public static void main(String[] args) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Scanner in = new Scanner(System.in);
    int t = in .nextInt();
    while (t--> 0) {
      String B = in .next();
      String A = in .next();
      int count = 0;
      int m = B.length();
      int n = A.length();
      int HA1 = 0, HB1 = 0, p1 = 53, p2 = 53, q1 = 43, q2 = 43, HA2 = 0, HB2 = 0;
      for (int i = 0; i < m; i++) {
        HA1 = HA1 + (int) A.charAt(i) * p1;
        HB1 = HB1 + (int) B.charAt(i) * p1;
        p1 = (p1 * 53);
        HA2 = HA2 + (int) A.charAt(i) * q1;
        HB2 = HB2 + (int) B.charAt(i) * q1;
        q1 = q1 * 43;
      }
      if (HA1 == HB1 && HA2 == HB2) {
        count++;
      }
      for (int i = m; i < n; i++) {
        HA1 = HA1 - (int) A.charAt(i - m) * p2 + (int) A.charAt(i) * p1;
        HB1 = HB1 * 53;
        p1 = p1 * 53;
        p2 = p2 * 53;
        HA2 = HA2 - (int) A.charAt(i - m) * q2 + (int) A.charAt(i) * q1;
        HB2 = HB2 * 43;
        q1 = q1 * 43;
        q2 = q2 * 43;
        if (HA1 == HB1 && HA2 == HB2) {
          count++;
        }
      }
      System.out.println(count);
    }

  }
}