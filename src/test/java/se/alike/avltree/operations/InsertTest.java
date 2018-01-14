package se.alike.avltree;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class InsertTest extends TestCase
{
  public InsertTest(String testName)
  {
    super(testName);
  }

  public static Test suite()
  {
    return new TestSuite(InsertTest.class);
  }

  public void testInsertSingleNode()
  {
    AVLTree<Integer> tree = new AVLTree<>();
    tree.insert(1);
    assertEquals("1", BinaryTreeStringTraversal.inorder(tree));
  }

  public void testInsertMultiNodes1()
  {
    AVLTree<Integer> tree = new AVLTree<>();
    tree.insert(2);
    tree.insert(1);
    tree.insert(3);
    assertEquals("1-2-3", BinaryTreeStringTraversal.inorder(tree));
  }

  public void testInsertMultiNodes2()
  {
    AVLTree<Integer> tree = new AVLTree<>();
    tree.insert(2);
    tree.insert(3);
    tree.insert(1);
    assertEquals("1-2-3", BinaryTreeStringTraversal.inorder(tree));
  }
}
