package searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * Q1. Minimum Difference
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

You are given a 2-D matrix C of size A � B.
You need to build a new 1-D array of size A by taking one element from each row of the 2-D matrix in such a way that the cost of the newly build array is minimized.

Cost of an array is the minimum possible value of the absolute difference between any two adjacent elements of the array.

So if the newly built array is X, element picked from row 1 will become X[1], element picked from row 2 will become X[2], and so on.

Determine the minimum cost of the newly build array.



Problem Constraints

2 <= A <= 1000
2 <= B <= 1000
1 <= C[i][j] <= 106



Input Format

The first argument is an integer A denoting number of rows in the 2-D array.
The second argument is an integer B denoting number of columns in the 2-D array.
The third argument is a 2-D array C of size A x B.



Output Format

Return an integer denoting the minimum cost of the newly build array.



Example Input

Input 1:

 A = 2
 B = 2
 C = [ [8, 4]
      [6, 8] ]
Input 2:

 A = 3
 B = 2
 C = [ [7, 3]
       [2, 1]
       [4, 9] ]


Example Output

Output 1:

 0
Output 2:

 1


Example Explanation

Explanation 1:

 Newly build array : [8, 8]. The minimum cost will be 0 since the absolute difference will be 0(8-8).
Explanation 2:

 Newly build array : [3, 2, 4]. The minimum cost will be 1 since the minimum absolute difference will be 1(3 - 2).
 */

public class MinimumDifference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<List<Integer>> C = new ArrayList();
		C.add(Arrays.asList(new Integer[] { 7, 3 }));
		C.add(Arrays.asList(new Integer[] { 2, 1 }));
		C.add(Arrays.asList(new Integer[] { 4, 9 }));
		System.out.println(solve(C.size(), C.get(0).size(), C));
	}

	public static int solve(int A, int B, ArrayList<List<Integer>> C) {
		for (int i = 0; i < A; i++) {
			Collections.sort(C.get(i));
		}
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < A - 1; i++) {
			for (int j = 0; j < B; j++) {
				int l = 0, r = B - 1;
				int mid = 0;
				while (l <= r) {
					mid = l + (r - l) / 2;
					if (C.get(i + 1).get(mid).equals(C.get(i).get(j))) {
						ans = Math.min(ans, Math.abs(C.get(i + 1).get(mid) - C.get(i + 1).get(j)));
						break;
					} else if (C.get(i).get(j).compareTo(C.get(i + 1).get(mid)) > 0) {
						l = mid + 1;
					} else {
						r = mid - 1;
					}
				}

				if (l >= B) {
					ans = Math.min(ans, Math.abs(C.get(i).get(j) - C.get(i + 1).get(r)));
				} else if (r < 0) {
					ans = Math.min(ans, Math.abs(C.get(i).get(j) - C.get(i + 1).get(l)));
				} else {
					ans = Math.min(ans, Math.min(Math.abs(C.get(i).get(j) - C.get(i + 1).get(l)),
							Math.abs(C.get(i).get(j) - C.get(i + 1).get(r))));
				}
			}
		}
		return ans;
	}

}
