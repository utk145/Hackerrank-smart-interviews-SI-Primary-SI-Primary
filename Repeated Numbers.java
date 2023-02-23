// https://www.hackerrank.com/contests/smart-interviews/challenges/si-repeated-numbers/problem


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int[] a = new int[n];
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }
            MergeSort(a,0,n-1);
            for(int i=0;i<a.length-1;i++){
                if(a[i]==a[i+1]){
                    System.out.print(a[i]+" ");
                }
            }
            System.out.println();
        }
    
    }
        static void MergeSort(int[] a,int low,int high){
        if(low==high){
            return;
        }
        int mid=low-(low-high)/2;
        MergeSort(a,low,mid);
        MergeSort(a,mid+1,high);
        merge(a,low,mid,high);
    }
    static void merge(int[] a,int low,int mid,int high){
        int p1=low,p2=mid+1,k=0;
        int temp[] = new int[high-low+1];
        while(p1<=mid && p2<=high){
            if(a[p1]<a[p2]){
                temp[k++]=a[p1++];
            }else{
                temp[k++]=a[p2++];
            }
        }
        while(p1<=mid)
            temp[k++]=a[p1++];
        while(p2<=high)
            temp[k++]=a[p2++];
        //now we copy elements of temp into original array
        for(int i=low;i<=high;i++){
            a[i]=temp[i-low];
        }
    }

}
