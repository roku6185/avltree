package se.alike.avltree;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AutoBalanceInsertTest extends TestCase
{
  public AutoBalanceInsertTest(String testName)
  {
    super(testName);
  }

  public static Test suite()
  {
    return new TestSuite(AutoBalanceInsertTest.class);
  }

  public void testLeftHeavyTree1()
  {
    AVLTree<Integer> tree = new AVLTree<>();
    tree.insert(3);
    tree.insert(2);
    tree.insert(1);
    assertEquals("1-2-3", BinaryTreeStringTraversal.inorder(tree));
    assertEquals(2, tree.getHeight());
  }

  public void testRightHeavyTree1()
  {
    AVLTree<Integer> tree = new AVLTree<>();
    tree.insert(1);
    tree.insert(2);
    tree.insert(3);
    assertEquals("1-2-3", BinaryTreeStringTraversal.inorder(tree));
    assertEquals(2, tree.getHeight());
  }
}
