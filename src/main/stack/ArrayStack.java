package stack;

import java.util.NoSuchElementException;

/**
 * An array-backed implementation of the Stack ADT.
 *
 * @param <T> the type of elements in this stack.
 */
public class ArrayStack<T> implements Stack<T> {

  private T[] arr;   // the top is at index size - 1
  private int size;

  // arr only ever holds T, so the cast is safe.
  @SuppressWarnings("unchecked")
  public ArrayStack() {
    arr = (T[]) new Object[10];
    size = 0;
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

  // bigger only ever holds T, so the cast is safe.
  @SuppressWarnings("unchecked")
  private void grow() {
    T[] bigger = (T[]) new Object[arr.length * 2];
    for (int i = 0; i < size; i++) {
      bigger[i] = arr[i];
    }
    arr = bigger;
  }
}
