// jdh CS3240A / CS 5990A Fall 2023
// Created by James Bush, worked with Anthony Mazzola

import java.util.*;

public class Graph {
  ArrayList<Node> nodes;

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

  public void addEdge(Node n1, Node n2, int weight) {
    // make sure edge does not already exist
    int idx1 = this.nodes.indexOf(n1);
    if (idx1 >= 0) {
      for (Link link: this.nodes.get(idx1).adjlist) {
        if (link.n2 == n2) {
          System.out.println("ERROR: there is already an edge from " + n1.name + " to " + n2.name);
          return;
        }
      }
      this.nodes.get(idx1).addEdge(n2, weight);
    } else {
      System.out.println("ERROR: node " + n1.name + " not found in graph");
    }

    int idx2 = this.nodes.indexOf(n2);
    if (idx2 >= 0) {
      this.nodes.get(idx2).addEdge(n1, weight);
    } else {
      System.out.println("ERROR: node " + n2.name + " not found in graph");
    }
  } // addEdge()

  public void print() {
    for (Node n1: this.nodes) {
      System.out.print(n1 + ":");
      for (Link link: n1.adjlist) {
        System.out.print(" " + link.n2.name + " (d=" + link.weight + ")");
      }
      System.out.print("|");
    }
    System.out.println();
  } // print()

  //----------------------------------------------------
  // change the key (priority) on a node: by deleting it
  // and reinserting it

  public static void updatePQnode(PriorityQueue<Node> pqueue, Node n) {
    pqueue.remove(n);
    pqueue.add(n);
  }

  //----------------------------------------------------

  public void shortestPath(Node s) {

    //initialize set empty
    ArrayList<Node> S = new ArrayList<>();
    S.add(s);
    s.distance = 0;

    int d=0, minDist;
    Node keepNode = new Node("temp");
    while (S.size() != nodes.size()) {
      minDist = Integer.MAX_VALUE;
      for (Node v : S) {
        for (Link w : v.adjlist) {
          if (!S.contains(w.n2)) {
            d = v.distance + w.weight;
            if (d < minDist) {
              minDist = d;
              keepNode = w.n2;
            }
          }
        }
      }
      keepNode.distance = minDist;
      S.add(keepNode);
    }
  } // shortestPath()

  //----------------------------------------------------

  public void shortestPathPQ(Node s) {
    // set distance for each node large value
    for (Node u : nodes){
      u.distance = Integer.MAX_VALUE;
    }

    // distance of s set to 0
    s.distance = 0;

    // Initialie pq and add all nodes
    PriorityQueue<Node> pq = new PriorityQueue<>(nodes);

    //initialize set empty
    ArrayList<Node> S = new ArrayList<>();
    S.add(s);

    while (S.size() != nodes.size()){
      Node v = pq.poll();
      for (Link w : v.adjlist){
        int d = v.distance + w.weight;
        if(d < w.n2.distance){
          w.n2.distance = d;
          updatePQnode(pq, w.n2);
        }
      }

      S.add(v);

    }

  } // shortestPathPQ()
} // class Graph
