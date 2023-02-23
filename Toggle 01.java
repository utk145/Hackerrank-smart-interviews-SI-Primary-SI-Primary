// https://www.hackerrank.com/contests/smart-interviews/challenges/si-toggle-01/problem


import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t-->0){
             StringTokenizer st  = new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());
            int q=Integer.parseInt(st.nextToken());
            TreeSet<Integer> tset=new TreeSet<Integer>();
            for(int i=0;i<q;i++){
                 StringTokenizer st1 = new StringTokenizer(br.readLine());
                int type=Integer.parseInt(st1.nextToken()); // query type
                int idx=Integer.parseInt(st1.nextToken());
                if(type==1){
                    if(!tset.contains(idx)){
                        tset.add(idx);
                    }
                    else{
                        tset.remove(idx);
                    }
                }
                else{
                   if(tset.ceiling(idx)==null && tset.floor(idx)==null)
                       System.out.println("-1");
                    else{
                        if(tset.floor(idx)!=null && tset.ceiling(idx)!=null)
                            System.out.println((int)Math.abs(Math.min(Math.abs(tset.ceiling(idx)-idx),Math.abs(tset.floor(idx)-idx))));
                        else if(tset.floor(idx)==null)
                            System.out.println((int)Math.abs(tset.ceiling(idx)-idx));
                        else
                            System.out.println((int)Math.abs(idx-tset.floor(idx)));
                    }
                }
            }
            
        }
    }
}

/*  EXPLANATION

 so basically used a treeset for storing the elements which have 1 in it
 we toggle 0-1 or 1-0 by  removing or adding the index to treeset
 1-0 means the element at index which was 1 recently(it  has 1 at that index means it is now present in treeset) so we toggle just by removing that index from the treeset(an index not being there in treeset means that it has 0 at that index)
 this is type  1 query


 type 2 means finding index of closest 1 to the index in query
 so in treeset only indexes at which one is there is present na
 so from that index just find floor or ceil and calculate difference which one is closeer
 if ceil is null (last element in set) floor is the ans and if floor is null(first element in set)  ceil is the answer .if both are null (only one element in set) '-1' is the answer.se

*/