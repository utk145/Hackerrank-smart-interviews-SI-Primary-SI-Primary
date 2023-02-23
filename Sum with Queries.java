// https://www.hackerrank.com/contests/smart-interviews/challenges/si-sum-with-queries


import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
 Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int a[]=new int[n];
            long sum=0;
            for(int i=0;i<n;i++)
            {
                a[i]=sc.nextInt();
                sum=sum+a[i];
            }
            //System.out.println(sum);
            int q=sc.nextInt();
            while(q-->0)
            {
                long i=sc.nextInt();
                int j=sc.nextInt();
                int x=sc.nextInt();
                sum+=(j-1L*i+1)*x;
            }
            System.out.println(sum);
        }    
    }
}