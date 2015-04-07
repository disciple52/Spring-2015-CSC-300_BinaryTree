
public class BinaryTree 
{	
	//private Node root;
	private Boolean isEmpty;
	private int payload;
	private BinaryTree leftTree;
	private BinaryTree rightTree;
	private BinaryTree parent;
	private int depth;
	
	public BinaryTree()
	{
		this(0); //this is how we call our own local constructor		
	}
	
	private BinaryTree(int depth) //setting up the intial variables
	{
		//this.root = null;
		this.isEmpty = true;
		this.leftTree = null;
		this.rightTree = null;
		this.depth = depth;
		this.parent = null; //every ROOT node will not have a parent so we need to set it's parent to null
	}
	private void  changeDepth(BinaryTree pivot)
	{
		if(pivot.rightTree == null)
		{
			pivot.depth = pivot.parent.depth+1;
		}
		else
		{
			pivot.depth = pivot.depth-1;
		}
		if(pivot.leftTree != null)
		{
			pivot.leftTree.changeDepth(pivot.leftTree);
		}
		if(pivot.rightTree != null)
		{
			pivot.rightTree.changeDepth(pivot.rightTree);
		}
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
		System.out.println(this.payload + " : " + this.depth);
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
		System.out.println(this.payload + " : " + this.depth);
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
			int currMaxLeftDepth = this.leftTree == null?0:this.leftTree.getMaxDepth(); //inline if statement see 54:15 in video csc 300 3/31/15 //boolean-expr?true-val:false-val
			int currMaxRightDepth = this.rightTree == null?0:this.rightTree.getMaxDepth();
			System.out.println("Max Left = " + currMaxLeftDepth);
			System.out.println("Max Right = " + currMaxRightDepth);
			return Math.abs(currMaxLeftDepth - currMaxRightDepth) <= 1;
		}	
	}
	
	private void rotateRight(BinaryTree pivot)
	{
		//System.out.println("rotateRight");
		BinaryTree pivRT = null;
		BinaryTree pivP = null;
		BinaryTree pivGP = null;
		
		if(pivot.rightTree != null)
		{
			pivRT = pivot.rightTree;
			pivot.rightTree = null;
		}
		pivP = pivot.parent;
		pivGP = (pivP == null?null:pivP.parent);
		//conditionally remove pivP from his parent if he had a parent
		if(pivGP != null)
		{
			if(pivGP.leftTree == pivP)
			{
				pivGP.leftTree = pivot;
			}
			else
			{
				pivGP.rightTree = pivot;
			}
		}
		else
		{
			//pivot is the new root tree of the entire tree
			pivot.parent = null;
		}
		//always remove pivot from his parent
		if(pivP == null)
		{
			System.err.println("I have no parent...should I be calling rotate right?");
			return;
		}
		else
		{
			//should always get into this else
			//always replace pivP's left tree with whatever pivRT points to
			pivP.leftTree = pivRT;
		}
		//finally connect pivP as the right child of pivot and notify pivP who his new parent is
		pivot.rightTree = pivP;
		pivP.parent = pivot;
	}
	
	private void rotateLeft(BinaryTree pivot)
	{
		//System.out.println("rotateLeft");
		BinaryTree pivLT = null;
		BinaryTree pivP = null;
		BinaryTree pivGP = null;

		if(pivot.leftTree != null)
		{
			pivLT = pivot.leftTree;
			pivot.leftTree = null;
		}
		pivP = pivot.parent;
		pivGP = (pivP == null?null:pivP.parent);
		//conditionally remove pivP from his parent if he had a parent
		if(pivGP != null)
		{
			if(pivGP.leftTree == pivP)
			{
				pivGP.leftTree = pivot;
			}
			else
			{
				pivGP.rightTree = pivot;
			}
		}
		else
		{
			//pivot is the new root tree of the entire tree
			pivot.parent = null;
		}
		//always remove pivot from his parent
		if(pivP == null)
		{
			System.err.println("I have no parent...should I be calling rotate left?");
			return;
		}
		else
		{
			//should always get into this else
			//always replace pivP's right tree with whatever pivLT points to
			pivP.rightTree = pivLT;
		}
		//finally connect pivP as the left child of pivot and notify pivP who his new parent is
		pivot.leftTree = pivP;
		pivP.parent = pivot;		
	}
	
	public void reBalance()
	{

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
					this.leftTree.parent = this; //passing in themselves as the parent
				}
				this.leftTree.add(value);
			}
			else
			{
				if(this.rightTree == null)
				{
					this.rightTree = new BinaryTree(this.depth+1);
					this.rightTree.parent = this;
				}
				this.rightTree.add(value);
			}
		}
		
		if(this.depth == 2)
		{
			this.parent.parent.displayInOrder();
			System.out.println("rotating right");
			rotateRight(this.parent);
			this.parent.displayInOrder();
			changeDepth(this.parent);
			this.parent.displayInOrder();
		}
		/*if(!this.isBalanced())
		{
			this.reBalance();
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