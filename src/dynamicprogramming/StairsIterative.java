package dynamicprogramming;

/*
 * Q2. Stairs
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

You are climbing a stair case and it takes A steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?



Problem Constraints

1 <= A <= 36



Input Format

The first and the only argument contains an integer A, the number of steps.



Output Format

Return an integer, representing the number of ways to reach the top.



Example Input

Input 1:

 A = 2
Input 2:

 A = 3


Example Output

Output 1:

 2
Output 2:

 3


Example Explanation

Explanation 1:

 Distinct ways to reach top: [1, 1], [2].
Explanation 2:

 Distinct ways to reach top: [1 1 1], [1 2], [2 1].


See Expected Output
 */
public class StairsIterative {

	public static void main(String[] args) {
		System.out.println(climbStairs(4));

	}
	
	public static int climbStairs(int A) {
		int[] dp = new int[A + 1];
		dp[1] = 1;
		dp[2] = 2;
		
		for(int i=3; i<=A; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		return dp[A];
	}


}
