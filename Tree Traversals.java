// https://www.hackerrank.com/contests/smart-interviews/challenges/si-tree-traversals

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            Node root = null;
             while(n-->0) {
            int data = sc.nextInt();
            root = insert(root, data);
        }
            
           List<Integer> preo =  preorderTraversal(root);
            for(int ele:preo){
                System.out.print(ele+" ");
            }
            System.out.println();
           List<Integer> ino =  inorderTraversal(root);
            for(int ele:ino){
                System.out.print(ele+" ");
            }
            System.out.println();
           List<Integer> poso =  postorderTraversal(root);
            for(int ele:poso){
                System.out.print(ele+" ");
            }
            System.out.println();
            System.out.println();
            
        }
    
    }
    public static List<Integer> preorderTraversal(Node root) {
        // iterative
        // Using stack :Remember that you push the right node first and then the left node

List<Integer> ans = new ArrayList<Integer>();
Stack<Node> st = new Stack<>();
st.push(root);

while(root!=null && !st.empty()){
    Node presentt = st.pop();
ans.add(presentt.data);
if(presentt.right!=null){
   st.push(presentt.right);
}
if(presentt.left!=null){
    st.push(presentt.left);
}

}

return ans;

    }
     public static List<Integer> inorderTraversal(Node root) {
        List<Integer> ans = new ArrayList<Integer>();
        inorder(root,ans);
        return ans;
    }

   static void  inorder(Node root,List<Integer> ans){
        if(root==null){
           return;
        }

        inorder(root.left,ans);
        ans.add(root.data);
        inorder(root.right,ans);        

    }
    public static List<Integer> postorderTraversal(Node root) {
        List<Integer> ans = new ArrayList<Integer>();
        postorder(root,ans);
        return ans;
    }
    static void postorder(Node root,List<Integer> ans){
        if(root==null){
           return;
        }

        postorder(root.left,ans);
        postorder(root.right,ans);        
        ans.add(root.data);

    }

    
    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
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