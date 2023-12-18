// jdh CS3240A / CS5990A Fall 2023
import java.util.List;

public class Main {
  public static void main(String args[]) {
    testOne();
    testTwo();
  }

  public static void testOne() {
    Node nA = new Node("A");
    Node nB = new Node("B");
    Node nC = new Node("C");
    Node nD = new Node("D");
    Node nE = new Node("E");
    Node nF = new Node("F");

    Graph G = new Graph();
    G.addNode(nA);
    G.addNode(nB);
    G.addNode(nC);
    G.addNode(nD);
    G.addNode(nE);
    G.addNode(nF);

    G.addEdge(nA, nC);
    G.addEdge(nA, nB);
    G.addEdge(nB, nD);
    G.addEdge(nC, nD);
    G.addEdge(nD, nF);
    G.addEdge(nD, nE);
    G.addEdge(nE, nF);

    List<Node> list = G.DFS(nA);
    System.out.println(list);
  } // testOne()

  public static void testTwo() {
    Node n1 = new Node("1");
    Node n2 = new Node("2");
    Node n3 = new Node("3");
    Node n4 = new Node("4");
    Node n5 = new Node("5");
    Node n6 = new Node("6");
    Node n7 = new Node("7");
    Node n8 = new Node("8");

    Graph G = new Graph();
    G.addNode(n8);
    G.addNode(n7);
    G.addNode(n6);
    G.addNode(n5);
    G.addNode(n4);
    G.addNode(n3);
    G.addNode(n2);
    G.addNode(n1);

    G.addEdge(n1, n3);
    G.addEdge(n1, n2);
    G.addEdge(n2, n4);
    G.addEdge(n3, n7);
    G.addEdge(n3, n5);
    G.addEdge(n4, n5);
    G.addEdge(n5, n8);
    G.addEdge(n5, n6);
    G.addEdge(n7, n8);

    List<Node> list = G.DFS(n1);
    System.out.println(list);
  } // testTwo()

}
