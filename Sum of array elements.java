// https://www.hackerrank.com/contests/smart-interviews/challenges/si-sum-of-array-elements



import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            long sum=0;
            while(n-->0){
                sum+=sc.nextLong();   
            }
            System.out.println(sum);
        }
        
        
    }
}