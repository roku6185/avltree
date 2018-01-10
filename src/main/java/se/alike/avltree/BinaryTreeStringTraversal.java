package se.alike.avltree;

import java.util.StringJoiner;

public class BinaryTreeStringTraversal
{
  private final static String DELIMITER = "-";

  public static String preorder(BinaryTree tree)
  {
    StringJoiner joiner = new StringJoiner(DELIMITER);
    joiner.add(tree.getObject().toString());
    if (tree.getLeft() != null) joiner.add(preorder(tree.getLeft()));
    if (tree.getRight() != null) joiner.add(preorder(tree.getRight()));
    return joiner.toString();
  }

  public static String inorder(BinaryTree tree)
  {
    StringJoiner joiner = new StringJoiner(DELIMITER);
    if (tree.getLeft() != null) joiner.add(inorder(tree.getLeft()));
    joiner.add(tree.getObject().toString());
    if (tree.getRight() != null) joiner.add(inorder(tree.getRight()));
    return joiner.toString();
  }

  public static String postorder(BinaryTree tree)
  {
    StringJoiner joiner = new StringJoiner(DELIMITER);
    if (tree.getLeft() != null) joiner.add(postorder(tree.getLeft()));
    if (tree.getRight() != null) joiner.add(postorder(tree.getRight()));
    joiner.add(tree.getObject().toString());
    return joiner.toString();
  }
}
