package Seminar05;

import java.util.ArrayList;

public class Exercise_5_copy {
    public static void main(String[] args) {
      Node2 root = new Node2(1);
      Node2 n2 = new Node2(2);
      Node2 n3 = new Node2(3);
      Node2 n4 = new Node2(4);
      Node2 n5 = new Node2(5);
      Node2 n6 = new Node2(6);
      Node2 n7 = new Node2(7);
      Node2 n8 = new Node2(8);
      Node2 n9 = new Node2(9);
      Node2 n11 = new Node2(11);
      Node2 n20 = new Node2(20);
  
      root.successor.add(n2);
      root.successor.add(n3);
  
      n2.successor.add(n4);

      n3.successor.add(n5);
      n3.successor.add(n6);
  
      n4.successor.add(n7);
      n4.successor.add(n8);
      n4.successor.add(n9);
  
      n6.successor.add(n11);
      n6.successor.add(n20);
      
      preOrder2(root, "");
    }
  
    static void preOrder2(Node2 tree, String space) {
      if (tree != null)
        System.out.println(space + tree.value);
      else {
        System.out.println(space + "nil");
        return;
      }
      for (int i = 0; i < tree.successor.size(); i++) {
        preOrder2(tree.successor.get(i), space + "  ");
      }
      
    }
  
  }
  
  // nil
  class Node2 {
    int value;
  
    public Node2(int value) {
      this.value = value;
    }
  
    ArrayList <Node2> successor = new ArrayList<>();
  }