// https://www.hackerrank.com/contests/smart-interviews/challenges/si-print-right-angled-triangle-pattern/problem


import java.io.*;
import java.util.*;

public class Solution {

  public static void main(String[] args) {
    Scanner m = new Scanner(System.in);
    int t = m.nextInt();
    while (t > 0) {
      for (int w = 1; w <= t; w++) {
        System.out.printf("Case #%d:\n", w);

        int n = m.nextInt();
        for (int i = 1; i <= n; i++) {
          for (int j = n - 1; j >= i; j--) {
            System.out.print(" ");
          }
          for (int k = 1; k <= i; k++) {
            System.out.print("*");
          }
          System.out.println();
        }
      }
      break;
    }

  }
}


