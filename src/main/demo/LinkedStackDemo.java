package demo;

import stack.LinkedStack;

/** A demo of LinkedStack on the undo example from the notes. */
public final class LinkedStackDemo {

  private LinkedStackDemo() {
    // This class should not be instantiated!
  }

  public static void main(String[] args) {
    LinkedStack<String> history = new LinkedStack<>();

    // Record the three actions in the order they happen.
    history.push("type \"cat\"");
    history.push("bold");
    history.push("delete \"t\"");
    System.out.println("top after three actions: " + history.top());

    // Undo them all. Expect the most recent action first:
    // delete "t", then bold, then type "cat".
    while (!history.isEmpty()) {
      // pop() returns nothing, so undo is a top() followed by a pop().
      System.out.println("undo " + history.top());
      history.pop();
    }
    System.out.println("empty: " + history.isEmpty());
  }
}
