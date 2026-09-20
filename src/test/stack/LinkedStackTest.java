package stack;

/** Runs the Stack contract suite against LinkedStack. */
public class LinkedStackTest extends StackTest {

  @Override
  protected Stack<Integer> createStack() {
    return new LinkedStack<>();
  }
}
