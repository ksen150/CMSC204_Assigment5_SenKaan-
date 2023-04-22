import java.util.ArrayList;

public class MorseCodeTree implements LinkedConverterTreeInterface<java.lang.String> {
	
	private TreeNode<String> root;
	
	/* 
	 * Constructor - calls the buildTree method
	 */
	public MorseCodeTree()
	{
		this.root = null;
		buildTree();
	}
	
	/*
	 * Returns a reference to the root
	 * @returns - a reference to root
	 */
	public TreeNode<java.lang.String> getRoot()
	{
		return root;
	}
	
	/*
	 * sets the root of the MorseCodeTree
	 * @param newNode - a newNode that will be the root of MorseCodeTree
	 */
	public void setRoot(TreeNode<String> newNode)
	{
		root = new TreeNode<String>(newNode);
	}
	
	/*
	 * Adds element to the correct position in the tree based on the code This method will call the recursive method addNode
	 * @param code - the code for the new node to be added
	 */
	public void insert(String code, String letter)
	{
		if(root == null)
		{
			root = new TreeNode<String>(letter);
		}
		else 
		{
			addNode(root, code, letter);
		}
	}
	
	/*
	 * This is a recursive method that adds element to the correct position in the tree based on the code
	 * @param root - the root of the tree
	 * @param code - the code 
	 * @param letter - the data of the new TreeNode to be added
	 */
	public void addNode(TreeNode<String> root, String code, String letter)
	{
		if(code.length() > 1)
		{
			if(code.charAt(0) == '-')
			{
				addNode(root.rightChild, code.substring(1), letter);
			}
			else {
				addNode(root.leftChild, code.substring(1), letter);
			}
		}
		else {
			if(code.equals("."))
			{
				root.leftChild = new TreeNode<String>(letter);
			}
			else 
			{
				root.rightChild = new TreeNode<String>(letter);
			}
		}
	}
	
	/*
	 * Fetch the data in the tree based on the code This method will call the recursive method fetchNode
	 * @param code - the code that describes the traversals
	 * @return a string (letter) that corresponds to the code
	 */
	public String fetch(String code)
	{
		String fetch = fetchNode(root, code);
		return fetch;
	}
	
	/*
	 * This is the recursive method that fetches the data of the TreeNode
	 * @param root - the root of the tree 
	 * @param code - the code for this particular recursive instance of addNode
	 * @return a string (letter) that corresponds to the code
	 */
	public String fetchNode(TreeNode<String> root, String code)
	{
		String letter = "";
		if(code.length() > 1)
		{
			if(code.charAt(0) == '.')
			{
				letter += fetchNode(root.leftChild, code.substring(1));
			}
			else 
			{
				letter += fetchNode(root.rightChild, code.substring(1));
			}
		}
		else 
		{
			if(code.equals("."))
			{
				letter += root.leftChild.getData();
				return letter;
			}
			else 
			{
				letter += root.rightChild.getData();
				return letter;
			}
		}
		return letter;
	}
	
	/* 
	 * This operation is not supported in the MorseCodeTree
	 * @param data - data of node to be deleted
	 * @return reference to current tree
	 */
	public MorseCodeTree delete(String data) throws UnsupportedOperationException
	{
		throw new UnsupportedOperationException();
	}
	
	/*
	 * This operation is not supported in the MorseCodeTree
	 * @returns reference to the current tree
	 */
	public MorseCodeTree update() throws UnsupportedOperationException
	{
		throw new UnsupportedOperationException();
	}
	
	/*
	 * This method builds the MorseCodeTree by inserting the nodes of the tree level by level based on the code.
	 */
	public void buildTree()
	{
		//root level 
		insert("","");
		
		//level 1
		insert(".","e"); insert("-","t");
		
		//level 2
		insert("..","i"); insert(".-","a"); insert("-.","n"); insert("--","m");
		
		//level 3
		insert("...","s"); insert("..-","u"); insert(".-.","r"); insert(".--","w"); insert("-..","d"); insert("-.-","k"); insert("--.","g"); insert("---","o");
		
		//level 4
		insert("....","h"); insert("...-","v"); insert("..-.","f"); insert(".-..","l"); insert(".--.","p"); insert(".---","j"); insert("-...","b"); insert("-..-","x"); 
		insert("-.-.","c"); insert("-.--","y"); insert("--..","z"); insert("--.-","q");
		
	}
	
	
	/*
	 * Returns an ArrayList of the items in the linked Tree in LNR (Inorder) Traversal order Used for testing to make sure tree is built correctly
	 * @return an ArrayList of items in the linked tree
	 */
	public ArrayList<String> toArrayList()
	{
		ArrayList<String> list = new ArrayList<String>();
		LNRoutputTraversal(root, list);
		return list;
	}
	
	/*
	 * The recursive method to put the contents of the tree in an ArrayList in LNR (Inorder)
	 * @param root - the root of the tree
	 * @param list - the ArrayList that will hold the contents of the tree in LNR order
	 */
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list)
	{
		if(root.leftChild == null && root.rightChild == null)
		{
			list.add(root.getData() + " ");
		}
		else 
		{
			if(root.leftChild != null)
			{
				LNRoutputTraversal(root.leftChild, list);
				list.add(root.getData() + " ");
			}
			if(root.rightChild != null)
			{
				LNRoutputTraversal(root.rightChild, list);
			}
		}
	}
}
