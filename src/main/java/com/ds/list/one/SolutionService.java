package com.ds.list.one;

import com.ds.list.domain.LinkedList;
import com.ds.list.domain.LinkedList.Node;
import com.ds.list.util.Utils;

public class SolutionService {

	public static void main(String[] args) {
		SolutionService service = new SolutionService();
		LinkedList<String> list = Utils.getCustomeLinkedList();
		String middleElement = service.findMiddleElement_TwoPass(list);
		System.out.println("Middle Element in Two Pass: " + middleElement);
		System.out.println("###########################################");
		middleElement = service.findMiddleElement_OnePass(list);
		System.out.println("Middle Element in One Pass: " + middleElement);
	}

	public String findMiddleElement_TwoPass(LinkedList<String> list) {
		String ans = null;
		int size = this.size(list);
		if (size == 0) {
			return null;
		} else {
			int mid = size / 2;
			Node<String> element = null;
			Node<String> head = list.first();
			for (int i = 0; i < mid; i++) {
				element = head;
				head = head.getNext();
			}
			if (size % 2 == 0) {
				ans = element.getElement();
			} else {
				ans = head.getElement();
			}
		}
		return ans;
	}

	public int size(LinkedList<String> list) {
		int size = 0;

		if (list == null || list.first() == null) {
			size = 0;
		} else {
			Node<String> head = list.first();
			while (head != null) {
				size++;
				head = head.getNext();
			}
		}
		return size;
	}

	public String findMiddleElement_OnePass(LinkedList<String> list) {
		String ans = null;
		Node<String> slow = list.first();
		Node<String> fast = list.first();

		while (fast.getNext() != null && fast.getNext().getNext() != null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
		}
		ans = slow.getElement();
		return ans;
	}

}
