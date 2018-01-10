package se.alike.avltree;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class SearchTest extends TestCase
{
  public SearchTest(String testName)
  {
    super(testName);
  }

  public static Test suite()
  {
    return new TestSuite(SearchTest.class);
  }

  public void testSearchNodeNotFound()
  {
    AVLTree<Integer> tree = new AVLTree<>();
    tree.insert(1);
    assertFalse(tree.search(2));
  }

  public void testSearchRoot()
  {
    AVLTree<Integer> tree = new AVLTree<>();
    tree.insert(1);
    assertTrue(tree.search(1));
  }

  public void testSearchLeftLeaf()
  {
    AVLTree<Integer> tree = new AVLTree<>();
    tree.insert(2);
    tree.insert(1);
    tree.insert(3);
    assertTrue(tree.search(1));
  }

  public void testSearchRightLeaf()
  {
    AVLTree<Integer> tree = new AVLTree<>();
    tree.insert(2);
    tree.insert(1);
    tree.insert(3);
    assertTrue(tree.search(3));
  }
}
