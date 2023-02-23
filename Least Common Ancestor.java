// https://www.hackerrank.com/contests/smart-interviews/challenges/si-least-common-ancestor


import java.io.*;
import java.util.*;

public class Solution {

  static long m = (int)(1e9) + 7;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int t = Integer.parseInt(br.readLine());
    while (t--> 0) {
      String[] tmp = br.readLine().split(" ");
      int n = Integer.parseInt(tmp[0]);
      int query = Integer.parseInt(tmp[1]);
      Node root = null;
      String[] tmp2 = br.readLine().split(" ");
      for (String st: tmp2) {
        int data = Integer.parseInt(st);
        root = insert(root, data);
      }
      while (query--> 0) {
        String[] tmp3 = br.readLine().split(" ");
        int u = Integer.parseInt(tmp3[0]);
        int v = Integer.parseInt(tmp3[1]);
        bw.write(lca(root, u, v) + " ");
      }
      bw.write("\n");

      // System.out.println();

    }
    bw.flush();
  }

  static int lca(Node root, int a, int b) {
    if (root == null) {
      return -1;
    }
    if (root.data == a || root.data == b) {
      return root.data;
    }
    int l = lca(root.left, a, b);
    int r = lca(root.right, a, b);
    if (l == -1) {
      return r;
    }
    if (r == -1) {
      return l;
    }
    return root.data;

  }
  public static Node insert(Node root, int data) {
    if (root == null) {
      return new Node(data);
    }
    if (data < root.data) {
      root.left = insert(root.left, data);
    } else {
      root.right = insert(root.right, data);
    }
    return root;
  }
}
class Node {
  Node left;
  Node right;
  int data;

  Node(int data) {
    this.data = data;
    left = null;
    right = null;
  }
}