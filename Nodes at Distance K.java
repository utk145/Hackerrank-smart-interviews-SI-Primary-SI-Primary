// https://www.hackerrank.com/contests/smart-interviews/challenges/si-nodes-at-distance-k



import java.io.*;
import java.util.*;

public class Solution {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t--> 0) {
      int n = sc.nextInt();
      int s = sc.nextInt();
      int k = sc.nextInt();
      count = 0;
      Node root = null;
      while (n--> 0) {
        int data = sc.nextInt();
        root = insert(root, data);
      }

      find(root, k, s);
      System.out.println(count);

    }
  }

  static int count = 0;
  static int find(Node node, int k, int s) {
    if (node == null) {
      return -1;
    }
    int l = -1, r = -1;
    if (node.data == s) {
      Count(node, k);
      return 1;
    } else if (node.data > s) {
      l = find(node.left, k, s);
    } else {
      r = find(node.right, k, s);
    }
    if (l != -1) {
      if (k - l == 0) {
        count++;
        return -1;
      }
      Count(node.right, k - l - 1);
    }
    if (r != -1) {
      if (k - r == 0) {
        count++;
        return -1;
      }
      Count(node.left, k - r - 1);
    }
    if (l == -1 && r == -1) {
      return -1;
    }
    return Math.max(l, r) + 1;
  }
  static void Count(Node root, int k) {
    //counting number of nodes below X at distance k
    if (root == null) {
      return;
    }
    if (k == 0) {
      count++;
      return;
    }
    // return Count(root.left,k-1)+ Count(root.right,k-1);
    Count(root.left, k - 1);
    Count(root.right, k - 1);

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
    
    
    The main logic of the find() function is as follows:

    If the current node is null, return -1.
    If the current node data matches the source node S, call the Count() function to count the number of nodes at a distance K from this node and return 1.
    If the current node data is greater than the source node S, recursively call find() on the left subtree.
    If the current node data is less than the source node S, recursively call find() on the right subtree.
    If either the left or right subtree returns a value other than -1, calculate the distance from the current node to the source node S.
    If the calculated distance is equal to K, increment the count variable and return -1.
    Call the Count() function on the opposite subtree with a distance of K minus the distance calculated in step 5.
    If neither the left nor right subtree is traversed, return -1.



    The Count() function counts the number of nodes at a distance K from the given node using the following logic:

    If the current node is null, return.
    If the current distance K is 0, increment the count variable and return.
    Recursively call Count() on the left subtree with distance K minus 1.
    Recursively call Count() on the right subtree with distance K minus 1.

 */