// https://www.hackerrank.com/contests/smart-interviews/challenges/si-lcm-and-hcf


import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            long gcd = gcd(a, b);
            long lcm = (a*b)/gcd;
            System.out.println(lcm + " " + gcd);
        }
    
    }
     static long gcd(long a, long b) {
        if(a == 0) 
            return b;
        return gcd(b%a, a);
    }
}