// https://www.hackerrank.com/contests/smart-interviews/challenges/si-kmp-string-matching-algorithm/problem


import java.util.Scanner;

public class KMPSubstringCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine(); // Consume the newline after reading T

        while (t-- > 0) {
            String[] input = scanner.nextLine().split(" ");
            String A = input[0];
            String B = input[1];

            int occurrences = countOccurrences(A, B);
            System.out.println(occurrences);
        }

        scanner.close();
    }

    static int countOccurrences(String pattern, String text) {
        int m = pattern.length();
        int n = text.length();

        int[] lps = computeLPSArray(pattern);
        int count = 0;

        int i = 0; // index for text
        int j = 0; // index for pattern

        while (i < n) {
            if (pattern.charAt(j) == text.charAt(i)) {
                j++;
                i++;
            }

            if (j == m) {
                // Pattern found, increment count and reset j
                count++;
                j = lps[j - 1];
            } else if (i < n && pattern.charAt(j) != text.charAt(i)) {
                // Mismatch, move j to the previous position using lps array
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return count;
    }

    static int[] computeLPSArray(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];
        int len = 0;
        int i = 1;

        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }
}

//  O(T*(N+M))
/* 

ComputeLPSArray Function: 
- This function calculates the Longest Proper Prefix which is also a Suffix (LPS) array for the given pattern.
- The LPS array is used to determine the position to jump to in case of a mismatch during the pattern matching process.

CountOccurrences Function:
- This function performs the actual pattern matching using the KMP algorithm.
- It iterates through the text and the pattern, adjusting the pointers based on the LPS array when a mismatch occurs.
- When a match is found, the count is incremented.

*/
