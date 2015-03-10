/* Jamey Dogom
   Comp. 282
   Project 2 */  

import java.util.*;

public class TwoThreeTree <E extends Comparable<E>>implements Comparable<E>{
	
   private  class Node{
      int val = 0;
      E item1;
      E item2;
      Node left;
      Node middle;
      Node right;
   }

   Node root = null;
   E np = null;
   Node nc = null;


   public E find(E item){
      return find(root, item);
   }

   private E find(Node node, E item){
      if(node == null){
         return null;
      }
      else if(node.val == 1){
         if(item.compareTo( node.item1) == 0){
            return   node.item1;
         }
         else if(item.compareTo((E) node.item1) < 0){
            return find(node.left, item);
         }
         else{
            return find(node.right, item);
         }
      }
      else{
         if(item.compareTo((E) node.item1) == 0){
            return (E) node.item1;
         }
         else if(item.compareTo((E) node.item2) == 0){
            return (E) node.item2;
         }
         else if(item.compareTo((E) node.item1) < 0){
            return find(node.left, item);
         }
         else if(item.compareTo((E) node.item2) < 0){
            return find(node.middle, item);
         }
         else{
            return find(node.right, item);
         }
      }
   }


   public  void insert(E item){
      if(root == null){
         root = new Node();
         root.item1 = item;
         root.val = 1;
      	
      }
      else{
         insert(root, item);
         if(np != null){
            Node oldRoot = root;
            root = new Node();
            root.item1 = np;
            root.left = oldRoot;
            root.right = nc;
            root.val = 1;
            np = null;
         }
      	
      }
   }


   private boolean insert(Node node, E item){
      if(item.compareTo(node.item1) == 0 || (node.val == 2 && item.compareTo(node.item2) == 0)){
         return false;
      }
      if(node.left == null){
         if(node.val == 1){
            if(item.compareTo(node.item1) < 0){
               node.item2 = node.item1;
               node.item1 = item;
            }
            else{
               node.item2 = item;
            }
            node.val = 2;
            return true;
         }
         else{
            seperate(node, item, null);
            return true;
         }
      }
      else{
         boolean retval = false;
         if(item.compareTo(node.item1) < 0){
            retval = insert(node.left, item);
         }
         else if(node.val == 1){
            retval = insert(node.right, item);
         }
         else if(item.compareTo(node.item2) < 0){
            retval = insert(node.middle, item);
         }
         else if(item.compareTo(node.item2) > 0){
            retval = insert(node.right, item);
         }
         if(np != null){
            if(node.val == 2){
               seperate(node, np, nc);
               return retval;
            }
            else{
               if(np.compareTo(node.item1) < 0){
                  node.item2 = node.item1;
                  node.middle = nc;
                  node.item1 = np;
               }
               else{
                  node.item2 = np;
                  node.middle = node.right;
                  node.right = nc;
               }
               node.val = 2;
               np = null;
               nc = null;
            }
         }
         return retval;
      }
   }

	
   private void seperate(Node node, E item, Node child){
      Comparable[] elements = new Comparable[3];
   	//Node newChildren[] = new Node[4];
      Node c1,c2,c3,c4;
      if(item.compareTo(node.item2) > 0){
         elements[0] = node.item1;
         elements[1] = node.item2;
         elements[2] = item;
         c1 = node.left;
         c2 = node.middle;
         c3= node.right;
         c4 = child;
      }
      else if(item.compareTo(node.item1) > 0){
         elements[0] = node.item1;
         elements[1] = item;
         elements[2] = node.item2;
         c1= node.left;
         c2= node.middle;
         c3 = child;
         c4 = node.right;
      }
      else{
         elements[0] = item;
         elements[1] = node.item1;
         elements[2] = node.item2;
         c1 = node.left;
         c2 = child;
         c3 = node.middle;
         c4 = node.right;
      }
      node.val = 1;
      node.item1 = (E) elements[0];
      node.left = c1;
      node.right = c2;
      np = (E) elements[1];
      nc = new Node();
      nc.val = 1;
      nc.item1 = (E) elements[2];
      nc.left = c3;
      nc.right = c4;
   }


   public void delete(E item) {
   	
   	
   }

	
   public void printInOrderTraversal() {
      Node item = root;
      System.out.println(item);
   }
   
   public int compareTo(E arg0) {
      return 0;
   }
}