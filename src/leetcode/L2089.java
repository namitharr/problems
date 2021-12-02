package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 2089. https://leetcode.com/problems/find-target-indices-after-sorting-array/
public class L2089 {
	public static void main(String[] args) {
		System.out.println(new L2089().targetIndices(new int[]{1, 2, 5, 2, 3}, 2));
		System.out.println(new L2089().targetIndices(new int[]{1, 2, 5, 2, 3}, 3));
		System.out.println(new L2089().targetIndices(new int[]{1, 2, 5, 2, 3}, 5));
		System.out.println(new L2089().targetIndices(new int[]{1, 2, 5, 2, 3}, 4));
	}

	List<Integer> list = new ArrayList<>();

	public List<Integer> targetIndices(int[] nums, int target) {
		linearCount(nums, target); // 0ms
		// reverseBubbleSort(nums, target); // 3ms
		// arraysSort(nums, target); // 1ms
		return list;
	}

	private void linearCount(int[] nums, int target) {
		int less = 0;
		int equal = 0;

		for (int num : nums) {
			if (num == target) equal++;
			else if (num < target) less++;
		}

		for (int i = less; i < less + equal; i++)
			list.add(i);
	}

	private void reverseBubbleSort(int[] nums, int target) {
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = nums.length - 1; j > i; j--) {
				if (nums[j] < nums[j - 1]) {
					int temp = nums[j];
					nums[j] = nums[j - 1];
					nums[j - 1] = temp;
				}
			}
			if (nums[i] == target) list.add(i);
			else if (nums[i] > target) break;
		}
		if (nums[nums.length - 1] == target)
			list.add(nums.length - 1);
	}

	private void arraysSort(int[] nums, int target) {
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == target) list.add(i);
		}
	}
}