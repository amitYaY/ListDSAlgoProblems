package com.ds.list.seven;

import com.ds.list.domain.LinkedList;
import com.ds.list.domain.LinkedList.Node;
import com.ds.list.util.Utils;

public class SolutionService {

	public static void main(String[] args) {
		SolutionService service = new SolutionService();
		LinkedList<String> list = Utils.getCustomeLinkedList_1();
		Node<String> head = list.first();
		service.removeNthFromEnd(head, 2);
		while (head != null) {
			System.out.print(head.getElement() + "->");
			head = head.getNext();
		}

	}

	public Node<String> removeNthFromEnd(Node<String> head, int n) {
		Node<String> result = head;
		Node<String> node = null;
		Node<String> previous = null;
		int count = 0;
		while (head != null) {
			count++;
			if (count == n) {
				node = result;
				head = head.getNext();
				continue;
			} else if (count > n) {
				head = head.getNext();
				previous = node;
				node = node.getNext();
			} else {
				head = head.getNext();
			}
		}

		if (previous != null) {
			previous.setNext(node.getNext());
		}
		node.setNext(null);

		return result;
	}

}
