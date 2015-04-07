import java.util.Random;
public class Driver 
{
	public static void main(String[] args)
	{
		/*Random r = new Random();
		BinaryTree bt = new BinaryTree();
		for(int i = 0; i < 5000; i++)
		{
			bt.add(r.nextInt());
		}
		System.out.print(bt.isBalanced());
		*/
		BinaryTree bt = new BinaryTree();
		bt.add(5);
		bt.add(4);
		bt.add(1);
		/*
		bt.add(1);
		bt.add(0);
		*/
		//bt.displayPreOrder();
		
		//System.out.println(bt.search(11));
		
		/*
		System.out.println("inOrder");
		bt.displayInOrder();
		System.out.println("preOrder");
		bt.displayPreOrder();
		System.out.println("postOrder");
		bt.displayPostOrder();
		*/
	}
}