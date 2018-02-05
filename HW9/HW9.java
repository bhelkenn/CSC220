import java.io.*;
import java.util.*;

public class HW9
{
	public static void main(String[] args) {
		TreeDisplay<Integer> display = new TreeDisplay<Integer>();

		//randomTree
		TreeNode<Integer> tree = randomTree(6, 2);
		display.setRoot(tree);
		
		//replace
		replace(tree, 2, 7);
		display.setRoot(tree);
		
		//countNodesAtDepth
		System.out.println("There are " + countNodesAtDepth(tree, 3) + " at depth 3");
		
		//allSame
		if (allSame(tree))
			System.out.println("All objects in tree are the same.");
		else
			System.out.println("There is at least one object that is different.");
		
		//leafList
		List<Integer> list = leafList(tree);
		System.out.print("In list form: [" + list.get(0));
		for (int i = 1; i < list.size(); i++) {
			System.out.print(", " + list.get(i));
		}
		System.out.print("]");
		System.out.println();
		
		//reflect - how to test before and after?
		reflect(tree);
		list = leafList(tree);
		System.out.print("In list form: [" + list.get(0));
		for (int i = 1; i < list.size(); i++) {
			System.out.print(", " + list.get(i));
		}
		System.out.print("]");
		System.out.println();
		display.setRoot(tree);
		
		//condense
		tree = condense(tree);
		list = leafList(tree);
		System.out.print("In list form: [" + list.get(0));
		for (int i = 1; i < list.size(); i++) {
			System.out.print(", " + list.get(i));
		}
		System.out.print("]");
		System.out.println();
		display.setRoot(tree);
		
		//save and load
		try {
			save(tree, "tree.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			TreeNode<String> sTree = load("tree.txt");
			TreeDisplay<String> displayString = new TreeDisplay<String>();
			displayString.setRoot(sTree);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//used in twentyQuestions method
	public static Scanner userInput = new Scanner(System.in);

	public static TreeNode<Integer> randomTree(int numNodes, int n)
	{
		while (n < 1) {
			System.out.print("Enter a positive integer for n: ");
			n = userInput.nextInt();
		}
		/*
		 *generate random number (0, n - 1)
		 *then increase by 1 to achieve (1, n)
		 */
		int num = (int)Math.round(Math.random() * (n - 1) + 1);
		TreeNode<Integer> tree = new TreeNode<Integer>(num);
		      
		constructingTree(tree, numNodes - 1, n);
		return tree;
	}
	
	//helper method
	public static void constructingTree(TreeNode<Integer> root, int numNodes, int n)
	{
		//base case
		if(numNodes == 0) {
			// represents your stopping point
			// when you have no more nodes to create - numNodes == 0
		}
	  
		//recursive case, when there are still more nodes to add to the tree
		else {
			// when you have more nodes to create
			// randomly decide whether a node is going to have one or two children
			double numChildren = Math.random();
			if(numChildren < 0.5 || numNodes == 1) { //1 child
				double leftOrRight = Math.random();
				// left child or right child?
			  
				//create Tree Node
				int num = (int)Math.round(Math.random() * (n - 1) + 1);
				TreeNode<Integer> newNode = new TreeNode<Integer>(num);
			  
				//set it equal to left or right child
				if(leftOrRight > 0.5)
					root.left = newNode;
				else
					root.right = newNode;
			  	constructingTree(newNode, numNodes - 1, n);
			}
			else { // if(numChildren == 2)
				int num = (int)Math.round(Math.random() * (n - 1) + 1);
				root.left = new TreeNode<Integer>(num);
				numNodes--;
			  
				num = (int)Math.round(Math.random() * (n - 1) + 1);
				root.right = new TreeNode<Integer>(num);
				numNodes--;
			  
				int howManyNodes = (int)Math.random() * numNodes;
				constructingTree(root.left, howManyNodes, n);
			  
				int newNumNodes = numNodes - howManyNodes;
				constructingTree(root.right, newNumNodes, n);
			}
		}
	}
	
	public static <E> int replace(TreeNode<E> t, E oldValue, E newValue)
	{
		if (t != null) {
			if (t.data.equals(oldValue))
				t.data = newValue;
			if (t.left != null)
				replace(t.left, oldValue, newValue);
			if (t.right != null)
				replace(t.right, oldValue, newValue);
		}
		return 0;
	}
	
	public static <E> int countNodesAtDepth(TreeNode<E> t, int depth)
	{
		int count = 0;
		//base case
		if (depth == 0)
			count++;
		else {
			if (t.left != null)
				count += countNodesAtDepth(t.left, depth - 1);
			if (t.right != null)
				count += countNodesAtDepth(t.right, depth - 1);
			//done with subtree, couldn't reach depth
		}
		return count;
	}

	public static <E> boolean allSame(TreeNode<E> t)
	{
		//assume true until proven false
		if (t.left != null) {
			if (t.data.equals(t.left.data))
				return allSame(t.left);
			else
				return false;
		}
		if (t.right != null) {
			if (t.data.equals(t.right.data))
				return allSame(t.right);
			else
				return false;
		}
		return true;
	}

	public static <E> List<E> leafList(TreeNode<E> t)
	{
		List<E> list = new ArrayList<E>();
		if (t != null)
			list.add(t.data);
		if (t.left != null) {
			List<E> left = leafList(t.left);
			while (!left.isEmpty()) {
				list.add(left.get(0));
				left.remove(0);
			}
		}
		if (t.right != null) {
			List<E> right = leafList(t.right);
			while (!right.isEmpty()) {
				list.add(right.get(0));
				right.remove(0);
			}
		}
		return list;
	}
  
	public static <E> void reflect(TreeNode<E> t)
	{
		//base case, reached a leaf
		if (t == null)
			return;
		else {
			if (t.left != null) {
				if (t.right == null) {
					t.right = t.left;
					t.left = null;
				}
				else {
					TreeNode<E> temp = t.left;
					t.left = t.right;
					t.right = temp;
				}
				reflect(t.left);
			}
			if (t.right != null) {
				if (t.left == null) {
					t.left = t.right;
					t.right = null;
				}
				else {
					TreeNode<E> temp = t.right;
					t.right = t.left;
					t.left = temp;
				}
				reflect(t.right);
			}
		}
	}
  
	public static <E> TreeNode<E> condense(TreeNode<E> t)
	{
		if (t.left != null) {
			if (t.right == null) {
				t = t.left;
				//needed in case this condition still holds after the adjustment
				t = condense(t);
			}
			else
				t.left = condense(t.left);
		}
		if (t.right != null) {
			if (t.left == null) {
				t = t.right;
				//needed in case this condition still holds after the adjustment
				t = condense(t);
			}
			else
				t.right = condense(t.right);
		}
		
		return t;
	}
  
	public static <E> void save(TreeNode<E> t, String fileName) throws IOException
	{
		PrintWriter writer = new PrintWriter(new FileWriter(fileName));
		//base case
		if (t == null)
			writer.println("$");

		writer.println(t.data);
		if (t.left == null)
			writer.println("$");
		else
			save(t.left, fileName);
  
		if (t.right == null)
			writer.println("$");
		else
			save(t.right, fileName);
		
		writer.close();
	}
  
	public static TreeNode<String> load(String fileName) throws FileNotFoundException
	{
		Scanner in = new Scanner(new File(fileName));
		TreeNode<String> t = new TreeNode<String>(null);
		String line = "";
		if (in.hasNextLine())
			line = in.nextLine();
		else {
			in.close();
			return t;
		}
		if (line.equals("$")) {
			in.close();
			return t;
		}
		else {
			t.data = line;
	  
			t.left = load(fileName);
			t.right = load(fileName);
			in.close();
	  
			return t;
		}
	}
  
	public static void twentyQuestions(TreeNode<String> t)
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Is it " + t + "? ");
		String answer = in.nextLine();
		if (answer == "yes") {
			if (t.left == null)
				System.out.println("I win!");
			else
				twentyQuestions(t.left);
		}
		else if (answer == "no") {
			if (t.right == null) {
				System.out.print("I give up. Who/what is it? ");
				String newData = in.nextLine();
				System.out.println("What distinguishes " + newData + "from " + t + "?");
				System.out.print(newData + " is ");
				String newDataPrereq = in.nextLine();
				t.left.data = newData;
				t.right = t;
				t.data = newDataPrereq;
			}
			else
				twentyQuestions(t.right);
		}
		in.close();
	}
}