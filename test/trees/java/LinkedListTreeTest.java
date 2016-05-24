package test.trees.java;

import org.testng.Assert;
import org.testng.annotations.Test;

import trees.java.LinkedListTree;

public class LinkedListTreeTest 
{
	LinkedListTree llt = new LinkedListTree();

	@Test
	public void LinkedListTreeTTest()
	{
		Assert.assertNotNull(new LinkedListTree());
	}
	@Test
	public void addTest()
	{
		llt.add("hello");
		llt.add("ant");
		llt.add("yes");
		llt.add("bark");
		llt.add("zeb");
		Assert.assertEquals(llt.getHeight(), 3);
		Assert.assertEquals(llt.getHowManyNodes(), 5);
		llt.deleteTree();
		Assert.assertEquals(llt.getHowManyNodes(), 0);
	}

	@Test
	public void getPreOrderTest()
	{
		Assert.assertEquals(llt.getInOrder(), "");
		llt.add("hello");
		llt.add("ant");
		llt.add("yes");
		llt.add("bark");
		llt.add("zeb");
		Assert.assertEquals(llt.getPreOrder(), "helloantbarkyeszeb");
		llt.deleteTree();
	}

	@Test
	public void getInOrderTest()
	{
		Assert.assertEquals(llt.getInOrder(), "");
		llt.add("hello");
		llt.add("ant");
		llt.add("yes");
		llt.add("bark");
		llt.add("zeb");
		Assert.assertEquals(llt.getInOrder(), "antbarkhelloyeszeb");
		llt.deleteTree();
	}

	@Test
	public void getPostOrderTest()
	{
		Assert.assertEquals(llt.getPreOrder(), "");
		llt.add("hello");
		llt.add("ant");
		llt.add("yes");
		llt.add("bark");
		llt.add("zeb");
		Assert.assertEquals(llt.getPostOrder(), "antbarkyeszebhello");
		llt.deleteTree();
	}

	@Test
	public void getHeightTest()
	{
		llt.add("hello");
		llt.add("ant");
		Assert.assertEquals(llt.getHeight(), 2);
		llt.add("yes");
		llt.add("bark");
		llt.add("zeb");	
		Assert.assertEquals(llt.getHeight(), 3);
		llt.add("beer");
		llt.add("aunt");
		llt.deleteTree();
		Assert.assertEquals(llt.getHeight(), 0);
	}
	
	@Test
	public void getNumberOfLeafsTest()
	{
	llt.add("hello");
	Assert.assertEquals(llt.getNumberOfLeafs(), 1);
	llt.add("ant");
	llt.add("yes");
	llt.add("bark");
	llt.add("zeb");
	Assert.assertEquals(llt.getNumberOfLeafs(), 2);
	llt.deleteTree();
	Assert.assertEquals(llt.getNumberOfLeafs(), 0);
	}
	
	@Test
	public void searchForTest()
	{
		llt.add("hello");
		llt.add("ant");
		llt.add("yes");
		llt.add("bark");
		llt.add("zeb");
		llt.searchFor("zeb");
		llt.searchFor("heb");
		
	}
	
	@Test
	public void deleteTreeTest()
	{
		llt.add("hello");
		llt.add("ant");
		llt.add("yes");
		llt.add("bark");
		llt.add("zeb");
		llt.deleteTree();
		Assert.assertEquals(llt.getHeight(), 0);
		Assert.assertEquals(llt.getHowManyNodes(), 0);
	}
	
	@Test
	public void getHowManyNodesTest()
	{
		llt.add("hello");
		llt.add("ant");
		llt.add("yes");
		llt.add("bark");
		llt.add("zeb");
		Assert.assertEquals(llt.getHowManyNodes(), 5);
		llt.add("water");
		Assert.assertEquals(llt.getHowManyNodes(), 6);
		llt.deleteTree();
		Assert.assertEquals(llt.getHowManyNodes(), 0);
	}
	
	@Test
	public void isEmptyTest()
	{
		llt.add("hello");
		llt.add("ant");
		llt.add("yes");
		llt.add("bark");
		llt.add("zeb");
		Assert.assertEquals(llt.isEmpty(), false);
		llt.deleteTree();
		Assert.assertEquals(llt.isEmpty(), true);
	}
}
