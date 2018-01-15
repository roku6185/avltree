package se.alike.avltree;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class HeightTest extends TestCase
{
  public HeightTest(String testName)
  {
    super(testName);
  }

  public static Test suite()
  {
    return new TestSuite(HeightTest.class);
  }

  public void testHeight0()
  {
    AVLTree<Integer> tree = new AVLTree<>();
    assertEquals(0, tree.getHeight());
  }

  public void testHeight1()
  {
    AVLTree<Integer> tree = new AVLTree<>();
    tree.insert(1);
    assertEquals(1, tree.getHeight());
  }

  public void testHeight2Case1()
  {
    AVLTree<Integer> tree = new AVLTree<>();
    tree.insert(2);
    tree.insert(1);
    assertEquals(2, tree.getHeight());
    assertEquals(1, tree.getLeft().getHeight());
  }

  public void testHeight2Case2()
  {
    AVLTree<Integer> tree = new AVLTree<>();
    tree.insert(2);
    tree.insert(1);
    tree.insert(3);
    assertEquals(2, tree.getHeight());
    assertEquals(1, tree.getLeft().getHeight());
    assertEquals(1, tree.getRight().getHeight());
  }

  public void testHeight3()
  {
    AVLTree<Integer> tree = new AVLTree<>();
    tree.insert(2);
    tree.insert(1);
    tree.insert(3);
    tree.insert(4);
    assertEquals(3, tree.getHeight());
    assertEquals(1, tree.getLeft().getHeight());
    assertEquals(2, tree.getRight().getHeight());
    assertEquals(1, tree.getRight().getRight().getHeight());
  }
}
