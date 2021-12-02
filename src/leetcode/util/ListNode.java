package leetcode.util;

import java.util.ArrayList;
import java.util.List;

public class ListNode {
	int val;
	public ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}

	/*
	 * Linked List Utilities
	 * */
	public static ListNode createLinkedListFromArray(int... values) {
		ListNode head = null;
		ListNode p = null;

		for (int value : values) {
			if (head == null) {
				head = new ListNode(value);
				p = head;
			} else {
				p.next = new ListNode(value);
				p = p.next;
			}
		}

		return head;
	}

	public static List<Integer> createArrayFromLinkedList(ListNode head) {
		ListNode p = head;
		List<Integer> list = new ArrayList<>();

		while (p != null) {
			list.add(p.val);
			p = p.next;
		}

		return list;
	}
}