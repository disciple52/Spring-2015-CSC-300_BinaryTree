
public class BinaryTree 
{	
	//private Node root;
	private Boolean isEmpty;
	private int payload;
	private BinaryTree leftTree;
	private BinaryTree rightTree;
	private int depth;
	
	public BinaryTree()
	{
		this(0); //this is how we call our own constructor
	}
	
	private BinaryTree(int depth)
	{
		//this.root = null;
		this.isEmpty = true;
		this.leftTree = null;
		this.rightTree = null;
		this.depth = depth;
	}
	
	public boolean search(int value)
	{
		//return true if value is in the tree
		//return false if value is not in the tree
		if(this.isEmpty)
		{
			return false;
		}
		else
		{
			if(this.payload == value)
			{
				return true;
			}
			else
			{
				if(value < payload)
				{
					//check the left
					if(this.leftTree == null)
					{
						return false;
					}
					else
					{
						return this.leftTree.search(value);
					}
				}
				else
				{
					//check the right
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
		}
	}
	
	private void visitInOrder()
	{
		if(this.leftTree != null)
		{
			this.leftTree.visitInOrder();
		}
		System.out.println(this.payload + " : " + this.depth);
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
		System.out.println("**** In Order ****");
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
		System.out.println("**** Pre Order ****");
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
		System.out.println("**** Post Order ****");
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
	
	private int getMaxDepth()
	{
		if(this.leftTree == null && this.rightTree == null)
		{
			return this.depth;
		}
		else if(this.leftTree == null)
		{
			return this.rightTree.getMaxDepth();
		}
		else if(this.rightTree == null)
		{
			return this.leftTree.getMaxDepth();
		}
		else
		{
			return Math.max(this.leftTree.getMaxDepth(), this.rightTree.getMaxDepth());
		}
	}
	
	public boolean isBalanced()
	{
		if(this.isEmpty)
		{
			return true;
		}
		else
		{
			//get the depth of the left
			int currMaxLeftDepth = this.leftTree == null?this.depth:this.leftTree.getMaxDepth(); //inline if statement see 54:15 in video csc 300 3/31/15 //boolean-expr?true-val:false-val
			int currMaxRightDepth = this.rightTree == null?this.depth:this.rightTree.getMaxDepth();
			System.out.println("Max Left = " + currMaxLeftDepth);
			System.out.println("Max Right = " + currMaxRightDepth);
			return Math.abs(currMaxLeftDepth - currMaxRightDepth) <= 1;
		}	
	}
	
	public BinaryTree rotateRight(BinaryTree parent)
	{
		System.out.println("rotateRight");
		BinaryTree child = parent.leftTree;
		child.rightTree = parent;
		parent.leftTree = null;
		this.leftTree = child;
		return child;
	}
	
	public BinaryTree rotateLeft(BinaryTree parent)
	{
		System.out.println("rotateLeft");
		BinaryTree child = parent.rightTree;
		child.leftTree = parent;
		parent.rightTree = null;
		this.rightTree = child;
		return child;
	}
	
	public void reBalance()
	{
		System.out.println("unbalanced");
		if (this.leftTree.getMaxDepth() == this.rightTree.getMaxDepth() - 1 || this.rightTree == null) //never enters here (problematic)
		{
			System.out.println("still kickin");
			if(this.leftTree.getMaxDepth() > 2)
			{
				this.leftTree.reBalance();
			}
			else
			{
				if(this.rightTree == null)
				{
					rotateLeft(this);
				}
				else
				{
					rotateLeft(this);
					rotateRight(rotateLeft(this));
				}
			}
		}
		else
		{
			System.out.println("other kick");
			if(this.rightTree.getMaxDepth() == this.getMaxDepth() - 1 || this.leftTree == null) 
			{
				this.rightTree.reBalance();
			}
			else 
			{
				if(this.leftTree == null)
				{
					rotateRight(this);
				}
				else
				{
					rotateRight(this);
					rotateLeft(rotateRight(this));
				}
			}
		}
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
					this.leftTree = new BinaryTree(this.depth+1);	
				}
				this.leftTree.add(value);
			}
			else
			{
				if(this.rightTree == null)
				{
					this.rightTree = new BinaryTree(this.depth+1);
				}
				this.rightTree.add(value);
			}
		}
		if(!this.isBalanced())
		{
			this.reBalance();
		}
		System.out.println("isBalanced");
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