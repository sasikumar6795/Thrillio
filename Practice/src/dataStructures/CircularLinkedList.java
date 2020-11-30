package dataStructures;

public class CircularLinkedList {

	public static Node head = null;
	public static Node tail = null;

	public static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public static void createCircularLinkedlist(int data) {

		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;

		}

		tail.next = head;
	}

	public static void displayCircularLinkedlist() {
		tail = head;
		System.out.println("head address" + " " + head);
		while (tail.next != head) {
			System.out.println(tail.data);
			tail = tail.next;
		}
		System.out.println(tail.data);
		System.out.println("last element address" + " " + tail.next);
	}

	public static void main(String[] args) {

		createCircularLinkedlist(5);
		createCircularLinkedlist(8);
		createCircularLinkedlist(9);
		displayCircularLinkedlist();
	}

}
