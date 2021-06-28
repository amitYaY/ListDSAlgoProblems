package com.ds.list.eight;

import java.util.Stack;

import com.ds.list.domain.LinkedList;
import com.ds.list.domain.LinkedList.Node;
import com.ds.list.util.Utils;

public class SolutionService {

	public static void main(String[] args) {
		SolutionService service = new SolutionService();
		LinkedList<Integer> linkedList1 = Utils.getCustomeIntegerLinkedList_1();
		LinkedList<Integer> linkedList2 = Utils.getCustomeIntegerLinkedList_2();
		Node<Integer> list1 = linkedList1.first();
		Node<Integer> list2 = linkedList2.first();
		Node<Integer> result = service.getSumLinkedList_UsingStack(list1, list2);
		while (result != null) {
			System.out.print(result.getElement() + "->");
			result = result.getNext();
		}
	}

	public Node<Integer> getSumLinkedList_UsingStack(Node<Integer> list1, Node<Integer> list2) {
		Node<Integer> result = null;
		Node<Integer> temp = null;
		Stack<Integer> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();

		while (list1 != null || list2 != null) {
			if (list1 != null) {
				stack1.add(list1.getElement());
				list1 = list1.getNext();
			}
			if (list2 != null) {
				stack2.add(list2.getElement());
				list2 = list2.getNext();
			}
		}
		
		Stack<Integer> maxStack = stack1.size() >= stack2.size() ? stack1 : stack2;
		Stack<Integer> minStack = stack1.size() < stack2.size() ? stack1 : stack2;

		while (maxStack.size() != 1 || minStack.size() != 0) {
			int in1 = 0;
			int in2 = 0;
			if (stack1.size() != 0) {
				in1 = stack1.pop();
			}
			if (stack2.size() != 0) {
				in2 = stack2.pop();
			}

			int sum = in1 + in2;
			int remender = sum % 10;
			int sub = sum / 10;

			if (result == null) {
				result = new LinkedList<Integer>().add(remender);
			} else {
				temp = result;
				result = new LinkedList<Integer>().add(remender);
				result.setNext(temp);
			}
			
			if(maxStack.size() > 0) {
				maxStack.add(maxStack.pop()+sub);
			} else {
				maxStack.add(sub);
			}
		}
		
		int sub = maxStack.pop();
		while(sub != 0) {
			int remender = sub % 10;
			sub = sub / 10;
			if (result == null) {
				result = new LinkedList<Integer>().add(remender);
			} else {
				temp = result;
				result = new LinkedList<Integer>().add(remender);
				result.setNext(temp);
			}
		}

		return result;
	}

}
