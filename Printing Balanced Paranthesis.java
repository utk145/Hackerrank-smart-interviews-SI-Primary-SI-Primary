// https://www.hackerrank.com/contests/smart-interviews/challenges/si-printing-balanced-paranthesis/problem



import java.io.*;
import java.util.*;

public class Solution {

    private static int len;
    public static void generate(ArrayList<String> str,int open,int close,int n,int idx,char[] p){
        if(idx==n){
            String cc = "";
            for(int i=0;i<n;i++){
                cc+=p[i];
            }
            str.add(cc);
        }
        if(open<n/2){
            p[idx] = '{';
            generate(str,open+1,close,n,idx+1,p);
        }
        if(close<open){
            p[idx] = '}';
            generate(str,open,close+1,n,idx+1,p);
        }
    }
    public static String[] generateParenthesis(int A) {
        ArrayList<String> str = new ArrayList<>();
        char[] p = new char[2*A];
        generate(str,0,0,2*A,0,p);
        String[] ans = new String[str.size()];
        len = str.size();
        for(int i=0;i<str.size();i++){
            ans[i] = str.get(i);
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=1;i<=t;i++){
            int n = sc.nextInt();
            String[] str = new String[len];
            str = generateParenthesis(n);
            System.out.println("Test Case #"+i+":");
            for(String s:str) {
                System.out.println(s);
            }
        }
    }
}



/*
    EXPLANATION:


    The main logic of the program is in the generateParenthesis function. This function takes an integer A as input, which represents the length of the balanced parentheses strings to be generated. The function creates an ArrayList of strings called str to store the generated strings. It also creates a character array p of length 2*A, which will be used to generate the strings recursively.

    The generate function is a recursive function that generates all possible combinations of balanced parentheses strings. It takes six inputs: an ArrayList of strings str, two integers open and close, an integer n, an integer idx, and a character array p. The open and close parameters keep track of the number of opening and closing parentheses that have been used so far, while the n parameter is the length of the string being generated. The idx parameter keeps track of the current position in the p array that is being filled.

    The generate function works as follows:

    If the current index (idx) is equal to the length of the string (n), it means we have generated a complete string, so we add it to the str list.
    If the number of opening parentheses used so far (open) is less than half the length of the string (n/2), we can add an opening parenthesis to the current position (idx) in the p array and make a recursive call to generate with open+1, close, and idx+1.
    If the number of closing parentheses used so far (close) is less than the number of opening parentheses used so far (open), we can add a closing parenthesis to the current position (idx) in the p array and make a recursive call to generate with open, close+1, and idx+1.
    Finally, the generateParenthesis function calls the generate function with initial parameters of 0, 0, 2*A, 0, and p. It then converts the ArrayList of strings str into an array of strings ans and returns it.

 */