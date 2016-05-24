package trees.java;
/**
 * 
 * @author Charles
 *
 */
public class TreeNode 
{
	public TreeNode left;
	public String item;
	public TreeNode right;
	/**
	 * 
	 * @param item String added to the tree
	 */
	public TreeNode(String item)
	{
		this.item = item;
		this.left = null;
		this.right = null;
	}
}
