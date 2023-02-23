// https://www.hackerrank.com/contests/smart-interviews/challenges/si-check-anagrams/problem


import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-->0) {
            String s1 = sc.next();
            String s2 = sc.next();
            char[] ss1 = s1.toCharArray();
            char[] ss2 = s2.toCharArray();
            Arrays.sort(ss1);
            Arrays.sort(ss2);
            if (Arrays.equals(ss1, ss2)) {
                System.out.println("True");
            } else {
                System.out.println("False");
            }
        }
    
    }
}