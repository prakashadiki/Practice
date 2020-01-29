package practice;

import java.util.TreeSet;

public class Solution {

	public int[] twoSum(int[] nums, int target) {
		TreeSet<Integer> treeSet = new TreeSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			for (int j = 1; j < nums.length; j++) {
				if(nums[i] + nums[j] == target) {
					treeSet.add(i);
					treeSet.add(j);
				}
			}
		}
		Object[] objArr = treeSet.toArray();
		int[] intArr = new int[objArr.length];
		for (Object object : objArr) {
			for (int i = 0; i < intArr.length; i++) {
				intArr[i] = (Integer) object;
			}
		}
		return intArr;
    }
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] i = {1, 5, 6, 10};
		int[] sum = sol.twoSum(i, 11);
		for (int j : sum) {
			System.out.println(j);
		}
	}
}
