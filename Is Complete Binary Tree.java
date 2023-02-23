// https://www.hackerrank.com/contests/smart-interviews/challenges/si-is-complete-binary-tree


import java.io.*;
import java.util.*;

public class Solution {

  static long m = (int)(1e9) + 7;
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

      if (isComplete(root, 0, count(root))) {
        System.out.println("Yes");
      } else {
        System.out.println("No");
      }

    }
  }
  static int count(Node root) {
    if (root == null) {
      return 0;
    }
    return (1 + count(root.left) + count(root.right));
  }
  static boolean isComplete(Node root, int indx, int nodes) {
    if (root == null) {
      return true;
    }
    if (indx >= nodes) {
      return false;
    }
    return (isComplete(root.left, 2 * indx + 1, nodes) && isComplete(root.right, 2 * indx + 2, nodes));

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