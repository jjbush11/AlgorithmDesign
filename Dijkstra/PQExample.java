// jdh CS3240A / CS5990A Fall 2023

import java.util.PriorityQueue;

public class PQExample {
  public static void main(String args[]) {
    PQtest();
  }

  public static void PQtest() {
    PriorityQueue<Thing> PQ;
    PQ = new PriorityQueue<Thing>(20);

    // each entry in the queue is a Thing;
    // they'll be put in the queue in priority order
    Thing t1 = new Thing("Audi", 5);
    PQ.add(t1);
    Thing t2 = new Thing("Civic", 10);
    PQ.add(t2);
    Thing t3 = new Thing("Outback", 2);
    PQ.add(t3);
    Thing t4 = new Thing("Tesla", 12);
    PQ.add(t4);

    while (PQ.size() > 0) {
      Thing t = PQ.poll();
      System.out.println("popped this thing: " + t);
    }

    System.out.println();

    // now same experiment, but this time also changing
    // the priorities of items in the queue ("updating keys")
    PQ.add(t1);
    PQ.add(t2);
    PQ.add(t3);
    PQ.add(t4);

    System.out.println("Now change the priority of " + t2 + " to 1");
    t2.updatePriority(1);

    // must explicitly call updatePQ()
    updatePQnode(PQ, t2);

    while (PQ.size() > 0) {
      Thing t = PQ.poll();
      System.out.println("popped this thing: " + t);
    }
  }

  //-----------------------------------------------------
  // this is a static because it's in Main

  public static void updatePQnode(PriorityQueue<Thing> pq, Thing thing) {
    pq.remove(thing);
    pq.add(thing);
  }
}
