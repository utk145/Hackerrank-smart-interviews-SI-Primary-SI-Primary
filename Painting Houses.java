// https://www.hackerrank.com/contests/smart-interviews/challenges/si-painting-houses


import java.io.*;
import java.util.*;

public class Solution {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
         int n=sc.nextInt();
            int[] r = new int[n];
            int[] g = new int[n];
            int[] b = new int[n];
            for(int i=0;i<n;i++){
                r[i]=sc.nextInt();
            }
             for(int i=0;i<n;i++){
                g[i]=sc.nextInt();
            }
             for(int i=0;i<n;i++){
                b[i]=sc.nextInt();
            }
    
            int[] dpr = new int[n];
            int[] dpg = new int[n];
            int[] dpb = new int[n];
            
            // Base condition
            dpr[0]=r[0];
            dpg[0]=g[0];
            dpb[0]=b[0];
            
            // ith state and dp expression
            for(int i=1;i<n;i++){
                dpr[i]=Math.min(dpg[i-1],dpb[i-1])+r[i];
                dpg[i]=Math.min(dpr[i-1],dpb[i-1])+g[i];
                dpb[i]=Math.min(dpg[i-1],dpr[i-1])+b[i];
                
            }
            
            // Ans
            System.out.println(Math.min(Math.min(dpr[n-1],dpg[n-1]),dpb[n-1]));
            
        }
    }
}