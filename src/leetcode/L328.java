package leetcode;

import leetcode.util.ListNode;

import static leetcode.util.ArrayUtil.intArray;
import static leetcode.util.ListNode.createArrayFromLinkedList;
import static leetcode.util.ListNode.createLinkedListFromArray;

// 328. Odd Even Linked List
// https://leetcode.com/problems/odd-even-linked-list/
public class L328 {
	public static void main(String[] args) {
		System.out.println(createArrayFromLinkedList(new L328().oddEvenList(createLinkedListFromArray(intArray(1, 2, 3, 4, 5)))));
		System.out.println(createArrayFromLinkedList(new L328().oddEvenList(createLinkedListFromArray(intArray(2, 1, 3, 5, 6, 4, 7)))));
	}

	public ListNode oddEvenList(ListNode head) {
		if (head == null) return null;

		ListNode p = head;
		ListNode oddList = p;
		p = p.next;
		ListNode evenHead = p;
		ListNode evenList = p;

		while (p != null) {
			p = p.next;
			oddList.next = p;
			if (p != null) {
				oddList = p;
				p = p.next;
				evenList.next = p;
				evenList = p;
			}
		}

		oddList.next = evenHead;
		return head;
	}
}
