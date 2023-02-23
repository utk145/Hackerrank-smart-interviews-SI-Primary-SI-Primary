// https://www.hackerrank.com/contests/smart-interviews/challenges/si-triple-trouble/problem



import java.io.*;
import java.util.*;


public class Solution {

    static boolean checkBit(int u,int x){
        return ((u>>x)&1)==1;
    }


    static int solution(int a[],int n){
        int ans=0;
        for(int b=0;b<=30;b++){
            int c=0;
            for(int i=0;i<n;i++){
                if(checkBit(a[i],b))
                    c++;
            }
            if(c%3==1)
                ans+=(1<<b);
        }
        return ans;
            
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int[] a = new int[n];
            for(int m=0;m<n;m++){
                a[m]=sc.nextInt();
            }
            System.out.println(solution(a,n));
        }
    }
}
