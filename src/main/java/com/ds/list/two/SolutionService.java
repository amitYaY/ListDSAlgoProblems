package com.ds.list.two;

import com.ds.list.domain.LinkedList;
import com.ds.list.domain.LinkedList.Node;
import com.ds.list.util.Utils;

public class SolutionService {

	public static void main(String[] args) {
		SolutionService service = new SolutionService();
		LinkedList<String> input = Utils.getCyclicLinkedList();
		boolean result = service.ifHasCycle(input);
		System.out.println("Has Cycle: " + result);
	}

	public boolean ifHasCycle(LinkedList<String> input) {
		boolean result = false;
		if (input == null || input.first().getNext() == null) {
			return result;
		}

		Node<String> slow = input.first();
		Node<String> fast = input.first();

		while (slow != null && fast != null && fast.getNext() != null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
			if (slow == fast) {
				result = true;
				break;
			}
		}
		return result;
	}

}
