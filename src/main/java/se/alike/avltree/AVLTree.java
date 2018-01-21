package se.alike.avltree;

import java.util.StringJoiner;

public class AVLTree<T extends Comparable<? super T>> implements BinaryTree<T>
{
  private AVLTree<T> left;
  private AVLTree<T> right;
  private T object;
  private int height;

  /**
   * Creates an empty AVL tree.
   *
   * @return AVLTree<T>
   */
  public AVLTree()
  {
    this.left = null;
    this.right = null;
    this.object = null;
    this.height = 0;
  }

  /**
   * Returns the object of the root node of this tree.
   *
   * @return T
   */
  @Override
  public T getObject()
  {
    return object;
  }

  /**
   * Returns the left subtree of this tree.
   *
   * @return AVLTree<T>
   */
  @Override
  public AVLTree<T> getLeft()
  {
    return left;
  }

  /**
   * Returns the right subtree of this tree.
   *
   * @return AVLTree<T>
   */
  @Override
  public AVLTree<T> getRight()
  {
    return right;
  }

  /**
   * Returns the height of this tree.
   * A node with a single node has a height of 1.
   *
   * @return AVLTree<T>
   */
  public int getHeight()
  {
    return height;
  }

  /**
   * Returns the balance factor of this tree, which is defined as:
   * height(left subtree) - height(right subtree))
   *
   * @return int
   */
  private int getBalanceFactor()
  {
    int leftHeight = getLeft() == null ? 0 : getLeft().height;
    int rightHeight = getRight() == null ? 0 : getRight().height;
    return leftHeight - rightHeight;
  }

  /**
   * Performs an auto-balanced insert into this tree.
   * An object less than root node will ended up in left subtree,
   * otherwise in the right subtree.
   *
   * @param other Object to insert into this tree
   */
  @Override
  public void insert(T other)
  {
    // Insert node as leaf
    if (object == null) {
      object = other;
      height = 1;
    }
    else {
      // Search in correct subtree
      if (object.compareTo(other) > 0) {
        if (left == null)
          left = new AVLTree<T>();

        left.insert(other);
        height++;
      }
      else {
        if (right == null)
          right = new AVLTree<T>();

        right.insert(other);
        height++;
      }

      // Adjust height
      height = 1 + Math.max(
        left != null ? left.height : 0,
        right != null ? right.height : 0
      );

      // Rebalance right heavy tree?
      if (getBalanceFactor() < -1) {
        if (right != null && right.getBalanceFactor() >= 1) {
          right.rotateRight();
          rotateLeft();
        }
        else {
          rotateLeft();
        }
      }
      // Rebalance left heavy tree?
      else if (getBalanceFactor() > 1) {
        if (left != null && left.getBalanceFactor() <= -1) {
          left.rotateLeft();
          rotateRight();
        }
        else {
          rotateRight();
        }
      }
    }
  }

  /**
   * Performs a left rotation:
   *
   *    1              2
   *   / \            / \
   *  a   2    =>    1   3
   *     / \        / \
   *    b   3      a   b
   *
   */
  private void rotateLeft()
  {
    // Create new left subtree
    AVLTree<T> tmp = new AVLTree<T>();
    tmp.object = object;
    tmp.left = left;
    tmp.right = right != null ? right.left : null;
    tmp.height = 1 + Math.max(
      tmp.left != null ? tmp.left.height : 0,
      tmp.right != null ? tmp.right.height : 0
    );

    // Update root node
    object = right.object;
    left = tmp;
    right = right.right;
    height = 1 + Math.max(
      left != null ? left.height : 0,
      right != null ? right.height : 0
    );
  }

  /**
   * Performs a right rotation:
   *
   *      3          2
   *     / \        / \
   *    2   a  =>  1   3
   *   / \            / \
   *  1   b          b   a
   *
   */
  private void rotateRight()
  {
    // Create new right subtree
    AVLTree<T> tmp = new AVLTree<T>();
    tmp.object = object;
    tmp.left = left != null ? left.right : null;
    tmp.right = right;
    tmp.height = 1 + Math.max(
      tmp.left != null ? tmp.left.height : 0,
      tmp.right != null ? tmp.right.height : 0
    );

    // Update root node
    object = left.object;
    left = left.left;
    right = tmp;
    height = 1 + Math.max(
      left != null ? left.height : 0,
      right != null ? right.height : 0
    );
  }

  /**
   * Deletes an object from this tree.
   *
   * @param other Object to delete
   */
  @Override
  public void delete(T other)
  {
    delete(other, this, null);
  }

  /**
   * Recursively deletes an object <other> from tree <root> with 
   * parent tree <parent>.
   *
   * @param other Object to delete
   * @param root Tree to delete object from
   * @param parent Parent of <root>
   */
  private void delete(T other, AVLTree<T> root, AVLTree<T> parent)
  {
    if (root.object.compareTo(other) == 0)
      removeNode(root, parent);
    else if (root.left != null && root.left.object.compareTo(other) >= 0)
      delete(other, root.left, root);
    else if (root.right != null && root.right.object.compareTo(other) <= 0)
      delete(other, root.right, root);
  }

  /**
   *
   * @param node Node containing object to delete
   * @param parent Parent of <node>
   */
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

  /**
   * Disconnects and returns the minimum object from the right subtree 
   * of the tree <root>.
   *
   * @param root
   */
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

  /**
   * Searches for an object in this tree. Returns true if object 
   * was found, otherwise false.
   *
   * @return boolean
   */
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

  /**
   * Returns a string representation of this tree.
   * Used for debug purposes.
   *
   * @return string
   */
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
