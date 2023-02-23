// https://www.hackerrank.com/contests/smart-interviews/challenges/si-number-of-connected-components


import java.io.*;
import java.util.*;

public class Solution {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t--> 0) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      ArrayList[] graph = new ArrayList[n + 1];
      for (int i = 0; i < n + 1; i++) {
        graph[i] = new ArrayList < Integer > ();
      }
      while (m--> 0) {
        int u = sc.nextInt();
        int v = sc.nextInt();
        graph[u].add(v);
        graph[v].add(u);
      }
      boolean visited[] = new boolean[n + 1];
      int count = 0;
      for (int i = 1; i <= n; i++) {
        if (!visited[i]) {
          count++;
          ans(graph, i, visited);
        }
      }
      System.out.println(count);
    }

  }

  static void ans(ArrayList < Integer > [] graph, int s, boolean visited[]) {
    visited[s] = true;
    for (Integer ele: graph[s]) {
      if (!(visited[ele])) {
        ans(graph, ele, visited);
      }
    }
  }

}