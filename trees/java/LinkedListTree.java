package trees.java;

/**
 * 
 * @author Charles
 *
 */
public class LinkedListTree implements Tree
{
	/**
	 * 
	 */

	private TreeNode linkedList = null;
	private int nodes = 0;

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
	 * 
	 */
	@Override
	public String getPreOrder() 
	{
		StringBuffer sb = new StringBuffer();
		helpGetPreOrder(linkedList, sb);
		return sb.toString();
	}

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
	 * 
	 */
	@Override
	public String getInOrder() 
	{
		StringBuffer sb = new StringBuffer();
		helpGetInOrder(linkedList, sb);
		return sb.toString();
	}

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
	 * 
	 */
	@Override
	public String getPostOrder() 
	{
		StringBuffer sb = new StringBuffer();
		helpGetPostOrder(linkedList, sb);
		return sb.toString();
	}

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
	 * 
	 */
	@Override
	public int getHeight() 
	{
		return helpGetHeight(linkedList);
	}

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
	 * 
	 */
	@Override
	public int getNumberOfLeafs() 
	{
		return leafCounter(linkedList);
	}

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
	 * 
	 */
	@Override
	public TreeNode searchFor(String item) 
	{
		return helpSearchFor(linkedList, item);
	}

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
	 * 
	 */
	@Override
	public void deleteTree() 
	{
		nodes = 0;
		linkedList = null;
	}
	/**
	 * 
	 */
	@Override
	public int getHowManyNodes() 
	{
		return nodes;
	}
	/**
	 * 
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