// https://www.hackerrank.com/contests/smart-interviews/challenges/si-clockwise-rotation-of-array

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int k=sc.nextInt();
            int[] a = new int[n];
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }
            int ans[] = new int[n];
            k=k%n;
            for(int i=n-k;i<n;i++){
                ans[i-(n-k)]=a[i];
            }
            for(int i=0;i<n-k;i++){
                ans[k+i]=a[i];
            }
            for(int i=0;i<n;i++){
                System.out.print(ans[i]+" ");
            }
            System.out.println();
        }
        
    }
}