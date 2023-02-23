// https://www.hackerrank.com/contests/smart-interviews/challenges/si-express-as-power-sum/problem



import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t =sc.nextInt();
        while(t-->0){
            int n =sc.nextInt();
            int k =sc.nextInt();
            System.out.println(sol(n,k,1,0));
        }
        
        
    }
     static int pow(int x, int n){
        if (n == 0)
            return 1;
        else if (n % 2 == 0)
            return pow(x, n / 2) * pow(x, n / 2);
        else
            return x * pow(x, n / 2)* pow(x, n / 2);
    }
    
    static int sol(int x, int n, int curr_num, int curr_sum){
        // x as nth powers of different natural numbers
        
            int ans = 0;

        int p = pow(curr_num, n);   //// Calling power of i raised to n
        while (p + curr_sum < x) {
            // Recursively checkking all greater values of i
            ans += sol(x, n, curr_num + 1,p + curr_sum);
            curr_num++;
            p = pow(curr_num, n);
        }

        // If sum of powers is equal to x then increase the value of result.
        if (p + curr_sum == x)
            ans++;

        return ans;
    }

}



/*
    EXPLANATION:


    The problem is to express a given number as a sum of distinct natural numbers to the power of k. Given an integer n and an integer k, the goal is to find the number of ways to express n as a sum of unique natural numbers to the power of k. The input contains a single integer t, the number of test cases, followed by t lines, each line containing two integers n and k.

    The solution involves a recursive approach where the function sol recursively checks for all possible values of i (natural numbers) whose kth power is less than x (the given number to be expressed as a sum of distinct natural numbers to the power of k). If the sum of the current power and the current sum is less than x, the function calls itself recursively with the next greater value of i and updates the sum accordingly. The function continues this until the sum of the current power and the current sum is greater than x. If the sum of the current power and the current sum is equal to x, it increments the result counter. The function pow is a simple recursive function to calculate the power of an integer.

    The approach here involves recursively checking all possible sums of distinct natural numbers to the power of k whose sum is equal to the given number n. For each recursive call, we check for all possible values of i until their kth power is less than the given number x. If the sum of the current power and the current sum is less than x, we update the sum and call the function recursively for the next value of i. If the sum of the current power and the current sum is equal to x, we increment the counter. We return the counter at the end.

 */