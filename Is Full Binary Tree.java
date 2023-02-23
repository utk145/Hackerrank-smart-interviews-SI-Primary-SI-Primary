// https://www.hackerrank.com/contests/smart-interviews/challenges/si-is-full-binary-tree


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
      if (isFull(root)) {
        System.out.println("True");
      } else {
        System.out.println("False");
      }

    }

  }
  static boolean isFull(Node root) {
    if (root == null) {
      return true;
    }
    if ((root.left == null) && (root.right == null)) { //Only one node i.e root node
      return true;
    }
    if ((root.left != null) && (root.right != null))
      return (isFull(root.left) && isFull(root.right));
    return false;

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