// https://www.hackerrank.com/contests/smart-interviews/challenges/si-implement-stack

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] a = new int[t];
        int top = 0;
        while (t-- > 0) {
            String s = br.readLine();
            String[] res = s.split(" ");
            Stack < Integer > st = new Stack < > ();
            if (res[0].equals("push")) {
                int x = Integer.parseInt(res[1]);
                Push(a, top++, x);
            } else {
                if (isempty(a, top)) {
                    System.out.println("Empty");
                } else {
                    Pop(a, top);
                    top--;
                    System.out.println(Peek(a, top));
                }

            }

        }

    }
    static void Push(int[] a, int top, int ele) {
        a[top++] = ele;
    }
    static void Pop(int[] a, int top) {
        a[top] = 0;
        top--;
    }
    static int Peek(int[] a, int top) {
        return a[top];
    }
    static boolean isempty(int[] a, int top) {
        return top == 0;
    }

}