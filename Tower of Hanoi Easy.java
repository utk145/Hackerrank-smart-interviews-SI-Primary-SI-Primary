// https://www.hackerrank.com/contests/smart-interviews/challenges/si-tower-of-hanoi


import java.io.*;
import java.util.*;
public class Tower{
    
    public static void main(String[] args){
         Scanner s=new Scanner(System.in);
         int t=s.nextInt();
         while(t-- > 0)
         {
                int n=s.nextInt();
                System.out.println((int)(Math.pow(2,n)-1));
                move(n,'A','B','C');
        }   
    }

    public static void move(int n,char A,char B, char C)
    {
        if(n==1)
        {
            System.out.println("Move " +n+ " from " +A+ " to " +C);
        }
        else
            {
                move(n-1,A,C,B);
                System.out.println("Move " +n+ " from " +A+ " to " +C);
                move(n-1,B,A,C);
            }
    }
    
}