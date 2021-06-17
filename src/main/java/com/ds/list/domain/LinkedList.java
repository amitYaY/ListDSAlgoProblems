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
		if (this.head == null) {
			this.head = new Node<T>(value);
			this.tail = this.head;
		} else {
			this.tail.next = new Node<T>(value);
			this.tail = this.tail.next;
		}
		return this.head;
	}

	public static class Node<T> {

		private T element;
		private Node<T> next;

		private Node(T element) {
			this.element = element;
		}

		private Node(T element, Node<T> next) {
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

}
