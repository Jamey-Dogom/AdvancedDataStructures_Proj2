/* Jamey Dogom
   Comp. 282
   Project 2 */  

import java.util.Iterator;


public class SplayTree <E extends Comparable<E>>implements Comparable<E>{

	private Node root;
	private final Node node;

	public SplayTree() {
		root = null;
		node = new Node(null);
	}
	public void insert(E item) {
		if (root == null) {
			root = new Node(item);
		
		}
		splay(item);

		final int c = item.compareTo(root.item);
		if (c == 0) {
			
		}

		Node n = new Node(item);
		if (c < 0) {
			n.left = root.left;
			n.right = root;
			root.left = null;
		} else {
			n.right = root.right;
			n.left = root;
			root.right = null;
		}
		root = n;
	
	}

	private void splay(E item) {
		Node l, r, t, y;
		l = r = node;
		t = root;
		node.left = node.right = null;
		while(true) {
			final int compare = item.compareTo(t.item);
			if (compare < 0) {
				if (t.left == null) break;
				if (item.compareTo(t.left.item) < 0) {
					y = t.left;                            /* rotate right */
					t.left = y.right;
					y.right = t;
					t = y;
					if (t.left == null) break;
				}
				r.left = t;                                 /* link right */
				r = t;
				t = t.left;
			} else if (compare > 0) {
				if (t.right == null) break;
				if (item.compareTo(t.right.item) > 0) {
					y = t.right;                            /* rotate left */
					t.right = y.left;
					y.left = t;
					t = y;
					if (t.right == null) break;
				}
				l.right = t;                                /* link left */
				l = t;
				t = t.right;
			} else {
				break;
			}
		}
		l.right = t.left;                                   /* group together */
		r.left = t.right;
		t.left = node.right;
		t.right = node.left;
		root = t;
		
	}
	public E find(E item) {
		if (root == null)
			return null;
		
		splay(item);
		
		if(root.item.compareTo(item) != 0) 
			return null;
		
		return root.item;
		
		
	}

	public void delete(E item) {
		splay(item);

		// Now delete the root
		if (root.left == null) {
			root = root.right;
		} else {
			Node x = root.right;
			root = root.left;
			splay(item);
			root.right = x;
		}		
		
	}

	public void printInOrderTraversal() 
	{	Node val = node;
		
			System.out.println(val);
		
	}
	private class Node {

		public final E item;          // The data in the node
		public Node left;         // Left child
		public Node right;        // Right child

		public Node(E item1) {
			item = item1;
			left = null;
			right = null;
		}
	}
	public int compareTo(E arg0) {
		return 0;
	}
	
}
