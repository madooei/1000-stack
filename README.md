# Stack

The `Stack` ADT with two implementations, one backed by an array and one backed by a linked list. A JUnit suite checks both implementations against the same contract.

## Prerequisites

- JDK 17+
- The JUnit jar is already vendored in `lib/`; there is nothing to download.

## Repository layout

```plaintext
code/
  README.md
  .gitignore
  lib/
    junit-platform-console-standalone-6.1.0.jar
  src/
    main/
      stack/
        Stack.java              # the Stack ADT contract
        ArrayStack.java         # array-backed Stack
        LinkedStack.java        # node-backed Stack
        Main.java               # demo entry point (the undo example)
    test/
      stack/
        StackTest.java          # abstract: the Stack contract suite
        ArrayStackTest.java     # runs the suite against ArrayStack
        LinkedStackTest.java    # runs the suite against LinkedStack
  scripts/
    run.sh                      # compile and run the Stack demo (stack.Main)
    test.sh                     # compile and run every JUnit test
```

## How to compile and run

- `scripts/test.sh` — compiles everything and runs the full JUnit suite.
- `scripts/test.sh stack.ArrayStackTest` — compiles everything and runs only that test class. Use this while you are working on one class and the other is still empty.
- `scripts/run.sh` — compiles everything and runs the `Main` demo.

## What's here

- `stack.Stack<T>` — the Stack contract: `push`, `pop`, `top`, and `isEmpty`.
- `stack.ArrayStack<T>` — the array-backed implementation, with the top at the end of the array.
- `stack.LinkedStack<T>` — the node-backed implementation, with the top at the head of the list.
- `stack.Main` — a runnable demo of the undo example, run on both implementations.
- `stack.StackTest` — the abstract contract suite.
- `stack.ArrayStackTest` — runs the contract suite against `ArrayStack`.
- `stack.LinkedStackTest` — runs the contract suite against `LinkedStack`.
