package com.ds.list.six;

import java.util.HashMap;
import java.util.Map;

import com.ds.list.domain.LinkedList;
import com.ds.list.domain.LinkedList.Node;
import com.ds.list.util.Utils;

public class SolutionService {

	public static void main(String[] args) {
		LinkedList<String> list = Utils.getCustomeLinkedListWithDuplicate();
		SolutionService service = new SolutionService();
		service.removeDuplicate(list);
		Node<String> head = list.first();
		while (head != null) {
			System.out.print(head.getElement() + "->");
			head = head.getNext();
		}
	}

	public void removeDuplicate(LinkedList<String> list) {

		Map<String, Integer> countMap = new HashMap<>();
		Node<String> head = list.first();
		Node<String> previous = head;
		
		while (head != null) {
			
			if (!countMap.containsKey(head.getElement())) {
				countMap.put(head.getElement(), 1);
				previous = head;
				head = head.getNext();
			} else {
				previous.setNext(head.getNext());
				head.setNext(null);
				head = previous.getNext();
			}
		}
	}

}
