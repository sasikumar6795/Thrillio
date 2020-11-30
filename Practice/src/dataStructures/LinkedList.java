package dataStructures;


public class LinkedList {    
    //Represent a node of the singly linked list    
    class Node{    
        int data;    
        Node next;    
            
        public Node(int data) {    
            this.data = data;    
            this.next = null;    
        }

		public Node() {
			// TODO Auto-generated constructor stub
		}    
    }    
     
    //Represent the head and tail of the singly linked list    
    public Node head = null;    
    public Node tail = null;    
        
    //addNode() will add a new node to the list    
    public void addNode(int data) {    
        //Create a new node    
        Node newNode = new Node(data);   
       // newNode.data=data;
        System.out.println(newNode.next);
        System.out.println(newNode.data);
            
        //Checks if the list is empty    
        if(head == null) {    
            //If list is empty, both head and tail will point to new node    
            head = newNode;
          //  head.data = data;
            tail = newNode;    
        }    
        else {    
            //newNode will be added after tail such that tail's next will point to newNode    
            tail.next = newNode;
            //newNode will become new tail of the list    
            tail = newNode;    
        }    
    }    
        
    //display() will display all the nodes present in the list    
    public void display() {    
        //Node current will point to head    
        Node current = head;    
            
        if(head == null) {    
            System.out.println("List is empty");    
            return;    
        }    
        System.out.println("Nodes of singly linked list: ");    
        while(current != null) {    
            //Prints each node by incrementing pointer    
            System.out.print(current.data + " ");    
            current = current.next;    
        }    
        System.out.println();    
    }   
    
    public void insertNodeAtStart(int data)
    {
    	Node new_Node =  new Node(data);
    	
    	new_Node.next = head;
    	head = new_Node;
    }
    
    public void insetNodeAtEnd(int data)
    {
    	Node new_node =  new Node(data);
    	tail = head;
    	while(tail.next!=null)
    	{
    		tail = tail.next;
    	}
    	tail.next = new_node;
    }
    
    public void insertAtPosition(int pos, int data)
    {
    	Node new_node =  new Node(data);
    	int i=1;
    	tail = head;
    	while(i<pos)
    	{
    		tail =tail.next;
    		i++;
    	}
    	new_node.next = tail.next;
		tail.next = new_node;
    }
    
    public void deleteAtStart()
    {
    	Node new_node;
    	
    	new_node = head;
    	new_node = head.next;
    //	System.out.println(head.data);
    	head = new_node;
    //	System.out.println(head.data);
    	
    }
    
    public void deleteAtEnd()
    {
    	Node next_Node ;
    	Node prev_Node =null;
    	next_Node =head;
    	while(next_Node.next!=null)
    	{
    		prev_Node = next_Node;
    		next_Node = next_Node.next;
    	}
    	prev_Node.next =null;
    }
    
    public void deleteAtPosition(int pos)
    {
    	Node current_Node ;
    	Node next_Node = null;
    	current_Node = head;
    	Node prev_Node = null;
    	int i =1;
    	while(i<pos)
    	{
    		prev_Node = current_Node;
    		next_Node = current_Node.next;
    		next_Node = next_Node.next;
    		current_Node = current_Node.next;
    		i++;
    	}
    	prev_Node.next = next_Node;
    
    }
    
    public void reverseLinkedList()
    {
    	Node prevNode = new Node();
    	Node nextNode = new Node();
    	prevNode=null;
    	tail=nextNode=head;
    	
    	while(nextNode!=null)
    	{
    		nextNode=nextNode.next;
    		tail.next=prevNode;
    		prevNode=tail;
    		tail=nextNode;
    	}
    	head=prevNode;
    	
    	
    }
        
    public static void main(String[] args) {    
            
        LinkedList sList = new LinkedList();    
            
        //Add nodes to the list    
        sList.addNode(1);    
        sList.addNode(2);    
        sList.addNode(3);    
        sList.addNode(4);    
        sList.addNode(5);
        
        //insert
       // sList.insertNodeAtStart(8);
        //sList.insetNodeAtEnd(10);
       // sList.insertAtPosition(2, 67);
        
      //delete
        //sList.deleteAtStart();
       // sList.deleteAtEnd();
       // sList.deleteAtPosition(5);
      // sList.reverseLinkedList();
        //Displays the nodes present in the list    
        sList.display();    
        
        
    }    
}  