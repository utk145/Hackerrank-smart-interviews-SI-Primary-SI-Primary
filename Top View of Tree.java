// https://www.hackerrank.com/contests/smart-interviews/challenges/si-top-view-of-tree


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

        
        ArrayList<Integer> ans = topView(root);
        for(int ele:ans){
            System.out.print(ele+" ");
            
        }
        System.out.println();
   

    }
  }
 static ArrayList<Integer> topView(Node root){
        ArrayList<Integer> ans = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        if (root == null) return ans;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, root));
        while (!q.isEmpty()) {
            Pair temp = q.poll();
            int vertical = temp.vertical;
            Node node = temp.node;

            // we will add the very first node of each vertical line.
            if (!map.containsKey(vertical)) {
                map.put(vertical, node.data);
            }

            if (node.left != null) {
                q.add(new Pair(vertical - 1, node.left));
            }
            if (node.right != null) {
                q.add(new Pair(vertical + 1, node.right));
            }
        }

        for (int nodes : map.values()) {
            ans.add(nodes);
        }
        return ans;
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
    Node(int data){
        this.data = data;
    };
    Node(){;}
    Node(int data, Node left,Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
class Pair {
    int vertical;
    Node node;
    public Pair(int vertical, Node node) {
        this.vertical = vertical;
        this.node = node;
    }
}



/* EXPLANATION:

    The topView function works by using a TreeMap to keep track of the nodes that are visible from each vertical line. It uses a Queue to perform a level-order traversal of the tree, and for each node, it checks whether the vertical line that it belongs to has been visited before. If it hasn't, it adds the node's value to the TreeMap. Finally, it returns the values of the TreeMap as the top-view of the tree.

    The Pair class is a simple class that is used to store a node and its corresponding vertical line number.

 */