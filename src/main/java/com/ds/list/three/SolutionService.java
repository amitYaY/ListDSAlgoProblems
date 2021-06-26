package com.ds.list.three;

import com.ds.list.domain.LinkedList;
import com.ds.list.domain.LinkedList.Node;
import com.ds.list.util.Utils;

public class SolutionService {

	public static void main(String[] args) {
		SolutionService service = new SolutionService();
		LinkedList<String> input = Utils.getCyclicLinkedList();
		String result = service.findStartingNodeOfCycle(input);
		System.out.println("Starting Node: "+result);
	}
	
	public String findStartingNodeOfCycle(LinkedList<String> input) {
		String result = null;
		if (input == null || input.first().getNext() == null) {
			return result;
		}

		Node<String> slow = input.first();
		Node<String> fast = input.first();

		while (slow != null && fast != null && fast.getNext() != null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
			if (slow == fast) {
				break;
			}
		}
		
		slow = input.first();
		while (slow != null && fast != null) {
			slow = slow.getNext();
			fast = fast.getNext();
			if (slow == fast) {
				break;
			}
		}
		return slow.getElement();
	}

}
