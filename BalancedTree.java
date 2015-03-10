/* Jamey Dogom
   Comp. 282
   Project 2 */  

public interface BalancedTree<E extends Comparable<E>> {
public void insert(E item);
public E find(E item);
public void delete(E item);
public void printInOrderTraversal();
}