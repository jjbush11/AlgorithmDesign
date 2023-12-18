// jdh CS3240A / CS5990A Fall 2023

public class Main {
  public static void main(String args[]) {
    testOne();
    testTwo();
  }

  // graph on p. 139 (but as an undirected graph)
  public static void testOne() {
    Node n1 = new Node("s");
    Node n2 = new Node("u");
    Node n3 = new Node("v");
    Node n4 = new Node("y");
    Node n5 = new Node("x");
    Node n6 = new Node("z");

    Graph G = new Graph();
    G.addNode(n6);
    G.addNode(n5);
    G.addNode(n4);
    G.addNode(n3);
    G.addNode(n2);
    G.addNode(n1);

    // add the edges from highest # node to lowest # node
    G.addEdge(n5, n6, 2);
    G.addEdge(n5, n4, 1);
    G.addEdge(n3, n6, 3);
    G.addEdge(n3, n5, 2);
    G.addEdge(n2, n5, 1);
    G.addEdge(n2, n4, 3);
    G.addEdge(n1, n5, 4);
    G.addEdge(n1, n3, 2);
    G.addEdge(n1, n2, 1);

//    G.shortestPath(n1);
    G.shortestPathPQ(n1);
    for (Node n: G.nodes) {
      System.out.println("distance from node " + n1 + " to " + n + " = " + n.distance);
    }
  }

  // from my Ch. 4 Sec. 4 lecture notes
  public static void testTwo() {
    Node nA = new Node("A");
    Node nB = new Node("B");
    Node nC = new Node("C");
    Node nD = new Node("D");
    Node nE = new Node("E");
    Node nF = new Node("F");
    Node nG = new Node("G");
    Node nH = new Node("H");
    Node nI = new Node("I");

    Graph G = new Graph();
    G.addNode(nA);
    G.addNode(nB);
    G.addNode(nC);
    G.addNode(nD);
    G.addNode(nE);
    G.addNode(nF);
    G.addNode(nG);
    G.addNode(nH);
    G.addNode(nI);

    G.addEdge(nA, nB, 22);
    G.addEdge(nA, nC, 23);
    G.addEdge(nA, nD, 52);
    G.addEdge(nA, nE, 64);
    G.addEdge(nB, nE, 41);
    G.addEdge(nE, nG, 36);
    G.addEdge(nE, nI, 130);
    G.addEdge(nC, nE, 39);
    G.addEdge(nC, nG, 64);
    G.addEdge(nC, nF, 42);
    G.addEdge(nG, nI, 74);
    G.addEdge(nD, nF, 37);
    G.addEdge(nD, nH, 126);
    G.addEdge(nF, nG, 21);
    G.addEdge(nF, nH, 43);
    G.addEdge(nF, nI, 132);
    G.addEdge(nH, nI, 52);

//  G.print();

//    G.shortestPath(nA);
    G.shortestPathPQ(nA);
    for (Node n: G.nodes) {
      System.out.println("distance from node " + nA + " to " + n + " = " + n.distance);
    }
  } // testTwo()
}
