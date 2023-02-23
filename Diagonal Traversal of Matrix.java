// https://www.hackerrank.com/contests/smart-interviews/challenges/si-diagonal-traversal-of-matrix



import java.io.*;
import java.util.*;


public class Solution {

	public static int returnsumof(int[][] array_name, int array_size, int dth_diag) {
		int sum = 0;
		int j = array_size - dth_diag;
		int i = 0;

		if (dth_diag <= array_size) {
			while (j <= array_size - 1) {
				sum += array_name[i][j];
				j++;
				i++;
			}
		} else {
			j = dth_diag - array_size;
			i = 0;

			while (j <= array_size - 1) {
				sum += array_name[j][i];
				j++;
				i++;
			}
		}

		return sum;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t--> 0) {
			int n = sc.nextInt();
			int[][] arr = new int[n][n];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			int[] diag_sum = new int[(2 * n) - 1];

			for (int s = 1; s <= (2 * n) - 1; s++) {
				diag_sum[s - 1] = returnsumof(arr, n, s);
				System.out.print(diag_sum[s - 1] + " ");
			}

			System.out.print("\n");

		}
	}
}