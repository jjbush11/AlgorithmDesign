// jdh CS3240A / CS5990A Fall 2023

public class Thing implements Comparable {
  private String name;
  private int priority;

  public Thing(String name, int priority) {
    this.name = name;
    this.priority = priority;
  }

  public void updatePriority(int newPriority) {
    this.priority = newPriority;
  }

  public int compareTo(Object o) {
    Thing otherThing = (Thing) o;
    if (this.priority < otherThing.priority)
      return -1;
    else if (this.priority > otherThing.priority)
      return 1;
    else
      return 0;
  }

  @Override
  public String toString() {
    String s = this.name + " (" + this.priority + ")";
    return s;
  }

}

