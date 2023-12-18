// jdh CS3240A / CS 5990A Fall 2023
// Worked with Anthony Mazzola

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Map;
import java.util.HashMap;

public class Graph {
  List<Node> nodes;

  public Graph() {
    this.nodes = new ArrayList<Node>();
  }

  public void addNode(Node newNode) {
    for (Node n: this.nodes) {
      if (n == newNode) {
        System.out.println("ERROR: graph already has a node " + n.name);
        assert false;
      }
    }
    nodes.add(newNode);
  }

  public void addEdge(Node n1, Node n2) {
    // make sure edge does not already exist
    int idx1 = this.nodes.indexOf(n1);
    if (idx1 >= 0) {
      for (Node adjnode: this.nodes.get(idx1).adjlist) {
        if (adjnode == n2) {
          System.out.println("ERROR: there is already an edge from " + n1.name + " to " + n2.name);
          return;
        }
      }
      this.nodes.get(idx1).addEdge(n2);
    } else {
      System.out.println("ERROR: node " + n1.name + " not found in graph");
    }

    int idx2 = this.nodes.indexOf(n2);
    if (idx2 >= 0) {
      this.nodes.get(idx2).addEdge(n1);
    } else {
      System.out.println("ERROR: node " + n2.name + " not found in graph");
    }
  } // addEdge()

  //----------------------------------------------------------------

  public void print() {
    for (Node n1: this.nodes) {
      System.out.print(n1 + ":");
      for (Node n2: n1.adjlist) {
        System.out.print(" " + n2);
      }
      System.out.print("|");
    }
    System.out.println();
  } // print()

  //----------------------------------------------------------------

  public List<Node> DFS(Node s) {
    Stack<Node> S = new Stack<Node>();
    S.push(s);

    List<Node> smallestCycle = new ArrayList<>();
    List<Node> currCycle = new ArrayList<Node>();

    Map<Node, Boolean> explored = new HashMap<Node, Boolean>();

    //for loop
    for (Node u : nodes){
      explored.put(u, false);
      smallestCycle.add(u);
    }

    while (!S.isEmpty()){
      Node u = S.pop();
      if (!explored.get(u)) {
        explored.put(u, true);
        for (Node v : u.adjlist){
          if (!explored.get(v)){
            if (v.parent != null && v.parent != u){
              currCycle.add(v);
              //get to u
              Node newU = u;
              while (newU != v.parent){
                currCycle.add(newU);
                newU = newU.parent;
              }
              currCycle.add(newU);
              if (currCycle.size() < smallestCycle.size()){
                smallestCycle.clear();
                for (Node j : currCycle){
                  smallestCycle.add(j);
                }
              }
              currCycle.clear();
            }
            v.parent = u; //set the parent of v to u
            S.push(v); //add v to the stack S
          }
        }
      }
    }
    return smallestCycle;
  } // DFS()

} // class Graph
