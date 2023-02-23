// https://www.hackerrank.com/contests/smart-interviews/challenges/si-path-in-a-matrix


import java.io.*;
import java.util.*;

public class Solution {
    static int mod=(int)1e9+7;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-->0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int b = sc.nextInt();
        
            long[][] dp = new long[n+1][m+1];
           for(long[] rows:dp){
               Arrays.fill(rows,-1);
           }
            dp[1][1]=1; // Base Condition
            for(int i=0;i<b;i++){
               int x=sc.nextInt();
               int y=sc.nextInt();
                dp[x+1][y+1]=0;
            }
            
        
            for(int i=0;i<=n;i++){
                dp[i][0]=0;
            }
            for(int i=0;i<=m;i++){
                dp[0][i]=0;
            }
            
            for(int i=1;i<=n;i++){
                for(int j=1;j<=m;j++){
                    if(dp[i][j]==-1){
                        dp[i][j]=(dp[i-1][j]+dp[i][j-1]+dp[i-1][j-1])%mod;
                    }
                }
            }
            System.out.println(dp[n][m]);
        }
    
    }
    
    
}