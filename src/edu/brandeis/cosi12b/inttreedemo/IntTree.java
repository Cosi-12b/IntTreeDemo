package edu.brandeis.cosi12b.inttreedemo;

import java.util.NoSuchElementException;

public class IntTree {
  private IntTreeNode overallRoot; // null for an empty tree

  public IntTree(IntTreeNode root) {
    overallRoot = root;
  }

  public IntTree() {
    this(null);
  }

  public IntTreeNode getRoot() {
    return overallRoot;
  }

  // An IntTree object represents an entire binary tree of ints.
  public void print() {
    print(overallRoot);
    System.out.println(); // end the line of output
  }

  // Overloaded method to recursively print the tree
  private void print(IntTreeNode root) {
    // (base case is implicitly to do nothing on null)
    if (root != null) {
      // recursive case: print left, center, right
      print(root.left);
      System.out.print(root.data + " ");
      print(root.right);
    }
  }

  // Prints the tree in a sideways indented format.
  public void printSideways() {
    printSideways(overallRoot, "");
  }

  // Overloaded method to recursively print the tree
  private void printSideways(IntTreeNode root, String indent) {
    if (root != null) {
      printSideways(root.right, indent + "    ");
      System.out.println(indent + root.data);
      printSideways(root.left, indent + "    ");
    }
  }

  // Adds the given value to this BST in sorted order.
  public void add(int value) {
    overallRoot = add(overallRoot, value);
  }

  private IntTreeNode add(IntTreeNode root, int value) {
    if (root == null) {
      root = new IntTreeNode(value);
    } else if (root.data > value) {
      root.left = add(root.left, value);
    } else if (root.data < value) {
      root.right = add(root.right, value);
    } // else a duplicate

    return root;
  }

  // Removes the given value from this BST, if it exists.
  public void remove(int value) {
    overallRoot = remove(overallRoot, value);
  }

  private IntTreeNode remove(IntTreeNode root, int value) {
    if (root == null) {
      return null;
    } else if (root.data > value) {
      root.left = remove(root.left, value);
    } else if (root.data < value) {
      root.right = remove(root.right, value);
    } else { // root.data == value; remove this node
      if (root.right == null) {
        return root.left; // no R child; replace w/ L
      } else if (root.left == null) {
        return root.right; // no L child; replace w/ R
      } else {
        // both children; replace w/ min from R
        root.data = getMin(root.right);
        root.right = remove(root.right, root.data);
      }
    }
    return root;
  }

  // Returns the minimum value from this BST.
  // Throws a NoSuchElementException if the tree is empty.
  public int getMin() {
    if (overallRoot == null) {
      throw new NoSuchElementException();
    }
    return getMin(overallRoot);
  }

  private int getMin(IntTreeNode root) {
    if (root.left == null) {
      return root.data;
    } else {
      return getMin(root.left);
    }
  }

}
