// https://www.hackerrank.com/contests/smart-interviews/challenges/si-level-order-of-tree


// Implementation 1

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
      if (root == null) {
        return;
      }

      Queue < Node > q = new LinkedList < > ();
      q.offer(root);
      Node m = new Node(-1);
      q.offer(m);
      while (q.size() > 1) {
        Node curr = q.poll();
        if (curr == m) {
          q.offer(m);
          System.out.println();
        } else {
          System.out.print(curr.data + " ");
          if (curr.left != null) {
            q.offer(curr.left);
          }
          if (curr.right != null) {
            q.offer(curr.right);
          }
        }
      }
      System.out.println();
      System.out.println();

    }

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








// Implementation 2

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
      if (root == null) {
        return;
      }

      Queue < Node > q = new LinkedList < > ();
      q.offer(root);

      while (!q.isEmpty()) {

        int qs = q.size();
        for (int i = 0; i < qs; i++) {
          Node curr = q.poll();
          System.out.print(curr.data + " ");
          if (curr.left != null) {
            q.offer(curr.left);
          }
          if (curr.right != null) {
            q.offer(curr.right);
          }
        }
        System.out.println();
      }
      System.out.println();
    }

    // System.out.println(); System.out.println();   

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









