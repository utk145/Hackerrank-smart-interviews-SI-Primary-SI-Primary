// https://www.hackerrank.com/contests/smart-interviews/challenges/si-collecting-mangoes


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int cnt = 1;
        while (t-- > 0) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(str.nextToken());
            System.out.println("Case " + cnt + ":");
            cnt++;
            Stack < Long > stack = new Stack <> ();
            Stack < Long > max = new Stack <> ();
            while (n-- > 0) {
                String s = br.readLine();
                String[] input = s.split(" ");
                // A is push
                // Q is getMax
                // R is pop
                if (input[0].equals("A")) {
                    long ele = Integer.parseInt(input[1]);
                    if (max.isEmpty())
                        max.add(ele);
                    else {
                        if (ele > max.peek()) {
                            max.push(ele);
                        } else {
                            max.push(max.peek());
                        }
                    }
                    stack.push(ele);
                } else if (input[0].equals("R")) {
                    if (stack.isEmpty()) {
                        continue;
                    } else {
                        max.pop();
                        stack.pop();
                    }
                } else if (input[0].equals("Q")) {
                    if (max.isEmpty()) {
                        System.out.println("Empty");
                    } else {
                        System.out.println(max.peek());
                    }
                }
            }
        }
    }
}



/*
    EXPLANATION:

    When Mina picks up a mango of size x, the program adds x to the stack and updates another stack called "max" that keeps track of the maximum size of mango in the basket at any given time. If the "max" stack is empty, the program adds the new mango size to it. If not, the program checks if the new mango size is greater than the current maximum size in the "max" stack. If it is, the program adds the new mango size to the "max" stack. If it is not, the program adds the current maximum size to the "max" stack.

    If Mina decides to throw out the last picked up mango, the program simply removes the last mango from the stack and updates the "max" stack accordingly.

    If Mina asks for the biggest mango size in the basket at that moment, the program simply returns the top element of the "max" stack.

    The program also handles cases where the basket is empty and returns an appropriate message. 


*/