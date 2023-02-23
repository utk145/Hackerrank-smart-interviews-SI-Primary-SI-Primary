// https://www.hackerrank.com/contests/smart-interviews/challenges/si-implement-min-heap





/*************************************************** IMPORTANT PROBLEM ********************************************************************* */ 




// Implementation 1 : Inbuilt

import java.io.*;
import java.util.*;

public class Solution {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    PriorityQueue < Integer > q = new PriorityQueue < > ();
    while (t--> 0) {
      String st = sc.next();
      if (st.equals("insert")) {
        int ele = sc.nextInt();
        q.add(ele);
      } else if (st.equals("getMin")) {
        if (!q.isEmpty()) {
          System.out.println(q.peek());
        } else {
          System.out.println("Empty");
        }
      } else {
        if (!q.isEmpty()) {
          q.poll();
        }
      }

    }

  }
}





// Implementation 2 : Manual

import java.io.*;
import java.util.*;

public class Solution {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    MinHeap q = new MinHeap();
    while (t--> 0) {
      String st = sc.next();
      if (st.equals("insert")) {
        int ele = sc.nextInt();
        q.insert(ele);
      } else if (st.equals("getMin")) {
        if (!q.isEmpty()) {
          System.out.println(q.getMin());
        } else {
          System.out.println("Empty");
        }
      } else {
        if (!q.isEmpty()) {
          q.delMin();
        }
      }
    }
  }
}

class MinHeap {
  private static ArrayList < Integer > hp = new ArrayList < > ();
  MinHeap() {
    hp = new ArrayList < > ();
  }
  public static void insert(int ele) {
    hp.add(ele);
    int indx = hp.size() - 1;
    //percolate
    while (((indx - 1) / 2 >= 0) && (hp.get((indx - 1) / 2) > hp.get(indx))) {
      swap(hp, indx, (indx - 1) / 2);
      indx = (indx - 1) / 2;
    }
  }
  public static int getMin() {
    // return hp.get(0);
    if (!hp.isEmpty()) {
      return hp.get(0);
    }
    return Integer.MIN_VALUE;
  }
  public static void delMin() {
    if (hp.size() == 0) {
      return;
    }
    hp.set(0, hp.get(hp.size() - 1));
    hp.remove(hp.size() - 1);
    int idx = 0, minIndex = -1;
    while (idx < (int) hp.size()) {
      minIndex = idx;
      if (2 * idx + 1 < (int) hp.size() && hp.get(minIndex) > hp.get(2 * idx + 1)) {
        minIndex = 2 * idx + 1;
      }
      if (2 * idx + 2 < (int) hp.size() && hp.get(minIndex) > hp.get(2 * idx + 2)) {
        minIndex = 2 * idx + 2;
      }
      swap(hp, minIndex, idx);
      if (minIndex == idx) {
        break;
      }
      idx = minIndex;
    }
  }
  public static void swap(ArrayList < Integer > list, int a, int b) {
    int el1 = list.get(a);
    int el2 = list.get(b);
    list.set(a, el2);
    list.set(b, el1);
  }
  public static boolean isEmpty() {
    return hp.size() == 0;
  }
}



