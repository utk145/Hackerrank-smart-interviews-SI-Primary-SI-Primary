// https://www.hackerrank.com/contests/smart-interviews/challenges/si-compute-factorial



import java.io.*;
import java.util.*;

public class Solution {
    static long m = (long)1e9+7;
    static int tmp = 10000001;
    static long[] f = new long[tmp];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        f[0]=1;
            for(int i=1;i<tmp;i++){
                f[i]=(f[i-1]%m *i)%m;
            }
        while(t-->0){
            int n = Integer.parseInt(br.readLine());
            bw.write(f[n]+"\n");
        }
        bw.flush();
        bw.close();
    }
}