// CS3240A/CS5990A Fall 2023

import java.util.List;
import java.util.ArrayList;

public class Node {
  List<Node> adjlist;
  String name;
  Node parent;

  public Node(String name) {
    this.name = name;
    this.adjlist = new ArrayList<Node>();
    this.parent = null;
  }

  public void addEdge(Node otherNode) {
    // make sure that this edge doesn't already exist
    for (Node n2: this.adjlist) {
      if (n2 == otherNode) {
        System.out.println("ERROR: there is already an edge from " + this.name + " to " + otherNode.name);
        return;
      }
    }

    // add edge from this to edge.tail
    this.adjlist.add(otherNode);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;

    if ( ! (o instanceof Node) )
      return false;

     Node otherNode = (Node) o;
     if (otherNode.name == this.name)
       return true;

    return false;
  }

  @Override
  public String toString() {
    String s = this.name;
    return s;
  }
}
