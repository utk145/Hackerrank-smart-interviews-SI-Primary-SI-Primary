// https://www.hackerrank.com/contests/smart-interviews/challenges/si-sum-of-numbers-from-root-to-leaf-paths




import java.io.*;
import java.util.*;

public class Solution {

  static long m = (long)((1e9) + 7);
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

      System.out.println(sumNumbers(root));

    }
  }
  public static long sumNumbers(Node root) {
    if (root == null) {
      return 0;
    }
    return sumRL(root, 0);
  }
  static long sumRL(Node root, long prev) {
    if (root == null) {
      return 0;
    }
    long curr = (prev * ((long)(Math.pow(10, countDigits(root.data)))) + root.data) % m;
    if (root.left == null && root.right == null) {
      return curr % m;
    }
    return (sumRL(root.left, curr) + sumRL(root.right, curr)) % m;

  }
  static int countDigits(long n) {
    if (n == 0) {
      return 1;
    }
    return (int) Math.log10(n) + 1;
  }
  //     public static int sumNumbers(Node root) {
  //         return sumRL(root,0);
  //     }
  //     static int sumRL(Node root,int prev){
  //         if(root==null){
  //             return 0;
  //         }
  //         // int curr=(prev*(int)(Math.pow(10,countDigits(root.val)))+root.val);
  //         if(root.left==null&&root.right==null){
  //             return prev+root.data;
  //         }
  //         int curr=(prev+root.data)*10;
  //         return sumRL(root.left,curr)+sumRL(root.right,curr);

  //     }
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

    In a BST, every node has a value greater than or equal to its left child and less than or equal to its right child. The insert() method is used to build the BST by taking a node and a data value as input and inserting the value into the correct position in the tree. It returns the root node of the updated tree.

    The main() method reads the number of test cases and then for each test case, it reads the number of elements in the array, constructs a BST from the array using insert() method and calls the sumNumbers() method to calculate the sum of numbers formed along the path from the root node to the leaf nodes. The sum is then printed.

    The sumNumbers() method takes the root node of the BST as input and returns the sum of the numbers along the path. It first checks if the root node is null and returns 0 if it is. It then calls the sumRL() method with the root node and 0 as the previous sum.

    The sumRL() method is a recursive method that takes a node and the previous sum as input and calculates the sum of the numbers along the path from that node. It first checks if the node is null and returns 0 if it is. It then calculates the current sum by multiplying the previous sum by 10 raised to the number of digits in the node's data and adding the node's data. It takes the modulo of this sum with a large prime number m to avoid overflow. If the node is a leaf node (i.e., has no children), it returns the current sum modulo m. Otherwise, it recursively calculates the sum of the left and right subtrees by calling sumRL() with the left and right child nodes and the current sum as the previous sum. It then returns the sum of these two values modulo m.

    The countDigits() method takes a number as input and returns the number of digits in it by using the log10() method.

 */







