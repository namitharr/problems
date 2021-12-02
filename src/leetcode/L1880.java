package leetcode;

// 1880. https://leetcode.com/problems/check-if-word-equals-summation-of-two-words/
public class L1880 {
	public static void main(String[] args) {
		System.out.println(new L1880().isSumEqual("acb", "cba", "cdb"));
		System.out.println(new L1880().isSumEqual("aaa", "a", "aab"));
		System.out.println(new L1880().isSumEqual("aaa", "a", "aaaa"));
	}

	public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
		int carry = 0;
		for (int first = firstWord.length() -1, second = secondWord.length() - 1, target = targetWord.length() - 1; target >= 0;
		     first--, second--, target--) {

			int sum = 0;
			if (first >= 0) sum += firstWord.charAt(first) - 'a';
			if (second >= 0) sum += secondWord.charAt(second) - 'a';

			sum += carry;
			carry = sum / 10;
			if (targetWord.charAt(target) - 'a' != sum % 10) return false;
		}

		return carry == 0;
	}
}
