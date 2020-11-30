package dataStructures;

public class DoublyLinkedList
{
	Node head =null;
	Node tempNode= null; 
	
	class Node
	{
		
		int data;
		Node prev;
		Node next;
		
		public Node(int data)
		{
			this.data =data;
			this.prev = null;
			this.next = null;
		}
		public Node()
		{
			
		}
	}
	
	public void createDoublyLinkedList(int data)
	{
		Node newNode = new Node(data);
		
		if(head == null)
		{
			head = newNode;
			tempNode = newNode;
			head.prev = null;
			head.data = newNode.data;
		}
		else
		{
			tempNode.next = newNode;
			newNode.prev = tempNode;
			tempNode = newNode;
			tempNode.data = newNode.data;	
		}
		
	}
	
	public void showDoublyLinkedList()
	{
		  //Node current will point to head    
        Node current = head;    
            
        if(head == null) {    
            System.out.println("List is empty");    
            return;    
        }    
        System.out.println("Nodes of doubly linked list: ");    
        while(current != null) {    
            //Prints each node by incrementing pointer    
            System.out.print(current.data + " ");    
            current = current.next;    
        }    
        System.out.println();    
	}
	
	public void insertDoublyLinkedListAtEnd(int data)
	{
		Node newNode =  new Node(data);
		tempNode.next = newNode;
		newNode.prev = tempNode;
		tempNode=newNode;
		tempNode.data = data;
	}
	
	public void insertDoublyLinkedListAtBeg(int data)
	{
		Node newNode = new Node(data);
		newNode.data =data;
		newNode.prev = null;
		newNode.next = head;
		head.prev = newNode;
		head = newNode;
	}
	
	public void insertDoublyLinkedListAtPos(int data, int pos)
	{
		Node newNode = new Node(data);
		if(pos<0)
		{
			System.out.println("Invalid Postion");
		}
		else if(pos==1)
		{
			insertDoublyLinkedListAtBeg(data);
		}
		/*else if(pos==)
		{
			insertDoublyLinkedListAtEnd(data);
		}*/
		else
		{
			int i=1;
			tempNode = head;
			while(i<pos-1)
			{
				tempNode = tempNode.next;
				i++;
			}
			newNode.data =data;
			newNode.prev = tempNode;
			newNode.next = tempNode.next;
			tempNode.next = newNode;
			newNode.next.prev=newNode;
		}
		
	}
	
	public void deleteDoublyLinkedListAtBeg()
	{
		tempNode = head;
		tempNode = tempNode.next;
		tempNode.prev = null;
		head = tempNode;
	}
	
	public void deleteDoublyLinkedListAtEnd()
	{
		tempNode = head;
		while(tempNode.next!=null)
		{
			tempNode = tempNode.next;
		}
		tempNode.prev.next = null;
	}
	
	public void deleteDoublyLinkedLsitAtPos(int pos)
	{
		tempNode = head;
		int i =1;
		while(i<pos)
		{
			tempNode = tempNode.next;
			i++;
		}
		tempNode.prev.next = tempNode.next;
		tempNode.next.prev = tempNode.prev;
	}
	
	public void reverseDoublyLinkedList()
	{
		Node currentNode =  new Node();
		Node nextNode =  new Node();
		currentNode = head;
		while(currentNode!=null)
		{
			nextNode = currentNode.next;
			currentNode.next = currentNode.prev;
			currentNode.prev = nextNode;
			currentNode=nextNode;
		}
		currentNode=head;
		head=tempNode;
		tempNode=currentNode;
	}
	public static void main(String[] args)
	{
		DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
		
		doublyLinkedList.createDoublyLinkedList(5);
		doublyLinkedList.createDoublyLinkedList(6);
		doublyLinkedList.createDoublyLinkedList(7);
		
		/*doublyLinkedList.insertDoublyLinkedListAtEnd(9);
		
		doublyLinkedList.insertDoublyLinkedListAtBeg(1);
		
		doublyLinkedList.insertDoublyLinkedListAtPos(11, 3);
		doublyLinkedList.insertDoublyLinkedListAtPos(44, 1);*/
		
		//doublyLinkedList.deleteDoublyLinkedListAtBeg();
		//doublyLinkedList.deleteDoublyLinkedListAtEnd();
		//doublyLinkedList.deleteDoublyLinkedLsitAtPos(3);
		
		
		System.out.println("Before Reversing");
		doublyLinkedList.showDoublyLinkedList();
		
		
		doublyLinkedList.reverseDoublyLinkedList();
		System.out.println("after reversing");
		doublyLinkedList.showDoublyLinkedList();
		
		
	}

	
}
