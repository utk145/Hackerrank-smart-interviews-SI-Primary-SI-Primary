// https://www.hackerrank.com/contests/smart-interviews/challenges/si-bst-operations


import java.util.*;
import java.io.*;

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

class Solution {

  /* 
  
  class Node 
      int data;
      Node left;
      Node right;
  */
  static int getMin(Node root) {
    if (root == null) {
      return Integer.MIN_VALUE;
    }
    if (root.left == null) {
      return root.data;
    }
    return getMin(root.left);

  }
  static void preorder(Node root) {
    if (root == null) {
      return;
    }
    System.out.print(root.data + " ");
    preorder(root.left);
    preorder(root.right);

  }
  static boolean search(Node root, int ele) {
    if (root == null) {
      return false;
    }
    if (ele == root.data) {
      return true;
    } else if (ele < root.data) {
      return search(root.left, ele);
    } else {
      return search(root.right, ele);
    }

  }
  static Node delete(Node root, int ele) {
    if (root == null) {
      return null;
    }
    if (ele < root.data) {
      root.left = delete(root.left, ele);
      return root;
    }
    if (ele > root.data) {
      root.right = delete(root.right, ele);
      return root;
    }

    // 0 child node
    if (root.left == null && root.right == null) {
      return null;
    }

    // 1 child node
    if (root.left == null) {
      return root.right;
    }
    if (root.right == null) {
      return root.left;
    }

    // 2 child node
    root.data = getMin(root.right);
    root.right = delete(root.right, root.data);
    return root;

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

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    int count = 1;
    while (t--> 0) {
      System.out.println("Case #" + (count++) + ":");
      Node root = null;
      int q = sc.nextInt();
      while (q--> 0) {
        int a = sc.nextInt();
        int x = 0;
        if (a == 1 || a == 2 || a == 3) {
          x = sc.nextInt();
        }
        if (a == 1) {
          root = insert(root, x);
        } else if (a == 2) {
          root = delete(root, x);
        } else if (a == 3) {
          if (search(root, x)) {
            System.out.println("Yes");
          } else {
            System.out.println("No");
          }
        } else {
          preorder(root);
          System.out.println();
        }
      }

    }

  }
}