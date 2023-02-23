// https://www.hackerrank.com/contests/smart-interviews/challenges/si-find-first-repeating-character/problem


import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // to move to the next line
        while (t-- > 0) {
            String s = sc.nextLine();
            boolean flag = false;
            for (char c : s.toCharArray()) {
                if (s.indexOf(c) != s.lastIndexOf(c)) {
                    System.out.println(c);
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                System.out.println('.');
            }
        }
    }
}



/*
We create a boolean variable flag and initialize it to false. This variable is used to keep track of whether we have found a repeating character or not.

We use a for-each loop to iterate through each character c in the string s.

For each character c, we check if it is a repeating character by checking if the index of the first occurrence of c in s is different from the index of the last occurrence of c in s.

If the indices are different, we have found a repeating character,We also set the value of flag to true to indicate that we have found a repeating character
*/