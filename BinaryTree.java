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
	public void displayInOrder() 
	{
		if(this.root == null)
		{
			System.out.println("Empty Tree");
		}
		else if(count > 0)
		{			
			//if we haven't already displayed currNode payload
			if(currNode.getVisited() == false)
			{
				System.out.print(currNode.getPayload() + ", ");
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
				//System.out.println("blah");				
				currNode = currNode.getRightNode();
				displayInOrder();
				
			}			
			
			if(currNode.getLeftNode() == null && currNode.getRightNode() == null) 
			{		
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
		if(this.root == null)
		{
			System.out.println("Empty Tree");
		}		
		else if(count > 1)
		{
			if(currNode.getLeftNode() != null)
			{							
				currNode = currNode.getLeftNode();					
				displayPostOrder();				
			}
			if(currNode.getVisited() == false)
			{
				System.out.print(currNode.getPayload() + ", ");
				currNode.setVisited(true);
				count--;			
			}
			else 
			{
				if(currNode.getRightNode() == null)
				{
					if(currNode.getParentNode().getLeftNode() != null)
					{
						currNode.getParentNode().setLeftNode(null);
						currNode = root;
					}
					else
					{
						currNode.getParentNode().setRightNode(null);
						currNode = root;
					}
					displayPostOrder();
				}
				else
				{
					currNode = currNode.getRightNode();
					displayPostOrder();
				}
			}			
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