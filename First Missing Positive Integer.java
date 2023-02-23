// https://www.hackerrank.com/contests/smart-interviews/challenges/si-first-missing-positive-integer/problem


import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int[] a=new int[n];
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }
            HashSet<Integer> hs = new HashSet<>();
            for(int ele:a)
            {
                if(ele>=1 && ele<n+1){
                hs.add(ele);
                }
            }
            
            for(int i=1;i<=n+1;i++){
                if(!hs.contains(i)){
                    System.out.println(i);
                    break;
                }
            }
        }
        
        
    }
}