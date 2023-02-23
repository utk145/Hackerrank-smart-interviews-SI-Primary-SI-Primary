//  https://www.hackerrank.com/contests/smart-interviews/challenges/si-count-set-bits/problem 



import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            long n=sc.nextLong();
            System.out.println(sol(n));
        }
    }

    static int sol(long n){
        int count=0;
        while(n!=0){
            if((n&1)==1)
                count++;
            n=n>>1;
        }
        return count;
    }

}