// https://www.hackerrank.com/contests/smart-interviews/challenges/si-exclusion-product

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {

     Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n= sc.nextInt();
            long[] ar = new long[n];
            for(int i=0;i<n;i++){
                ar[i] = sc.nextLong();
            }
            long m = (long)1e9 + 7;
            long[] p = new long[n];
            p[0] = (ar[0])%m;
            for(int i=1;i<n;i++){
                p[i] = (((p[i-1])%m)*((ar[i])%m))%m;
            }
            long[] s = new long[n];
            s[n-1] = (ar[n-1])%m;;
            for(int i=n-2;i>=0;i--){
                s[i] = (((s[i+1])%m)*((ar[i])%m))%m;
            }
            long[] B = new long[n];
            B[0] = (s[1])%m;
            B[n-1] = p[n-2]%m;
            for(int i=1;i<=n-2;i++){
                B[i] = (((p[i-1])%m)*((s[i+1])%m))%m;
            }
            for(int i=0;i<n;i++){
                System.out.print(B[i]%m+" ");
            }
            System.out.println();
        }
    
    }
}


/*
    EXPLANATION:

    An array p is created to store the prefix products of ar, where p[i] is the product of elements from ar[0] to ar[i].
    An array s is created to store the suffix products of ar, where s[i] is the product of elements from ar[i] to ar[n-1].
    An array B is created to store the final result. The first element of B is set to s[1], the last element is set to p[n-2], and the rest of the elements are calculated as B[i] = p[i-1] * s[i+1]. The modulo operation is applied to each element of B to prevent overflow.


 */
