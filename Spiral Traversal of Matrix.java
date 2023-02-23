// https://www.hackerrank.com/contests/smart-interviews/challenges/si-spiral-traversal-of-matrix



import java.io.*;
import java.util.*;


public class Solution {

	public static void spiraltraversal(int[][] ar, int start, int end, int ar_size, int cycle_count) {
		int i = start, j = end, n = ar_size;
		//we start from ar[0][0] position in the matrix  
		//first part of traversal:from left to right
		while (j < n - 1) {
			System.out.print(ar[i][j] + " ");
			j++;
		}
		//second part of traversal:from top to down
		while (i < n) {
			System.out.print(ar[i][j] + " ");
			i++;
		}
		//third part of traversal: from bottom left to bottom right
		i--;
		j--;

		while (j >= ar.length - n) {
			System.out.print(ar[i][j] + " ");
			j--;
		}

		i--;
		j++;

		while (i > cycle_count) {
			System.out.print(ar[i][j] + " ");
			i--;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t != 0) {
			int n = sc.nextInt();
			int[][] ar = new int[n][n];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					ar[i][j] = sc.nextInt();
				}
			}

			int a = ar.length;
			int x = 0;
			int no_of_cycles = ar.length / 2;

			for (int s = 0; s < no_of_cycles; s++) {
				spiraltraversal(ar, s, s, a, x);
				x++;
				a--;
			}

			if (ar.length % 2 != 0)
				System.out.print(ar[ar.length / 2][ar.length / 2]);
			System.out.println();
			t--;
		}
	}
}