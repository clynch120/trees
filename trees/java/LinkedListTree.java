package trees.java;

/**
 * 
 * @author Charles
 *	Linked List Tree
 */
public class LinkedListTree implements Tree
{
	
	private TreeNode linkedList = null;	// linked list tree
	private int nodes = 0;	// keep track of nodes

	/**
	 * adds an item to the tree 
	 * uses private method if needed
	 */
	@Override
	public void add(String item) 
	{
		TreeNode tn = new TreeNode(item);
		tn.left = null;
		tn.right = null;
		tn.item = item; 

		if (linkedList == null)
		{
			linkedList = tn;
		}
		else
		{
			addHelper(linkedList, item);
		}
		nodes++;
	}
	
	/**
	 * 
	 * @param tn takes a TreeNode 
	 * @param item takes a String item 
	 * @returns a TreeNode object
	 * private method used if more than one 
	 * item is in tree
	 */
	private TreeNode addHelper(TreeNode tn, String item)
	{
		if (tn == null) 
		{
			TreeNode node = new TreeNode (item); 
			node.left = null; 
			node.right = null; 
			node.item = item; 
			return (node);
		}
		if (item.compareTo(tn.item) <= 0)
		{
			tn.left = addHelper(tn.left, item);
		}
		if (item.compareTo(tn.item) >= 0)
		{
			tn.right = addHelper(tn.right, item);
		}

		return tn;
	}

	/**
	 * calls private method to get and return
	 *  pre order traversal of tree
	 */
	@Override
	public String getPreOrder() 
	{
		StringBuffer sb = new StringBuffer();
		helpGetPreOrder(linkedList, sb);
		return sb.toString();
	}
	/**
	 *  private method to retutn pre order traversal
	 * @param t takes a TreeNode object
	 * @param sb takes a StringBuffer object
	 * @return String of pre order tree traversal
	 */
	private String helpGetPreOrder(TreeNode t, StringBuffer sb)
	{
		if (t != null)
		{
			sb.append(t.item);
			helpGetInOrder(t.left, sb);
			helpGetInOrder(t.right, sb);
		}
		return sb.toString();
	}
	/**
	 * calls private method to get and return
	 *  in order traversal of tree
	 */
	@Override
	public String getInOrder() 
	{
		StringBuffer sb = new StringBuffer();
		helpGetInOrder(linkedList, sb);
		return sb.toString();
	}
	/**
	 * private method to return in order traversal
	 * @param t takes a TreeNode object
	 * @param sb takes a StringBuffer object
	 * @return String of in order tree traversal
	 */
	private String helpGetInOrder(TreeNode t, StringBuffer sb)
	{
		if (t != null)
		{
			helpGetInOrder(t.left, sb);
			sb.append(t.item);
			helpGetInOrder(t.right, sb);
		}
		return sb.toString();
	}
	/**
	 * calls private method to get and return
	 *  post order traversal of tree
	 */
	@Override
	public String getPostOrder() 
	{
		StringBuffer sb = new StringBuffer();
		helpGetPostOrder(linkedList, sb);
		return sb.toString();
	}
	/**
	 * private method to return post order traversal
	 * @param t takes a TreeNode object
	 * @param sb takes a StringBuffer object
	 * @return String of post order tree traversal
	 */
	private String helpGetPostOrder(TreeNode t, StringBuffer sb)
	{
		if (t != null)
		{
			helpGetInOrder(t.left, sb);
			helpGetInOrder(t.right, sb);
			sb.append(t.item);
		}
		return sb.toString();
	}
	/**
	 * returns int height of tree
	 */
	@Override
	public int getHeight() 
	{
		return helpGetHeight(linkedList);
	}
	/**
	 * 
	 * @param tn takes TreeNode object
	 * @return height of tree
	 */
	private int helpGetHeight(TreeNode tn)
	{
		if (tn == null)
		{
			return 0;
		}
		int left = helpGetHeight(tn.left);
		int right = helpGetHeight(tn.right);

		if (left > right)
		{
			return left + 1;
		}
		else 
		{
			return right + 1;
		}
	}
	/**
	 * returns int of number of leafs on tree
	 */
	@Override
	public int getNumberOfLeafs() 
	{
		return leafCounter(linkedList);
	}
	/**
	 * 
	 * @param tn takes TreeNode object
	 * @return leafs on the tree
	 */
	private int leafCounter(TreeNode tn)
	{
		if (tn == null)
		{
			return 0;
		}
		if (tn.right == null && tn.left == null)
		{
			return 1;
		}
		else
		{
			return leafCounter(tn.left) + leafCounter(tn.right);
		}
	}
	/**
	 * returns TreeNode of searched for item
	 */
	@Override
	public TreeNode searchFor(String item) 
	{
		return helpSearchFor(linkedList, item);
	}
	/**
	 * 	
	 * @param tn takes TreeNode object
	 * @param item takes a String to search the tree 
	 * @return TreeNode of item searched for
	 */
	private TreeNode helpSearchFor(TreeNode tn, String item)
	{
		TreeNode temp = tn;
		if (temp == null)
		{
			return tn;
		}
		else
		{
			if (tn.item.equals(item))
			{
				return tn;
			}
			if (item.compareTo(tn.item) <= 0)
			{
				temp = helpSearchFor(tn.left, item);
			}
			else
			{
				temp = helpSearchFor(tn.right, item);
			}
		}
		return temp;
	}
	/**
	 * deletes the tree
	 */
	@Override
	public void deleteTree() 
	{
		nodes = 0;
		linkedList = null;
	}
	/**
	 * returns int of nodes
	 */
	@Override
	public int getHowManyNodes() 
	{
		return nodes;
	}
	/**
	 * checks if the tree has any nodes
	 */
	@Override
	public boolean isEmpty() 
	{
		if (linkedList == null)
		{
			return true;
		}
		return false;
	}
}