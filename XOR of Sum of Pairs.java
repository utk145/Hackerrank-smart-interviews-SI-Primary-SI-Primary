// https://www.hackerrank.com/contests/smart-interviews/challenges/si-xor-of-sum-of-pairs/problem



import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int[] a = new int[n];
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }
                System.out.println(sol(a));
        }
    
    }
    
    static int sol(int[] a){
        int ans=0;
        int n=a.length;
        for(int i=0;i<n;i++){
                ans^=(2*a[i]);     
        }
        return ans;
    }
}




