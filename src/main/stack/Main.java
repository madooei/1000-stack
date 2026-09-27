package stack;

/** A demo of the Stack ADT: a text editor's undo history. */
public final class Main {

  private Main() {
    // This class should not be instantiated!
  }

  public static void main(String[] args) {
    System.out.println("ArrayStack:");
    undoSession(new ArrayStack<>());
    System.out.println("LinkedStack:");
    undoSession(new LinkedStack<>());
  }

  // Records the notes' three actions, then undoes all of them.
  private static void undoSession(Stack<String> history) {
    history.push("type \"cat\"");
    history.push("bold");
    history.push("delete \"t\"");
    while (!history.isEmpty()) {
      // pop() returns nothing, so undo is a top() followed by a pop().
      System.out.println("  undo " + history.top());
      history.pop();
    }
  }
}
