public class BinaryTree 
{	
	//private Node root;
	private Boolean isEmpty;
	private int payload;
	private BinaryTree leftTree;
	private BinaryTree rightTree;
	
	public BinaryTree()
	{
		//this.root = null;
		this.isEmpty = true;
		this.leftTree = null;
		this.rightTree = null;
	}
	public boolean search(int value)
	{	
		if(isEmpty)
		{
			return false;
		}
		else
		{
			if(value == this.payload)
			{
				return true;
			}
			else if (value < this.payload)
			{
				if(this.leftTree == null)
				{
					return false;
				}
				else
				{
					return this.leftTree.search(value);
				}
			}
			else if (value > this.payload)
			{
				if(this.rightTree == null)
				{
					return false;
				}
				else
				{
					return this.rightTree.search(value);
				}
			}
		}
		return false;
	}
	public void visitInOrder()
	{
		if(this.leftTree != null)
		{
			this.leftTree.visitInOrder();
		}
		System.out.println(this.payload);
		if(this.rightTree != null)
		{
			this.rightTree.visitInOrder();
		}
	}
	
	public void visitPreOrder()
	{
		System.out.println(this.payload);
		if(this.leftTree != null)
		{
			this.leftTree.visitPreOrder();
		}
		if(this.rightTree != null)
		{
			this.rightTree.visitPreOrder();
		}
	}
	
	public void visitPostOrder()
	{
		if(this.leftTree != null)
		{
			this.leftTree.visitPostOrder();
		}
		if(this.rightTree != null)
		{
			this.rightTree.visitPostOrder();
		}
		System.out.println(this.payload);
	}
	
	public void displayInOrder() 
	{
		if(this.isEmpty)
		{
			System.out.println("Empty Tree");
		}
		else
		{
			this.visitInOrder();
		}
		/*
		if(this.root == null)
		{
			System.out.println("Empty Tree");
		}
		else
		{
			this.root.visitInOrder();
		}
		*/
	}
	
	public void displayPreOrder()
	{
		if(this.isEmpty)
		{
			System.out.println("Empty Tree");
		}
		else
		{
			this.visitPreOrder();
		}
		/*
		if(this.root == null)
		{
			System.out.println("Empty Tree");
		}
		else
		{
			this.root.visitPreOrder();
		}
		*/	
	}
	
	public void displayPostOrder()
	{
		if(this.isEmpty)
		{
			System.out.println("Empty Tree");
		}
		else
		{
			this.visitPostOrder();
		}
		/*
		if(this.root == null)
		{
			System.out.println("Empty Tree");
		}
		else
		{
			this.root.visitPostOrder();
		}	
		*/
	}
	
	public void add(int value)
	{
		if(this.isEmpty)
		{
			this.payload = value;
			this.isEmpty = false;
		}
		else
		{
			if(value <= this.payload)
			{
				if(this.leftTree == null)
				{
					this.leftTree = new BinaryTree();
				}
				this.leftTree.add(value);
			}
			else
			{
				if(this.rightTree == null)
				{
					this.rightTree = new BinaryTree();
				}
				this.rightTree.add(value);
			}
		}
		/*
		Node theNode = new Node(value);
		if(this.root == null)
		{
			this.root = theNode;
		}
		else
		{
			this.root.addNode(theNode);
		}
		*/
	}
}