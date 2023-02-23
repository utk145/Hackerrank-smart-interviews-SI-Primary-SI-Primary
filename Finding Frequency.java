// https://www.hackerrank.com/contests/smart-interviews/challenges/si-finding-frequency/problem


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        MS(a,0,n-1);
        int q=sc.nextInt();
        while(q-->0){
            int x = sc.nextInt();
            System.out.println(frequency(a,n,x));
        }   
    
    }
    static int BS1(int[] a,int n,int x){
        int low=0,high=n-1,p1=0;
        int mid=0;
        while(low<=high){
            mid=low-(low-high)/2;
            if(a[mid]<x){
                low=mid+1;
            }else if(a[mid]>x){
                high=mid-1;
            }else{
                p1=mid;
                high=mid-1;
            }   
        }
        return p1;
    }
    static int BS2(int[] a,int n,int x){
        int low=0,high=n-1,p2=-1;
        int mid=0;
        while(low<=high){
            mid=low-(low-high)/2;
            if(a[mid]<x){
                low=mid+1;
            }else if(a[mid]>x){
                high=mid-1;
            }else{
                p2=mid;
                low=mid+1;
            }   
        }
        return p2;
    }
    static int frequency(int[]a,int n,int x){
        return (BS2(a,n,x) - BS1(a,n,x) +1);
    }
    public static void MS(int[] ar,int low,int high){
        if(low==high)
            return;
        int mid=(low+high)/2;
        MS(ar,low,mid);
        MS(ar,mid+1,high);
        merge(ar,low,mid,high);
    }
    public static void merge(int[] ar,int low,int mid,int high){
        int i=low,j=mid+1,k=0;
        int[] temp=new int[high-low+1];
        while(i<=mid && j<=high){
            if(ar[i]<ar[j])
                temp[k++]=ar[i++];
            else
                temp[k++]=ar[j++];
        }
        while(i<=mid)
            temp[k++]=ar[i++];
        while(j<=high)
            temp[k++]=ar[j++];
        for(int a=low;a<=high;a++)
            ar[a]=temp[a-low];
    }
}


/* EXPLANATION:

The given code is for finding the frequency of a given number in a sorted array using binary search.

The program first sorts the array in ascending order using merge sort by calling the function MS.

Then, for each query, the program calls the function frequency which takes the sorted array a, its size n, and the number whose frequency is to be found x as inputs.

The frequency function first calls another function BS1 which performs a binary search to find the leftmost occurrence of x in the array a. The BS1 function returns the index of the leftmost occurrence of x.

Then, the frequency function calls another function BS2 which performs a binary search to find the rightmost occurrence of x in the array a. The BS2 function returns the index of the rightmost occurrence of x.

Finally, the frequency of x in the array a is calculated as (BS2(a,n,x) - BS1(a,n,x) + 1) and returned to the main function where it is printed. To find the frequency of x, we can subtract the index of the first occurrence of x from the index of the last occurrence of x, and then add 1 to the result to include the last occurrence of x in the frequency count. So the expression (BS2(a,n,x) - BS1(a,n,x) + 1) calculates the frequency of x in the given array a

The binary search algorithm works by dividing the array in half repeatedly until the target element is found or it is clear that the target element is not in the array. The BS1 function is used to find the leftmost occurrence of x by repeatedly dividing the array in half and checking if a[mid] is equal to x. If it is, then p1 is set to the index mid and the search continues on the left subarray. If a[mid] is less than x, the search continues on the right subarray, and if a[mid] is greater than x, the search continues on the left subarray. The BS2 function works similarly, except it searches for the rightmost occurrence of x.

Overall, this algorithm has a time complexity of O(q*log(n)), where q is the number of queries and n is the size of the array.



*/