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
		System.out.println();
		System.out.println("#################################################");
		linkedList1 = Utils.getCustomeIntegerLinkedList_1();
		linkedList2 = Utils.getCustomeIntegerLinkedList_2();
		list1 = linkedList1.first();
		list2 = linkedList2.first();
		result = service.getSumLinkedList(list1, list2);
		while (result != null) {
			System.out.print(result.getElement() + "->");
			result = result.getNext();
		}
	}

	public Node<Integer> getSumLinkedList(Node<Integer> list1, Node<Integer> list2) {
		Node<Integer> result = null;

		Node<Integer> listCopy1 = list1;
		Node<Integer> listCopy2 = list2;

		int len1 = 0;
		int len2 = 0;
		while (true) {
			if (list1 != null) {
				len1++;
				list1 = list1.getNext();
			}
			if (list2 != null) {
				len2++;
				list2 = list2.getNext();
			}
			if (list1 == null && list2 == null) {
				break;
			}
		}
		int diff = Math.abs(len1 - len2);
		Node<Integer> maxNode = len1 >= len2 ? listCopy1 : listCopy2;
		Node<Integer> minNode = len1 < len2 ? listCopy1 : listCopy2;
		result = sum(maxNode, minNode, diff);

		int previousSum = result.getElement();
		int remainder = previousSum % 10;
		result.setElement(remainder);
		int sub = previousSum / 10;
		Node<Integer> temp = new LinkedList.Node<Integer>(sub);
		temp.setNext(result);
		result = temp;
		return result;
	}

	private Node<Integer> sum(Node<Integer> maxNode, Node<Integer> minNode, int diff) {
		Node<Integer> result = null;
		Node<Integer> temp = null;
		if (maxNode.getNext() == null && minNode.getNext() == null) {
			int sum = maxNode.getElement() + minNode.getElement();
			result = new LinkedList.Node<Integer>(sum);
			return result;
		}
		if (diff != 0) {
			temp = sum(maxNode.getNext(), minNode, diff - 1);
		} else {
			temp = sum(maxNode.getNext(), minNode.getNext(), 0);
		}
		int previousSum = temp.getElement();
		int remainder = previousSum % 10;
		temp.setElement(remainder);
		int sum = 0;
		if (diff != 0) {
			sum = maxNode.getElement() + previousSum / 10;
		} else {
			sum = maxNode.getElement() + minNode.getElement() + previousSum / 10;
		}
		result = new LinkedList.Node<Integer>(sum);
		result.setNext(temp);
		return result;
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
			int remainder = sum % 10;
			int sub = sum / 10;

			if (result == null) {
				result = new LinkedList<Integer>().add(remainder);
			} else {
				temp = result;
				result = new LinkedList<Integer>().add(remainder);
				result.setNext(temp);
			}

			if (maxStack.size() > 0) {
				maxStack.add(maxStack.pop() + sub);
			} else {
				maxStack.add(sub);
			}
		}

		int sub = maxStack.pop();
		while (sub != 0) {
			int remainder = sub % 10;
			sub = sub / 10;
			if (result == null) {
				result = new LinkedList<Integer>().add(remainder);
			} else {
				temp = result;
				result = new LinkedList<Integer>().add(remainder);
				result.setNext(temp);
			}
		}

		return result;
	}

}
