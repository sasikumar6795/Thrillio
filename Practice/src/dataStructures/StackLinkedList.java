package dataStructures;

public class StackLinkedList {

	public static Node top = null;

	public static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}

		public Node() {

		}
	}

	public static void insertElement(int data) {
		/*
		 * Node newNode = new Node(data); newNode.next = top; top=newNode;
		 */

		Node newNode = new Node();
		newNode.data = data;
		newNode.next = top;
		top = newNode;
	}

	public static void displayElements() {
		Node tempNode = null;
		tempNode = top;
		while (tempNode != null) {
			System.out.println(tempNode.data);
			tempNode = tempNode.next;
		}
	}

	public static void peekElement() {
		Node tempNode = null;
		tempNode = top;
		if (tempNode == null) {
			System.out.println("Stack is empty");
		} else {
			System.out.println(tempNode.data);
		}
	}

	public static void popElement() {

		if (top == null) {
			System.out.println("Stack is empty");
		} else {

			System.out.println("Removed Element" + " " + top.data);
			top = top.next;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		insertElement(5);
		insertElement(8);
		insertElement(10);

		// displayElements();
		peekElement();
		popElement();

	}

}
