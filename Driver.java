public class Driver 
{
	public static void main(String[] args)
	{
		System.out.println("inOrder");
		BinaryTree bt = new BinaryTree();
		bt.add(10);
		bt.add(4);
		bt.add(16);
		bt.add(0);
		bt.add(8);
		bt.add(12);
		bt.add(81);
		bt.add(2);
		bt.add(5);
		bt.add(9);
		bt.add(11);
		bt.add(24);
		bt.add(1);
		bt.add(3);
		bt.add(38);
		bt.displayInOrder();
		
		System.out.println(" ");
		System.out.println("postOrder");
		BinaryTree bt2 = new BinaryTree();
		bt2.add(10);
		bt2.add(4);
		bt2.add(16);
		bt2.add(0);
		bt2.add(8);
		bt2.add(12);
		bt2.add(81);
		bt2.add(2);
		bt2.add(5);
		bt2.add(9);
		bt2.add(11);
		bt2.add(24);
		bt2.add(1);
		bt2.add(3);
		bt2.add(38);
		bt2.displayPostOrder();
	}
}