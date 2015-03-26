public class BinaryTree 
{
	private Node root;
	private Node currNode;
	public int count;
	
	public BinaryTree()
	{
		this.root = null;
		this.currNode = null;
		this.count = 0;
	}
	
	public void count()
	{
		System.out.println("Count is: " + count);
	}
	public void displayInOrder() 
	{
		//System.out.println("**** In Order ****");
		
		if(this.root == null)
		{
			System.out.println("Empty Tree");
		}
		else if(count > 0)
		{			
			//if we haven't already displayed this payload
			if(currNode.getVisited() == false)
			{
				System.out.print(currNode.getPayload() + ", ");
				//this.root.trueVisited(currNode);
				currNode.setVisited(true);
				count--;
			}		
			
			//if we can move down the left side
			if(currNode.getLeftNode() != null)
			{							
				currNode = currNode.getLeftNode();					
				displayInOrder();
			}		
			
			if(currNode.getRightNode() != null)
			{
				//System.out.println("here");				
				currNode = currNode.getRightNode();
				displayInOrder();
			}			
			
			if(currNode.getLeftNode() == null && currNode.getRightNode() == null) 
			{		
				
				//System.out.print("down here");
				//System.out.print(currNode.getLeftNode().getPayload() + " -> ");
				if(currNode.getParentNode().getLeftNode() != null)
				{
					currNode.getParentNode().setLeftNode(null);
					currNode = root;
					displayInOrder();
				}
				else
				{
					currNode.getParentNode().setRightNode(null);
					currNode = root;
					displayInOrder();
				}
			}
			
			
		}
	}
	
	public void displayPostOrder()
	{
		System.out.println("**** Post Order ****");
		if(this.root == null)
		{
			System.out.println("Empty Tree");
		}		
	}
	
	public void add(int value)
	{
		Node theNode = new Node(value);
		if(this.root == null)
		{
			this.root = theNode;
			currNode = this.root;
			count++;
		}
		else
		{
			this.root.addNode(theNode);
			count++;
		}
	}
}