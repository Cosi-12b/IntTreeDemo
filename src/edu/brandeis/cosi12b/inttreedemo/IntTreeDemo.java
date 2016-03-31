package edu.brandeis.cosi12b.inttreedemo;

public class IntTreeDemo {

  public static void main(String[] args) {
    example1();
    //example2();
    //example3();
    //example4();
    //example5();
  }
  
  private static void example1() {
    IntTreeNode r = new IntTreeNode(1);
    IntTree t = new IntTree(r);
    r.left = new IntTreeNode(2, new IntTreeNode(3), new IntTreeNode(4));
    r.right = new IntTreeNode(4, new IntTreeNode(5), new IntTreeNode(6));
    t.printSideways();
  }
  
  private static void example2() {
    IntTree t = new IntTree();
    t.add(1);
    t.add(2);
    t.add(3);
    t.add(4);
    t.add(5);
    t.printSideways();
  }

  private static void example3() {
    IntTree t = new IntTree();
    t.add(1);
    t.add(2);
    t.add(3);
    t.add(-1);
    t.add(5);
    System.out.println("Here's the tree, printed sideways: ");
    t.printSideways();
    System.out.println("And the minimum is " + t.getMin());
  }
  
  private static void example4() {
    IntTree t1 = new IntTree();
    t1.add(1);
    t1.add(2);
    t1.add(3);
    t1.add(4);
    t1.add(5);
    System.out.println("******** Adding 1,2,3,4,5 produces this tree: ");
    t1.printSideways();
    IntTree t2 = new IntTree();
    t2.add(1);
    t2.add(3);
    t2.add(2);
    t2.add(5);
    t2.add(4);
    System.out.println("******** Adding 1,3,2,5,4 produces this tree: ");
    t2.printSideways();
    IntTree t3 = new IntTree();
    t3.add(3);
    t3.add(1);
    t3.add(2);
    t3.add(5);
    t3.add(4);
    System.out.println("******** Adding 3,1,2,5,4 produces this tree: ");
    t3.printSideways();
    System.out.println("******** ");
  }
  
  private static void example5() {
    IntTree t3 = new IntTree();
    t3.add(3);
    t3.add(1);
    t3.add(2);
    t3.add(5);
    t3.add(4);
    System.out.println("******** Initial Tree: ");
    t3.printSideways();
    t3.remove(3);
    System.out.println("******** Removing 3 leaves this tree: ");
    t3.printSideways();
  }
}
