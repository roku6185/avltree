package se.alike.avltree;

public interface Tree<T>
{
  T getObject();
  Tree<T> getLeft();
  Tree<T> getRight();
  void insert(T object);
  void delete(T object);
  boolean search(T object);
}
