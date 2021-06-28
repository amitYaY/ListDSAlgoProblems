package com.ds.list.domain;

public class LinkedList<T> {

	private Node<T> head;

	private Node<T> tail;

	public LinkedList() {
	}
	
	public Node<T> first() {
		return this.head;
	}

	public Node<T> add(T value) {
		Node<T> temp = null;
		if (this.head == null) {
			temp =  new Node<T>(value);
			this.head = temp;
			this.tail = this.head;
		} else {
			temp =  new Node<T>(value);
			this.tail.next = temp;
			this.tail = this.tail.next;
		}
		return temp;
	}

	public static class Node<T> {

		private T element;
		private Node<T> next;

		public Node(T element) {
			this.element = element;
		}

		public Node(T element, Node<T> next) {
			this.element = element;
			this.next = next;
		}

		public T getElement() {
			return element;
		}

		public void setElement(T element) {
			this.element = element;
		}

		public Node<T> getNext() {
			return next;
		}

		public void setNext(Node<T> next) {
			this.next = next;
		}
	}
	
	@Override
	public String toString() {
		String s = "";
		Node<T> head = this.head;
		while(head!=null) {
			s=s+"->"+head.getElement();
			head = head.getNext();
		}
		return s;
	}

}
