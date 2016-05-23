package trees.java;

public interface Tree 
{
	// add item to the tree
	void add(String item);
	
	// pre order traversal
	String getPreOrder();
	
	// in oreder traversal
	String getInOrder();
	
	// post order traversal
	String getPostOrder();
	
	// height of the tree
	int getHeight();
	
	// count leaf nodes
	int getNumberOfLeafs();
	
	// search the tree for node containing item 
	TreeNode searchFor(String item);
	
	// set tree to null
	void deleteTree();
	
	// count all nodes in the tree
	int getHowManyNodes();
	
	// if total nodes are equal to 0
	boolean isEmpty();
}