// https://www.hackerrank.com/contests/smart-interviews/challenges/si-equal-0s-and-1s/problem



import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t-->0){
            int n=Integer.parseInt(br.readLine());
            
            String st=br.readLine();
            String[] res = st.split(" ");
            int[] a =new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(res[i]);
            }
            int[] p = new int[n];
            int s=0;
            int max=0;
            HashMap<Integer,Integer> map = new HashMap<>();
            map.put(0,-1);
            for(int i=0;i<n;i++){
                if(a[i]==0)
                    s+=-1;
                else
                    s+=1;
                if(!map.containsKey(s))
                    map.put(s,i);
                else{
                    max=Math.max(max,i-map.get(s));
                }
            }
            
            System.out.println(max);
            
        }
    }
}