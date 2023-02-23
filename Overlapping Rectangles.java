// https://www.hackerrank.com/contests/smart-interviews/challenges/si-overlapping-rectangles

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0) {
            long a1 = sc.nextLong();
            long b1 = sc.nextLong();
            long a2 = sc.nextLong();
            long b2 = sc.nextLong();
            long A1 = sc.nextLong();
            long B1 = sc.nextLong();
            long A2 = sc.nextLong();
            long B2 = sc.nextLong();

            long rect1 = area(Math.abs(a1 - a2), Math.abs(b1 - b2));
            long rect2 = area(Math.abs(A1 - A2), Math.abs(B1 - B2));
            long x = Math.min(a2, A2) - Math.max(a1, A1);
            long y = Math.min(b2, B2) - Math.max(b1, B1);
            long co_area = 0;
            if(x > 0 && y > 0) {
                co_area = area(x, y);
            }
            System.out.println(rect1 + rect2 - co_area);
        }
    
    }
    public static long area(long a, long b) {
        return a * b;
    }
}



/*
The overlapping area of the two rectangles can be found by computing the intersection of the two rectangles. We can do this by first finding the length and width of the intersection, and then computing the area of the intersection.To find the length of the intersection, we need to find the minimum value of the right boundary (i.e. a2 and A2) minus the maximum value of the left boundary (i.e. a1 and A1). We do the same thing for the width, i.e. the minimum value of the top boundary (i.e. b2 and B2) minus the maximum value of the bottom boundary (i.e. b1 and B1).If either the length or width of the intersection is negative, it means that the rectangles do not overlap, and so the overlapping area is 0. If both the length and width of the intersection are positive, then we can compute the overlapping area as the product of the length and width.
*/