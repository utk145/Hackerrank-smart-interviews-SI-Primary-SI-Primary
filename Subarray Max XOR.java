// https://www.hackerrank.com/contests/smart-interviews/challenges/si-subarray-max-xor


import java.io.*;
import java.util.*;

public class Solution {
    static class Trie{
        Trie[] child = new Trie[2];
        Trie(){
            child[0]=child[1]=null;
        }
    }
   static void insert(Trie root,int ele){
        for(int i=31;i>=0;i--){
            int bit = (ele>>i)&1;
            if(root.child[bit]==null){
                root.child[bit]=new Trie();
            }
            root=root.child[bit];
        }
    }
    static int maxXor(Trie root,int ele){
        int ans=0;
        for(int i=31;i>=0;i--){  
            int bit = (ele>>i)&1;
            if(root.child[bit^1]!=null){
                ans=ans|(1<<i);
                root=root.child[1-bit];  
            }else{
                root=root.child[bit];
            }
            
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
         int n = sc.nextInt();
            int[] a = new int[n];
            for(int i=0;i<n;i++) a[i]=sc.nextInt();
            Trie root = new Trie();
            int ans=0,pre=0;
            insert(root,0);
            for(int ele:a){
                pre^=ele;
                insert(root,pre);
                ans=Math.max(ans,maxXor(root,pre));
            }
            System.out.println(ans);
        }
    }
   
}