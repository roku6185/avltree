package se.alike.avltree;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TraversalPreorderTest extends TestCase
{
  public TraversalPreorderTest(String testName)
  {
    super(testName);
  }

  public static Test suite()
  {
    return new TestSuite(TraversalPreorderTest.class);
  }

  public void testPreorderSimple1()
  {
    AVLTree<Integer> tree = new AVLTree<>();
    tree.insert(2);
    tree.insert(1);
    tree.insert(3);
    assertEquals("2-1-3", BinaryTreeStringTraversal.preorder(tree));
  }
}
