package se.alike.avltree;

public interface BinaryTree<T>
{
  T getObject();
  BinaryTree<T> getLeft();
  BinaryTree<T> getRight();
  void insert(T object);
  void delete(T object);
  boolean search(T object);
}
