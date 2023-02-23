// https://www.hackerrank.com/contests/smart-interviews/challenges/si-rotation-of-matrix



import java.io.*;
import java.util.*;


public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t > 0) {
			for (int w = 1; w <= t; w++) {
				System.out.printf("Test Case #%d:\n", w);

				int n = sc.nextInt();
				int[][] a = new int[n][n];

				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						a[i][j] = sc.nextInt();
					}
				}

				for (int i = 0; i < n; i++) {
					for (int j = n - 1; j >= 0; j--) {
						System.out.print(a[j][i] + " ");
					}

					System.out.println();
				}

			}

			break;
		}
	}
}