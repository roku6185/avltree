package se.alike.avltree;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TraversalInorderTest extends TestCase
{
  public TraversalInorderTest(String testName)
  {
    super(testName);
  }

  public static Test suite()
  {
    return new TestSuite(TraversalInorderTest.class);
  }

  public void testInorderSimple1()
  {
    AVLTree<Integer> tree = new AVLTree<>();
    tree.insert(1);
    tree.insert(2);
    tree.insert(3);
    assertEquals("1-2-3", BinaryTreeStringTraversal.inorder(tree));
  }
}
