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
    assertEquals(Integer.valueOf(1), tree.getObject());
    assertNull(tree.getLeft());
    assertNull(tree.getRight());
  }

  public void testInsertMultiNodes1()
  {
    AVLTree<Integer> tree = new AVLTree<>();
    tree.insert(2);
    tree.insert(1);
    tree.insert(3);
    assertEquals(Integer.valueOf(2), tree.getObject());
    assertEquals(Integer.valueOf(1), tree.getLeft().getObject());
    assertEquals(Integer.valueOf(3), tree.getRight().getObject());
    assertNull(tree.getLeft().getLeft());
    assertNull(tree.getLeft().getRight());
    assertNull(tree.getRight().getLeft());
    assertNull(tree.getRight().getRight());
  }

  public void testInsertMultiNodes2()
  {
    AVLTree<Integer> tree = new AVLTree<>();
    tree.insert(2);
    tree.insert(3);
    tree.insert(1);
    assertEquals(Integer.valueOf(2), tree.getObject());
    assertEquals(Integer.valueOf(1), tree.getLeft().getObject());
    assertEquals(Integer.valueOf(3), tree.getRight().getObject());
    assertNull(tree.getLeft().getLeft());
    assertNull(tree.getLeft().getRight());
    assertNull(tree.getRight().getLeft());
    assertNull(tree.getRight().getRight());
  }
}
