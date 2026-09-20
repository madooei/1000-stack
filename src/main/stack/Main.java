package stack;

/** A demo of the Stack ADT: a text editor's undo history. */
public class Main {

  public static void main(String[] args) {
    Stack<String> history = new ArrayStack<>();
    history.push("type 'Hello'");
    history.push("type ', world'");
    history.push("delete 'world'");
    System.out.println("most recent action: " + history.top()); // delete 'world'

    // pop() returns nothing, so undo is a top() followed by a pop().
    System.out.println("undo " + history.top()); // undo delete 'world'
    history.pop();
    System.out.println("undo " + history.top()); // undo type ', world'
    history.pop();
    System.out.println("most recent action: " + history.top()); // type 'Hello'

    // The same client code runs on the other implementation.
    Stack<String> history2 = new LinkedStack<>();
    history2.push("type 'A'");
    history2.push("type 'B'");
    System.out.println("undo " + history2.top()); // undo type 'B'
    history2.pop();
    System.out.println("undo " + history2.top()); // undo type 'A'
    history2.pop();
    System.out.println("history empty: " + history2.isEmpty()); // true
  }
}
