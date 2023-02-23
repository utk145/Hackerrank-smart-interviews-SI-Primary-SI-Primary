// https://www.hackerrank.com/contests/smart-interviews/challenges/si-window-maximum

import java.io.*;
import java.util.*;

public class Solution {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    while (t--> 0) {

      StringTokenizer str = new StringTokenizer(br.readLine());

      int n = Integer.parseInt(str.nextToken());
      int k = Integer.parseInt(str.nextToken());
      int[] ar = new int[n];
      StringTokenizer str2 = new StringTokenizer(br.readLine());
      for (int i = 0; i < n; i++) ar[i] = Integer.parseInt(str2.nextToken());
      Deque < Integer > dq = new LinkedList < > ();
      int sum = 0;
      for (int i = 0; i < k; i++) { // for the first window of size k
        while (dq.size() > 0 && ar[i] > dq.getFirst()) {
          dq.removeFirst();
        }
        dq.addFirst(ar[i]);
      }
      sum += dq.getLast();

      // for the other windows 
      for (int i = k; i < n; i++) {
        while (dq.size() > 0 && ar[i] > dq.getFirst()) {
          dq.removeFirst();
        }
        dq.addFirst(ar[i]);
        if (ar[i - k] == dq.getLast())
          dq.removeLast();
        sum += dq.getLast();
      }

      System.out.println(sum);

    }

  }
}


/*
  EXPLANATION:

  The given problem can be solved using a deque data structure, which supports constant time insertion and removal from both ends. We can maintain a deque of size K, where the front of the deque always contains the maximum element of the current window. Whenever we move the window, we remove the first element of the deque if it is no longer in the window and insert the new element at the back of the deque. The last element of the deque always contains the maximum element of the current window.

  In the given code, we first read the input values of N, K and the array of integers. We then create an empty deque and initialize it with the first window of size K. We use a while loop to remove all the elements from the front of the deque that are smaller than the current element, as they are no longer useful. We then insert the current element at the front of the deque. We repeat this process for the entire array to find the maximum element of each window.

  We also maintain a sum variable to store the sum of the maximum elements of all the windows. For the first window, we add the last element of the deque to the sum. For the subsequent windows, we add the last element of the deque after removing the last element of the previous window if it was the maximum element.

  Finally, we output the sum of the maximum elements of all the windows.



  Time Complexity:
  The time complexity of the above solution is O(N), where N is the size of the input array. This is because we traverse the array only once and maintain the deque of size K for each window. The worst-case space complexity of the solution is O(K), where K is the size of the deque.


 */