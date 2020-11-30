package dataStructures;

import java.util.Scanner;

public class BinaryTree {

	Scanner scan = new Scanner(System.in);
	Node temp=null;
	public class Node
	{
		int data;
		Node left;
		Node right;
		
		public Node()
		{
			
		}
		public Node(int data)
		{
			this.data=data;
			this.left=null;
			this.right=null;
		}
	}
	

	public Node createTree() {
		Node newNode = new Node();
		System.out.println("Enter the number you want to insert or enter -1 if you dont want to insert");
		int x = scan.nextInt();
		if(x==-1)
		{
			return null;
		}
		else
		{
			newNode.data=x;
			System.out.println("Enter the left child");
			newNode.left=createTree();
			System.out.println("Enter the right child");
			newNode.right=createTree();
			return newNode;
		}		
	}
	
	public void preOrderTraversal(Node root)
	{
		if(root==null)
		{
			return;
		}
		else
		{
			System.out.println(root.data);
			preOrderTraversal(root.left);
			preOrderTraversal(root.right);
		}
	}
	
	public static void main(String[] args)
	{
		BinaryTree binaryTree = new BinaryTree();
		Node root=null;
		root = binaryTree.createTree();
		binaryTree.preOrderTraversal(root);

	}




















}
