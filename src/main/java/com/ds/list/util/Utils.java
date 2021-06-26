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

}
