package Seminar05;

public class Exercise_5 {
    public static void main(String[] args) {
      Node root = new Node(1);
      Node n2 = new Node(2);
      Node n3 = new Node(3);
      Node n4 = new Node(4);
      Node n5 = new Node(5);
      Node n6 = new Node(6);
      Node n7 = new Node(7);
      Node n8 = new Node(8);
      Node n9 = new Node(9);
      Node n11 = new Node(11);
      Node n20 = new Node(20);
  
      root.first = n2;
      root.second = n3;
  
      n2.first = n4;

      n3.first = n5;
      n3.second = n6;
  
      n4.first = n7;
      n4.second = n8;
      n4.third = n9;
  
      n6.first = n11;
      n6.second = n20;
      
      preOrder(root, "");
    }
  
    static void preOrder(Node tree, String space) {
      if (tree != null)
        System.out.println(space + tree.value);
      else {
        System.out.println(space + "nil");
        return;
      }
      if (tree.first != null || tree.second != null || tree.third != null) {
        preOrder(tree.first, space + "  ");
        preOrder(tree.second, space + "  ");
        preOrder(tree.third, space + "  ");
      }
    }
  
  }
  
  // nil
  class Node {
    int value;
  
    public Node(int value) {
      this.value = value;
    }
  
    Node first;
    Node second;
    Node third;
  }