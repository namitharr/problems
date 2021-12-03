package leetcode;

// 1859. Sorting the Sentence
// https://leetcode.com/problems/sorting-the-sentence/
public class L1859 {
	public static void main(String[] args) {
		System.out.println(new L1859().sortSentence("is2 sentence4 This1 a3"));
		System.out.println(new L1859().sortSentence("Myself2 Me1 I4 and3"));
	}

	public String sortSentence(String s) {
		String[] split = s.split(" ");
		String[] ordered = new String[split.length];
		for (String word : split) {
			ordered[word.charAt(word.length() - 1) - '1'] = word.substring(0, word.length() - 1);
		}
		return String.join(" ", ordered);
	}
}
