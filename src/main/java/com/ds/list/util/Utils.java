package com.ds.list.util;

import com.ds.list.domain.LinkedList;
import com.ds.list.domain.LinkedList.Node;

public class Utils {
	
	public static LinkedList<String> getCustomeLinkedList() {
		LinkedList<String> list = new LinkedList<>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
		list.add("F");
		list.add("G");
		list.add("H");
		list.add("I");
		list.add("J");
		list.add("K");
		return list;
	}
	
	public static LinkedList<String> getCyclicLinkedList() {
		LinkedList<String> list = new LinkedList<>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
		list.add("F");
		list.add("G");
		list.add("H");
		list.add("I");
		Node<String> temp = list.add("J");
		Node<String> temp1 = list.add("K");
		temp1.setNext(temp);
		return list;
	}
	
	public static LinkedList<String> getCustomeLinkedListWithDuplicate() {
		LinkedList<String> list = new LinkedList<>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("A");
		list.add("A");
		list.add("F");
		list.add("G");
		list.add("G");
		list.add("I");
		list.add("B");
		list.add("K");
		return list;
	}
	
	public static LinkedList<String> getCustomeLinkedList_1() {
		LinkedList<String> list = new LinkedList<>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		return list;
	}
	
	public static LinkedList<Integer> getCustomeIntegerLinkedList_1() {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(9);
//		list.add(9);
//		list.add(9);
//		list.add(7);
//		list.add(1);
		return list;
	}
	
	public static LinkedList<Integer> getCustomeIntegerLinkedList_2() {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(9);
//		list.add(9);
//		list.add(8);
		return list;
	}

}
