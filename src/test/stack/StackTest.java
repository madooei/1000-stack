package stack;

import java.util.NoSuchElementException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

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
  public void topOnEmptyStackThrows() {
    try {
      stack.top();
      fail("expected NoSuchElementException when calling top on an empty stack");
    } catch (NoSuchElementException e) {
      return;
    }
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
  public void pushMakesStackNonEmpty() {
    stack.push(10);
    assertFalse(stack.isEmpty());
  }

  @Test
  public void topReturnsPushedItem() {
    stack.push(10);
    assertEquals(10, stack.top());
  }

  @Test
  public void topDoesNotRemoveTheItem() {
    stack.push(10);
    stack.top();
    assertFalse(stack.isEmpty());
  }

  @Test
  public void popOnlyItemLeavesStackEmpty() {
    stack.push(10);
    stack.pop();
    assertTrue(stack.isEmpty());
  }

  @Test
  public void topAfterPoppingOnlyItemThrows() {
    stack.push(10);
    stack.pop();
    try {
      stack.top();
      fail("expected NoSuchElementException after popping the only item");
    } catch (NoSuchElementException e) {
      return;
    }
  }

  @Test
  public void topReturnsMostRecentlyPushedItem() {
    stack.push(10);
    stack.push(20);
    stack.push(30);
    assertEquals(30, stack.top());
  }

  @Test
  public void popRevealsThePreviousItem() {
    stack.push(10);
    stack.push(20);
    stack.pop();
    assertEquals(10, stack.top());
  }

  @Test
  public void twoPopsRevealTheFirstItem() {
    stack.push(4);
    stack.push(9);
    stack.push(6);
    stack.pop();
    stack.pop();
    assertEquals(4, stack.top());
  }

  @Test
  public void pushAfterPopBecomesTheTop() {
    stack.push(4);
    stack.push(9);
    stack.pop();
    stack.push(2);
    assertEquals(2, stack.top());
  }

  @Test
  public void poppingEveryItemLeavesStackEmpty() {
    stack.push(10);
    stack.push(20);
    stack.push(30);
    stack.pop();
    stack.pop();
    stack.pop();
    assertTrue(stack.isEmpty());
  }

  @Test
  public void pushingTheSameItemTwiceKeepsBothCopies() {
    stack.push(7);
    stack.push(7);
    stack.pop();
    assertEquals(7, stack.top());
  }

  @Test
  public void manyPushesKeepTheMostRecentOnTop() {
    for (int i = 1; i <= 12; i++) {
      stack.push(i);
    }
    assertEquals(12, stack.top());
  }

  @Test
  public void manyPushesKeepTheFirstItemAtTheBottom() {
    for (int i = 1; i <= 12; i++) {
      stack.push(i);
    }
    for (int i = 1; i <= 11; i++) {
      stack.pop();
    }
    assertEquals(1, stack.top());
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
}
