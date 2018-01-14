package se.alike.avltree;

import java.util.StringJoiner;

public class AVLTree<T extends Comparable<? super T>> implements BinaryTree<T>
{
  private AVLTree<T> left;
  private AVLTree<T> right;
  private T object;
  private int height;

  public AVLTree()
  {
    this.left = null;
    this.right = null;
    this.object = null;
    this.height = 0;
  }

  @Override
  public T getObject()
  {
    return object;
  }

  @Override
  public AVLTree<T> getLeft()
  {
    return left;
  }

  @Override
  public AVLTree<T> getRight()
  {
    return right;
  }

  public int getHeight()
  {
    return height;
  }

  private int getBalanceFactor()
  {
    int leftHeight = getLeft() == null ? 0 : getLeft().height;
    int rightHeight = getRight() == null ? 0 : getRight().height;
    return leftHeight - rightHeight;
  }

  @Override
  public void insert(T other)
  {
    if (this.object == null) {
      this.object = other;
      this.height = 1;
    }
    else {
      if (object.compareTo(other) > 0) {
        if (left == null)
          left = new AVLTree<T>();

        left.insert(other);
      }
      else {
        if (right == null)
          right = new AVLTree<T>();

        right.insert(other);
      }

      height = 1 + Math.max(
        left != null ? left.height : 0,
        right != null ? right.height : 0
      );
    }
  }

  @Override
  public void delete(T other)
  {
    delete(other, this, null);
  }

  private void delete(T other, AVLTree<T> root, AVLTree<T> parent)
  {
    if (root.object.compareTo(other) == 0)
      removeNode(root, parent);
    else if (root.left != null && root.left.object.compareTo(other) >= 0)
      delete(other, root.left, root);
    else if (root.right != null && root.right.object.compareTo(other) <= 0)
      delete(other, root.right, root);
  }

  private void removeNode(AVLTree<T> node, AVLTree<T> parent)
  {
    // Case 1: Two children
    if (node.left != null && node.right != null) {
      T minRight = disconnectMinRight(node);
      node.object = minRight;
    }
    // Case 2: Single child
    else if (node.left != null || node.right != null) {
      if (parent.left == node)
        parent.left = node.left;
      else if (parent.right == node)
        parent.right = node.right;
    }
    // Case 3: No children
    else {
      if (parent.left == node)
        parent.left = null;
      else if (parent.right == node)
        parent.right = null;
    }
  }

  private T disconnectMinRight(AVLTree<T> root)
  {
    // Find minimum node in right subtree
    AVLTree<T> parent = root;
    root = root.right;

    while (root.left != null) {
      parent = root;
      root = root.left;
    }

    // Disconnect minimum node from parent
    if (parent != null && parent.left == root)
      parent.left = null;
    else if (parent != null && parent.right == root)
      parent.right = null;

    return root.object;
  }

  @Override
  public boolean search(T other)
  {
    if (object == null)
      return false;

    if (left != null && object.compareTo(other) > 0)
      return left.search(other);
    else if (right != null && object.compareTo(other) < 0)
      return right.search(other);
    else if (object.compareTo(other) == 0)
      return true;

    return false;
  }

  @Override
  public String toString()
  {
    StringJoiner joiner = new StringJoiner(",");
    if (object != null) joiner.add(object.toString());
    joiner.add("h:" + height);
    joiner.add("bf:" + getBalanceFactor());
    if (left != null) joiner.add("L:" + left.toString());
    if (right != null) joiner.add("R:" + right.toString());
    return "(" + joiner.toString() + ")";
  }
}
