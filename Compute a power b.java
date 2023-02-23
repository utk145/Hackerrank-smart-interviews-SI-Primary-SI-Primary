// https://www.hackerrank.com/contests/smart-interviews/challenges/si-compute-a-power-b/problem



import java.io.*;
import java.util.*;

public class Solution {

    static boolean checkBit(int u,int x){
        return ((u>>x)&1)==1;
    }
       
          
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();
        int m = (int)1e9+7;
        while(t-->0){
            int a = sc.nextInt();
            int n = sc.nextInt();
        long ans=1;
        long x=a;
        for(int i=0;i<=30;i++){
            if(checkBit(n,i))
                ans=(ans*x)%m;
            x=(x*x)%m;
        }
            System.out.println(ans);
        }
        
    
    }
}
