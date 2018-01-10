package se.alike.avltree;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TraversalPostorderTest extends TestCase
{
  public TraversalPostorderTest(String testName)
  {
    super(testName);
  }

  public static Test suite()
  {
    return new TestSuite(TraversalPostorderTest.class);
  }

  public void testPostorderSimple1()
  {
    AVLTree<Integer> tree = new AVLTree<>();
    tree.insert(1);
    tree.insert(2);
    tree.insert(3);
    assertEquals("3-2-1", BinaryTreeStringTraversal.postorder(tree));
  }
}
