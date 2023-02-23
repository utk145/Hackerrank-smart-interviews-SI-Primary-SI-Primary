// https://www.hackerrank.com/contests/smart-interviews/challenges/si-collecting-water


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) throws Exception{
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t-->0){
            int n=Integer.parseInt(br.readLine());
            String st = br.readLine();
            String[] res = st.split(" ");
            int[] a = new int[n];
            for(int i=0;i<n;i++){
                a[i]=Integer.parseInt(res[i]);
            }
            
            int p1=0,p2=n-1,        total=0;
            int lmax=a[0],rmax=a[n-1];
            while(p1<p2){
                if(a[p1]<a[p2]){
                    p1++;
                    lmax=Math.max(lmax,a[p1]);
                    total+=lmax-a[p1];
                }else{
                    p2--;
                    rmax=Math.max(rmax,a[p2]);
                    total+=rmax-a[p2];
                }              
            }
            System.out.println(total);
        }
        
    }
    
}