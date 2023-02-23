// https://www.hackerrank.com/contests/smart-interviews/challenges/si-trim-bst

import java.io.*;
import java.util.*;

public class Solution {

  static long m = (int)(1e9) + 7;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t--> 0) {
      int n = sc.nextInt();
      int lower = sc.nextInt();
      int upper = sc.nextInt();
      Node root = null;
      while (n--> 0) {
        int data = sc.nextInt();
        root = insert(root, data);
      }

      root = trim(root, lower, upper);
      preorder(root);
      System.out.println();

    }
  }
  static void preorder(Node root) {
    if (root == null) {
      return;
    }
    System.out.print(root.data + " ");
    preorder(root.left);
    preorder(root.right);
  }

  
  static Node trim(Node root, int low, int upper) {
    if (root == null) {
      return null;
    }
    if (root.data < low) {
      return trim(root.right, low, upper);
    }
    if (root.data > upper) {
      return trim(root.left, low, upper);
    }

    root.left = trim(root.left, low, upper);
    root.right = trim(root.right, low, upper);
    return root;
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



/*
    EXPLANATION:

    The given code takes input an integer t which represents the number of test cases. For each test case, it takes input n, lower, and upper, where n is the number of elements in the array and lower and upper are the bounds for trimming the BST. It then takes n integers as input and constructs a BST from them using the insert() function.

    After constructing the BST, it calls the trim() function to trim the tree such that all its elements lie between [L, R]. The trim() function recursively traverses the tree and checks if the current node's data is less than L or greater than R. If it is less than L, it trims the right subtree and returns it. If it is greater than R, it trims the left subtree and returns it. If the current node's data is within the range [L, R], it recursively trims both its left and right subtrees and returns the node itself.

    Finally, it calls the preorder() function to print the pre-order traversal of the trimmed BST.

    Overall, the code correctly trims the given BST such that all its elements lie between [L, R].

 */