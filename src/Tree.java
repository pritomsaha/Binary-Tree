

import java.util.Stack;


public class Tree {
	
	public Node root;
	
	public Tree()
	{
		root=null;
	}
	
	public void insertNode(int key)
	{
	  Node current,parent;
		
		current= root;
		
		if(current== null)
		{
			root=new Node(key);
			root.flag=true;
			return;
		}
		else
		{
			while(true){
				parent=current;
				
				if(current.key>key)
				{
					current=current.leftChild;
					if(current==null)
					{
						current=new Node(key);
						current.flag=true;
						parent.leftChild=current;
						return;
					}
				}
				
				else if(current.key<key)
				{
					current=current.rightChild;
					if(current==null)
					{
						current= new Node(key);
						current.flag=false;
						parent.rightChild=current;
						return;
					}
				}
			
			}
		}
		
	}
	
	public void searchKey(int key)
	{
		Node current;
		current=root;
	
		while(true)
		{
			if(current==null)	
			{
				System.out.println(key+" is not found !!!");
				return;
			}
			else if(current.key==key)
			{
				System.out.println(key+ " is found");
				return;
			}
			else if(current.key>key)
				current=current.leftChild;
			
			else
				current=current.rightChild;
		}
			
	}
	// inorder traversing using stack
	
	public void InorderTraversing()
	{
		System.out.println("inorder traversing:");
		Node current = root;
		Stack<Node> myStack=new Stack<Node>();
		
		while(true)
		{
			if(current==null)
				break;
			myStack.push(current);
			current=current.leftChild;
		}
		
		
		while(true)
		{
			if(myStack.isEmpty())
				break;
			current=myStack.pop();
			
			System.out.print(current.key+" ");
			
			if(current.rightChild!=null)
			{
				current = current.rightChild;
				while(true)
				{
					if(current==null)
						break;
					myStack.push(current);
					current=current.leftChild;
				}
				
			}
			
			
		}
		
	}
	
	// inorder traversing using recursion
	public void inorderTraversing()
	{
		System.out.println("inorder traversing:");
		inorder(root);
		
		System.out.println();
		
	}
	
	public void inorder(Node current)
	{
		if(current==null)
			return;
		
		else
		{
			inorder(current.leftChild);
			System.out.print(current.key+" ");
			inorder(current.rightChild);
		}
	}
	
	//preorder traversing using stack
	public void PreorderTraversing()
	{
		System.out.println("preorder traversing:");
		Node current;
		current=root;
		Stack<Node> myStack = new  Stack<Node>();
		
		while(true)
		{
			if(current==null)
				break;
			else
			{
				System.out.print(current.key+" ");
				if(current.rightChild!=null)
					myStack.push(current.rightChild);
				current=current.leftChild;
			}
		}
		
		while(true)
		{
			if(myStack.isEmpty())
				break;
			
			current=myStack.pop();
			
			while(true)
			{
				if(current==null)
					break;
				System.out.print(current.key+" ");
				if(current.rightChild!=null)
					myStack.push(current.rightChild);
				
				current=current.leftChild;
			}
			
		}
		
		
	}
	
	// preorder traversing using recursion
	public void preorderTraversing()
	{
		System.out.println("preorder traversing:");
		preorder(root);
		
		System.out.println();
	}
	
	public void preorder(Node current)
	{
		if(current==null)
			return;
		
		else
		{
			System.out.print(current.key+" ");
			preorder(current.leftChild);
			preorder(current.rightChild);
		}
	}
	
	// postorder traversing using stack
	public void PostorderTraversing()
	{
		System.out.println("postorder traversing:");
		Node current= root;
		Stack<Node> myStack = new Stack<Node>();
		
		while(true)
		{
			if(current==null)
				break;
			
			myStack.push(current);
			if(current.rightChild!=null)
				myStack.push(current.rightChild);
			current=current.leftChild;
		}
		
		while(true)
		{
			if(myStack.isEmpty())
				break;
			
			current=myStack.pop();
			if(current.flag==true)
				System.out.print(current.key+" ");
			
			else
			{
				current.flag=true;
				while(true)
				{
					if(current==null)
						break;
					
					myStack.push(current);
					if(current.rightChild!=null)
						myStack.push(current.rightChild);
					current=current.leftChild;
						
				}
			}
		}
		
		System.out.println();
		
	}
	
	// postorder traversing using recursion
	public void postorderTraversing()
	{
		System.out.println("postorder traversing:");
		postorder(root);
		
		System.out.println(); 
	}
	
	public void postorder(Node current)
	{
		if(current==null)
			return;
		
		else
		{
			postorder(current.leftChild);
			postorder(current.rightChild);
			System.out.print(current.key+" ");
		}
	}
	
	// deletion
	public void delete(int key)
	{
		Node parent,current;
		current=root;
		parent=null;
		
		while(true)
		{
			
			if(current==null)
			{
				System.out.println("Item is not in tree");
				return;
			}
			else if(current.key==key)
			{
				break;
			}
			else if(current.key>key)
			{
				parent=current;
				current=current.leftChild;
			}
			else {
				
				parent=current;
				current=current.rightChild;
			}
		}
		
		if(current.leftChild!=null&&current.rightChild!=null)
			deletionForTwoChild(current, parent);
		else
			deletionForNoOrSingleChild(current, parent);
		
	}
	
	public void deletionForNoOrSingleChild(Node loc ,Node parent)
	{
		Node child;
		if(loc.leftChild==null&&loc.rightChild==null)
			child=null;
		
		else if(loc.leftChild!=null)
			child=loc.leftChild;
		else 
			child=loc.rightChild;
		
		if(parent!=null)
		{
			if(loc==parent.leftChild)
				parent.leftChild=child;
			else
				parent.rightChild=child;
		}
		else
			root=child;
	}
	
	public void deletionForTwoChild(Node loc, Node parent)
	{
		Node successor,parsuc;
		successor=loc.rightChild;
		parsuc=loc;
		
		
		while(true)
		{
			if(successor.leftChild==null)
				break;
			else
			{
				parsuc=successor;
				successor=successor.leftChild;
			}
		}
		
		deletionForNoOrSingleChild(successor,parsuc );
		
		if(parent!=null)
		{
			if(loc==parent.leftChild)
				loc.leftChild=successor;
			else
				loc.rightChild=successor;
		}
		else {
			root=successor;
		}
		
		successor.leftChild=loc.leftChild;
		successor.rightChild=loc.rightChild;
				
	}
	
	public void getMinimumKey()
	{
		Node MinKey;
		MinKey=root;
		if(root==null)
		{
			System.out.println("No node exits");
			return;
		}
		
		while(true)
		{
			if(MinKey.leftChild==null)
				break;
			else
			{
				MinKey=MinKey.leftChild;
			}
		}
		System.out.println("Minimum key is:"+MinKey.key);
		
	}
	
	public void getMaximumKey()
	{
		Node MaxKey;
		MaxKey=root;
		
		while(true)
		{
			if(MaxKey.rightChild==null)
				break;
			else
			{
				MaxKey=MaxKey.rightChild;
			}
		}
		System.out.println("Maximum key is:"+MaxKey.key);
		
	}
	
}
