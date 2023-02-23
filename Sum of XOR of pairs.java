// https://www.hackerrank.com/contests/smart-interviews/challenges/si-sum-of-xor-of-pairs/problem

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
    static long sol(int[] a){
        int n=a.length;
        long ans=0;
        for(int i=0;i<32;i++){
            int set=0;
            for(int j=0;j<a.length;j++){
                if(checkbit(a[j],i)){
                    set++;
                }
            }
            ans += 1L*set * (n-set) * (1<<i)*2;
        }
        return ans;
        
        
    }
    static boolean checkbit(int ele,int bit){
        return ((ele>>bit)&1)==1;
    }
}
