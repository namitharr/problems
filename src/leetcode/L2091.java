package leetcode;

import static leetcode.util.ArrayUtil.intArray;

// 2091. Removing Minimum and Maximum From Array
// https://leetcode.com/problems/removing-minimum-and-maximum-from-array/
public class L2091 {
	public static void main(String[] args) {
		System.out.println(new L2091().minimumDeletions(intArray(2, 10, 7, 5, 4, 1, 8, 6)));
		System.out.println(new L2091().minimumDeletions(intArray(0, -4, 19, 1, 8, -2, -3, 5)));
		System.out.println(new L2091().minimumDeletions(intArray(101)));
	}

	public int minimumDeletions(int[] nums) {
		if (nums.length <= 2) return nums.length;

		int maxIndex = 0;
		int minIndex = 0;

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > nums[maxIndex]) maxIndex = i;
			if (nums[i] < nums[minIndex]) minIndex = i;
		}

		int removeMaxStart = maxIndex + 1;
		int removeMaxEnd = nums.length - maxIndex;
		int removeMinStart = minIndex + 1;
		int removeMinEnd = nums.length - minIndex;

		int removeBothStart = Math.max(removeMaxStart, removeMinStart);
		int removeBothEnd = Math.max(removeMaxEnd, removeMinEnd);
		int removeBoth = Math.min(removeMaxStart, removeMaxEnd) + Math.min(removeMinStart, removeMinEnd);

		return Math.min(removeBoth, Math.min(removeBothStart, removeBothEnd));
	}
}
