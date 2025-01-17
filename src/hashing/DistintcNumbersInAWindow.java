package hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
 * Q5. Distinct Numbers in Window
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

You are given an array of N integers, A1, A2 ,�, AN and an integer B. Return the of count of distinct numbers in all windows of size B.

Formally, return an array of size N-B+1 where i'th element in this array contains number of distinct elements in sequence Ai, Ai+1 ,..., Ai+B-1.

NOTE: if B > N, return an empty array.



Input Format

First argument is an integer array A
Second argument is an integer B.



Output Format

Return an integer array.



Example Input

Input 1:

 A = [1, 2, 1, 3, 4, 3]
 B = 3
Input 2:

 A = [1, 1, 2, 2]
 B = 1


Example Output

Output 1:

 [2, 3, 3, 2]
Output 2:

 [1, 1, 1, 1]


Example Explanation

Explanation 1:

 A=[1, 2, 1, 3, 4, 3] and B = 3
 All windows of size B are
 [1, 2, 1]
 [2, 1, 3]
 [1, 3, 4]
 [3, 4, 3]
 So, we return an array [2, 3, 3, 2].
Explanation 2:

 Window size is 1, so the output array is [1, 1, 1, 1].

 */

public class DistintcNumbersInAWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> ans = dNums(
				Arrays.asList(new Integer[] {1, 2, 1, 3, 4, 3 }), 3);
		for(Integer i: ans) {
			System.out.print(i+",");
		}
	}
	
	public static ArrayList<Integer> dNums(List<Integer> A, int B) {
        HashMap<Integer, Integer> map = new HashMap();
        for(int i=0; i<B; i++){
            if(map.get(A.get(i)) == null){
                map.put(A.get(i), 1);
            }else{
                map.put(A.get(i), map.get(A.get(i))+1);
            }
        }

        // int uniqueElementsinWindow = map.size();
        ArrayList<Integer> ans = new ArrayList();
        if(B>A.size()){
            return ans;
        }
        ans.add(map.size());

        for(int i=B; i<A.size(); i++){
            //window adding incoming elements
            if(map.get(A.get(i)) == null){
                map.put(A.get(i), 1);
            }else{
                map.put(A.get(i), map.get(A.get(i))+1);
            }

            //outgoing elemnt;
            if(map.get(A.get(i-B)) == 1){
                map.remove(A.get(i-B));
            }else{
                map.put(A.get(i-B), map.get(A.get(i-B))-1);
            }
            ans.add(map.size());
        }

        return ans;
    }

}
