// https://www.hackerrank.com/contests/smart-interviews/challenges/si-rank-of-string/problem


import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
        int t=sc.nextInt() ;
        while(t-->0){
            String s = sc.next();
            System.out.println(rank(s));
            
        }
        
    }
    
    
    static long rank(String str){
        int n=str.length();
        long fact[] = new long[26];
        int a[]= new int[256];  // this array will have the ascii value ke corresponding indices par 1
        fact[0]=1;fact[1]=1;
        for(int i=2;i<26;i++){
            fact[i]=i*fact[i-1];
        }
        for(int i=0;i<n;i++){
            a[str.charAt(i)]++;
        }
        
        int smalls;
        long ans=0;
        for(int i=0;i<n;i++){
            smalls=0;
            for(int j=0;j<256;j++){
                if(j==str.charAt(i)){
                    break;
                }
                if(a[j]==1){
                    smalls++;
                }
            }
            a[str.charAt(i)]=0;
            ans+=smalls*fact[n-1-i];
        }
        
        return ans+1;
    }
}