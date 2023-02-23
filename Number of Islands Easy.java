// https://www.hackerrank.com/contests/smart-interviews/challenges/si-number-of-islands


import java.io.*;
import java.util.*;
class Pair{
    int a;
    int b;
    public Pair(int a,int b){
        this.a=a;
        this.b=b;
    }
}
public class Solution {
    public static void bfs(char[][] mat,int v,int e,int i,int j){
        mat[i][j]=0;
        Queue<Pair> q=new LinkedList<Pair>();
        q.add(new Pair(i,j));
        while(!q.isEmpty()){
            int row=q.peek().a;
            int col=q.peek().b;
            q.remove();
            for(int di=-1;di<=1;di++){
                for(int dj=-1;dj<=1;dj++){
                    int nrow=row+di;
                    int ncol=col+dj;
                    if(nrow>=0&&nrow<v&&ncol>=0&&ncol<e&&mat[nrow][ncol]=='1'){
                        mat[nrow][ncol]=0;
                        q.add(new Pair(nrow,ncol));
                    }
                        
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int v=sc.nextInt();
            int e=sc.nextInt();
            char mat[][]=new char[v][e];
            String s[]=new String[v];
            sc.nextLine();
            for(int i=0;i<v;i++)
                s[i]=sc.nextLine();
            for(int i=0;i<v;i++){
                for(int j=0;j<e;j++){
                    mat[i][j]=s[i].charAt(j);
                }
            }
            int c=0;
            for(int i=0;i<v;i++){
                for(int j=0;j<e;j++){
                    if(mat[i][j]=='1'){
                        c++;
                        bfs(mat,v,e,i,j);
                    }
                }
            }
            System.out.println(c);
        }
   }
}