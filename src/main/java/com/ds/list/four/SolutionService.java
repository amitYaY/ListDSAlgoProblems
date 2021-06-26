package com.ds.list.four;

import com.ds.list.domain.LinkedList;
import com.ds.list.util.Utils;

public class SolutionService {

	public static void main(String[] args) {
		SolutionService service = new SolutionService();
		LinkedList<String> list = Utils.getCustomeLinkedList();
		LinkedList.Node<String> newHead = service.reverseLinkedList(list);
		while (newHead != null) {
			System.out.print(newHead.getElement() + "->");
			newHead = newHead.getNext();
		}
	}

	public LinkedList.Node<String> reverseLinkedList(LinkedList<String> list) {
		LinkedList.Node<String> head = list.first();
		LinkedList.Node<String> t1 = head;
		if(head == null) {
			return head;
		}
		LinkedList.Node<String> t2 = t1.getNext();
		LinkedList.Node<String> t3 = null;

		while (t2 != null) {
			if (head.getNext() != null) {
				head.setNext(null);
			}
			t3 = t2.getNext();
			t2.setNext(t1);
			t1 = t2;
			t2 = t3;
		}
		return t1;
	}

}
