// https://www.hackerrank.com/contests/smart-interviews/challenges/si-rectangular-area-under-histogram


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t--> 0) {
      int n = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < n; i++) a[i] = sc.nextInt();
      //  we just have to find the next smaller element on right and next smaller element on left and their difference - 1 is the width required

      int[] rb = new int[a.length];
      Stack < Integer > st = new Stack < > ();
      st.push(a.length - 1);
      rb[a.length - 1] = a.length;
      for (int i = a.length - 2; i >= 0; i--) {
        while (st.size() > 0 && a[i] <= a[st.peek()]) {
          st.pop();
        }
        if (st.size() == 0) {
          rb[i] = a.length;
        } else {
          rb[i] = st.peek();
        }
        st.push(i);
      }

      int[] lb = new int[a.length];
      st = new Stack < > ();
      st.push(0);
      lb[0] = -1;
      for (int i = 1; i < a.length; i++) {
        while (st.size() > 0 && a[i] <= a[st.peek()]) {
          st.pop();
        }
        if (st.size() == 0) {
          lb[i] = -1;
        } else {
          lb[i] = st.peek();
        }
        st.push(i);
      }

      long maxArea = 0;
      for (int i = 0; i < a.length; i++) {
        int width = rb[i] - lb[i] - 1;
        maxArea = Math.max(a[i] * width, maxArea);

      }

      System.out.println(maxArea);

    }

  }
}



/*
    EXPLANATION:

    The provided code solves the problem of finding the largest rectangular area under a histogram using a stack-based approach. It first reads the input, which consists of the number of test cases, the number of buildings, and the height of each building. Then, for each test case, it computes the left and right boundaries of the largest rectangle that can be formed with each building as its height, using two stacks to keep track of the previous buildings with smaller heights.

    The first stack, st, is used to compute the right boundaries. It starts by pushing the last building's index, which has no buildings to its right. Then, it iterates through the remaining buildings from right to left, popping from the stack any building with a height greater than or equal to the current building until either the stack is empty or the top building has a smaller height. The current building's right boundary is set to the popped building's index if the stack is not empty, which means that there is a building to the right with a smaller height, or to the length of the histogram if the stack is empty, which means that all buildings to the right have a greater height.

    The second stack, also called st, is used to compute the left boundaries. It starts by pushing the first building's index, which has no buildings to its left. Then, it iterates through the remaining buildings from left to right, popping from the stack any building with a height greater than or equal to the current building until either the stack is empty or the top building has a smaller height. The current building's left boundary is set to the popped building's index minus one if the stack is not empty, which means that there is a building to the left with a smaller height, or to minus one if the stack is empty, which means that all buildings to the left have a greater height.

    Finally, the code computes the area of each rectangle that can be formed with each building as its height, using the difference between its right and left boundaries plus one as its width, and updates the maximum area found so far. The maximum area is printed after processing all test cases.

    Overall, the code has a time complexity of O(n), where n is the number of buildings, since it iterates through the buildings twice, once to compute the right boundaries and once to compute the left boundaries, and then once more to compute the area of each rectangle. The space complexity is also O(n), since it uses two stacks to store the indices of the previous buildings with smaller heights.

*/