package stack;

import java.util.NoSuchElementException;

/**
 * A node-backed implementation of the Stack ADT.
 *
 * @param <T> the type of elements in this stack.
 */
public class LinkedStack<T> implements Stack<T> {

  private Node<T> head;  // the top of the stack, or null when empty

  private static class Node<T> {
    T value;
    Node<T> next;

    Node(T value) {
      this.value = value;
    }
  }

  public LinkedStack() {
    head = null;
  }

  @Override
  public void push(T item) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  @Override
  public void pop() {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  @Override
  public T top() {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  @Override
  public boolean isEmpty() {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }
}
