package se.alike.avltree;

public interface Tree<T>
{
  void insert(T object);
  void delete(T object);
  boolean search(T object);
}
