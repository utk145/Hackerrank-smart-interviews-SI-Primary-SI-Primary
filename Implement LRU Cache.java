// https://www.hackerrank.com/contests/smart-interviews/challenges/si-implement-lru-cache


import java.io.*;
import java.util.*;

public class Solution {
  static class Node {
    int data;
    Node prev, next;
    Node(int data) {
      this.data = data;
      this.prev = this.next = null;
    }
  }
  public static void main(String[] args) throws NullPointerException {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t--> 0) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int[] ar = new int[n];
      for (int i = 0; i < n; i++) ar[i] = sc.nextInt();
      HashMap < Integer, Node > map = new HashMap < > ();
      Node dummy = new Node(-1);
      Node tail = dummy;
      dummy.prev = null;
      int i = 0;
      while (i < n) {
        //hit
        if (map.containsKey(ar[i])) {
          if (map.get(ar[i]) != tail) {
            Node curr = map.get(ar[i]);
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;
            tail.next = curr;
            curr.prev = tail;
            curr.next = null;
            tail = tail.next;
          }
        } else {
          //miss and the cache is not full
          if (map.size() < k) {
            Node curr = new Node(ar[i]);
            tail.next = curr;
            curr.prev = tail;
            tail = tail.next;
            map.put(ar[i], curr);
          }
          //miss and the cache is full
          else {
            map.remove(dummy.next.data);
            Node nn = new Node(ar[i]);
            if (dummy.next.next != null) {
              dummy.next = dummy.next.next;
              dummy.next.prev = dummy;
              tail.next = nn;
              nn.prev = tail;
              tail = tail.next;
              map.put(ar[i], nn);
            } else {
              dummy.next = null;
              tail = dummy;
              tail.next = nn;
              nn.prev = tail;
              nn.next = null;
              tail = nn;
              map.put(ar[i], nn);
            }
          }
        }
        i++;
      }

      Node head = dummy.next;
      Node present = head;
      while (present != null) {
        System.out.print(present.data + " ");
        present = present.next;
      }
      System.out.println();
    }
  }
}