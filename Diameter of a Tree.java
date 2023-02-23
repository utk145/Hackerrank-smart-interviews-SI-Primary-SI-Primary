// https://www.hackerrank.com/contests/smart-interviews/challenges/si-diameter-of-a-tree


import java.io.*;
import java.util.*;

public class Solution {

  static long m = (long)(1e9) + 7;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t--> 0) {
      int n = sc.nextInt();
      Node root = null;
      while (n--> 0) {
        int data = sc.nextInt();
        root = insert(root, data);
      }

      System.out.println(diameter(root) + 1);

    }
  }
  static int diameter(Node root) {
    if (root == null) {
      return 0;
    }
    int left = depth(root.left);
    int right = depth(root.right);
    // int max = Math.max(max,left+right);
    int max = left + right;
    int l = diameter(root.left);
    int r = diameter(root.right);
    return Math.max(Math.max(l, r), max);
  }
  static int depth(Node root) {
    if (root == null) {
      return 0;
    }
    int lt = depth(root.left);
    int rt = depth(root.right);
    return Math.max(lt, rt) + 1;

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