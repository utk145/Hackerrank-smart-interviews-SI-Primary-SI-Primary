// https://www.hackerrank.com/contests/smart-interviews/challenges/si-is-balanced-tree


import java.io.*;
import java.util.*;

public class Solution {

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

      if (isBalanced(root)) {
        System.out.println("Yes");
      } else {
        System.out.println("No");
      }

    }

  }
  public static boolean isBalanced(Node root) {
    if (check(root) != -1) {
      return true;
    } else {
      return false;
    }
  }
  static int check(Node root) {
    if (root == null) {
      return 0;
    }

    int lt = check(root.left);
    int rt = check(root.right);
    if (lt == -1 || rt == -1) {
      return -1;
    }
    if (Math.abs(lt - rt) > 1) {
      return -1;
    }
    return Math.max(lt, rt) + 1;

  }
  public static Node insert(Node root, int data) {
    if (root == null) {
      return new Node(data);
    } else {
      Node cur;
      if (data <= root.data) {
        cur = insert(root.left, data);
        root.left = cur;
      } else {
        cur = insert(root.right, data);
        root.right = cur;
      }
      return root;
    }
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