package stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.NoSuchElementException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The contract test suite for the Stack ADT, written against the Stack interface
 * alone. A concrete subclass supplies createStack() to pick the implementation.
 */
public abstract class StackTest {

  private Stack<Integer> stack;

  protected abstract Stack<Integer> createStack();

  @BeforeEach
  public void setup() {
    stack = createStack();
  }

  @Test
  public void newStackIsEmpty() {
    assertTrue(stack.isEmpty());
  }

  @Test
  public void isEmptyFalseAfterPush() {
    stack.push(1);
    assertFalse(stack.isEmpty());
  }

  @Test
  public void topReturnsLastPushedWithoutRemovingIt() {
    stack.push(10);
    stack.push(20);
    assertEquals(20, stack.top());
    assertEquals(20, stack.top());   // still there: top does not remove
    assertFalse(stack.isEmpty());
  }

  @Test
  public void popRemovesInLifoOrder() {
    stack.push(10);
    stack.push(20);
    stack.push(30);
    assertEquals(30, stack.top());
    stack.pop();
    assertEquals(20, stack.top());
    stack.pop();
    assertEquals(10, stack.top());
    stack.pop();
    assertTrue(stack.isEmpty());
  }

  @Test
  public void popOnEmptyStackThrows() {
    try {
      stack.pop();
      fail("expected NoSuchElementException when popping an empty stack");
    } catch (NoSuchElementException e) {
      return;
    }
  }

  @Test
  public void topOnEmptyStackThrows() {
    try {
      stack.top();
      fail("expected NoSuchElementException when calling top on an empty stack");
    } catch (NoSuchElementException e) {
      return;
    }
  }

  @Test
  public void pushNullThrows() {
    try {
      stack.push(null);
      fail("expected IllegalArgumentException when pushing null");
    } catch (IllegalArgumentException e) {
      return;
    }
  }

  @Test
  public void tracedScenarioFromTheNotes() {
    stack.push(4);
    stack.push(9);
    stack.push(6);
    assertEquals(6, stack.top());
    stack.pop();
    stack.pop();
    assertEquals(4, stack.top());
    stack.push(2);
    assertEquals(2, stack.top());
  }

  @Test
  public void manyPushesThenPopAllInLifoOrder() {
    for (int i = 1; i <= 12; i++) {
      stack.push(i);
    }
    for (int i = 12; i >= 1; i--) {
      assertEquals(i, stack.top());
      stack.pop();
    }
    assertTrue(stack.isEmpty());
  }

  @Test
  public void pushAfterPopReplacesTheTop() {
    stack.push(10);
    stack.pop();
    stack.push(20);
    assertEquals(20, stack.top());
    assertFalse(stack.isEmpty());
  }
}
