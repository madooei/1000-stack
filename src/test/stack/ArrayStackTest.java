package stack;

/** Runs the Stack contract suite against ArrayStack. */
public class ArrayStackTest extends StackTest {

  @Override
  protected Stack<Integer> createStack() {
    return new ArrayStack<>();
  }
}
