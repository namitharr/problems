package leetcode;

import static leetcode.util.ArrayUtil.intArray;

// 2078. Two Furthest Houses With Different Colors
// https://leetcode.com/problems/two-furthest-houses-with-different-colors/
public class L2078 {
	public static void main(String[] args) {
		System.out.println(new L2078().maxDistance(intArray(1, 1, 1, 6, 1, 1, 1)));
		System.out.println(new L2078().maxDistance(intArray(1, 8, 3, 8, 3)));
		System.out.println(new L2078().maxDistance(intArray(0, 1)));
	}

	public int maxDistance(int[] colors) {
		int left = 0;
		int right = colors.length - 1;
		int last = colors.length - 1;

		while (left < last && colors[left++] == colors[last]) ;
		while (right > 0 && colors[0] == colors[right--]) ;

		return Math.max(last - left, right) + 1;
	}
}
