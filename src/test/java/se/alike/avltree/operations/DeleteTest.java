package se.alike.avltree;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class DeleteTest extends TestCase
{
  public DeleteTest(String testName)
  {
    super(testName);
  }

  public static Test suite()
  {
    return new TestSuite(DeleteTest.class);
  }

  public void testDeleteLeafNode1()
  {
    AVLTree<Integer> tree = new AVLTree<>();
    tree.insert(2);
    tree.insert(1);
    tree.insert(3);
    assertEquals("1-2-3", BinaryTreeStringTraversal.inorder(tree));
    tree.delete(1);
    assertEquals("2-3", BinaryTreeStringTraversal.inorder(tree));
  }

  public void testDeleteLeafNode2()
  {
    AVLTree<Integer> tree = new AVLTree<>();
    tree.insert(2);
    tree.insert(1);
    tree.insert(3);
    assertEquals("1-2-3", BinaryTreeStringTraversal.inorder(tree));
    tree.delete(3);
    assertEquals("1-2", BinaryTreeStringTraversal.inorder(tree));
  }

  public void testDeleteNodeWithSingleChild1()
  {
    AVLTree<Integer> tree = new AVLTree<>();
    tree.insert(2);
    tree.insert(1);
    tree.insert(3);
    tree.insert(4);
    assertEquals("1-2-3-4", BinaryTreeStringTraversal.inorder(tree));
    tree.delete(3);
    assertEquals("1-2-4", BinaryTreeStringTraversal.inorder(tree));
  }

  public void testDeleteNodeWithSingleChild2()
  {
    AVLTree<Integer> tree = new AVLTree<>();
    tree.insert(3);
    tree.insert(2);
    tree.insert(4);
    tree.insert(1);
    assertEquals("1-2-3-4", BinaryTreeStringTraversal.inorder(tree));
    tree.delete(2);
    assertEquals("1-3-4", BinaryTreeStringTraversal.inorder(tree));
  }

  public void testDeleteNodeWithTwoChildren1()
  {
    AVLTree<Integer> tree = new AVLTree<>();
    tree.insert(2);
    tree.insert(1);
    tree.insert(3);
    assertEquals("1-2-3", BinaryTreeStringTraversal.inorder(tree));
    tree.delete(2);
    assertEquals("1-3", BinaryTreeStringTraversal.inorder(tree));
  }

  public void testDeleteNodeWithTwoChildren3()
  {
    AVLTree<Integer> tree = new AVLTree<>();
    tree.insert(2);
    tree.insert(1);
    tree.insert(4);
    tree.insert(3);
    tree.insert(5);
    assertEquals("1-2-3-4-5", BinaryTreeStringTraversal.inorder(tree));
    tree.delete(4);
    assertEquals("1-2-3-5", BinaryTreeStringTraversal.inorder(tree));
  }

  public void testDeleteNodeWithTwoChildren4()
  {
    AVLTree<Integer> tree = new AVLTree<>();
    tree.insert(4);
    tree.insert(2);
    tree.insert(1);
    tree.insert(3);
    tree.insert(6);
    tree.insert(5);
    tree.insert(7);
    tree.insert(8);
    assertEquals("1-2-3-4-5-6-7-8", BinaryTreeStringTraversal.inorder(tree));
    tree.delete(4);
    assertEquals("1-2-3-5-6-7-8", BinaryTreeStringTraversal.inorder(tree));
  }
}
