package leetcode;

import java.util.HashMap;
import java.util.Map;

import static leetcode.util.ArrayUtil.stringArray;

// 2085. Count Common Words With One Occurrence
// https://leetcode.com/problems/count-common-words-with-one-occurrence/
public class L2085 {
	public static void main(String[] args) {
		System.out.println(new L2085().countWords(
						stringArray("leetcode", "is", "amazing", "as", "is"),
						stringArray("amazing", "leetcode", "is")
		));
		System.out.println(new L2085().countWords(
						stringArray("b", "bb", "bbb"),
						stringArray("a", "aa", "aaa")
		));
		System.out.println(new L2085().countWords(
						stringArray("a", "ab"),
						stringArray("a", "a", "a", "ab")
		));
	}

	public int countWords(String[] words1, String[] words2) {
		Map<String, Integer> map1 = new HashMap<>();
		for (String word : words1) map1.put(word, map1.getOrDefault(word, 0) + 1);

		Map<String, Integer> map2 = new HashMap<>();
		for (String word : words2) map2.put(word, map2.getOrDefault(word, 0) + 1);

		int count = 0;
		for (String word : words1)
			if (map1.containsKey(word) && map2.containsKey(word) && map1.get(word) == 1 && map2.get(word) == 1)
				count++;

		return count;
	}
}
