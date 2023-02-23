// https://www.hackerrank.com/contests/smart-interviews/challenges/si-collect-apples


import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    while (t-->0) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int[][] a = new int[n][m];
      for(int i=0; i<n; i++){
        for(int j = 0; j<m; j++){
            a[i][j] = sc.nextInt();
        }
      }

      int[][] dp = new int[n][m];
//       Base Condition  
      dp[0][0] = a[0][0];
      for(int i=1; i<n; i++) {
            dp[i][0] = dp[i-1][0] + a[i][0];
      } 
      for(int j=1; j<m; j++) {
            dp[0][j] = dp[0][j-1] + a[0][j];
      }
        
        
      for(int i=1; i<n; i++) {
        for(int j=1; j<m; j++) {
          dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + a[i][j];
        }
      }

      System.out.println(dp[n-1][m-1]);
        
    }
  }
}


/* EXPLANATION:

    the dp[i][j] is filled by choosing the max between the number of apples that can be collected from the cell above it and the cell to the left of it, and adding the number of apples in the current cell.The ans is at :  dp[n-1][m-1]

*/