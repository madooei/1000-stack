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
      demo/                     # one demo per implementation
        ArrayStackDemo.java
        LinkedStackDemo.java
    test/
      stack/
        StackTest.java          # abstract: the Stack contract suite
        ArrayStackTest.java     # runs the suite against ArrayStack
        LinkedStackTest.java    # runs the suite against LinkedStack
  scripts/
    test.sh                     # compile and run every JUnit test
    run.sh                      # compile and run one demo
```

## How to compile and run

- `scripts/test.sh` — compiles everything and runs the full JUnit suite.
- `scripts/test.sh stack.ArrayStackTest` — compiles everything and runs only that test class. Use this while you are working on one class and the other is still empty.
- `scripts/run.sh demo.ArrayStackDemo` — compiles everything and runs that one demo. Every class you implement has its own demo, `<Class>Demo`.

## Contents

- `stack.Stack<T>` — the Stack contract: `push`, `pop`, `top`, and `isEmpty`.
- `stack.ArrayStack<T>` — the array-backed implementation, with the top at the end of the array.
- `stack.LinkedStack<T>` — the node-backed implementation, with the top at the head of the list.
- `stack.StackTest` — the abstract contract suite.
- `stack.ArrayStackTest` — runs the contract suite against `ArrayStack`.
- `stack.LinkedStackTest` — runs the contract suite against `LinkedStack`.
- `demo.ArrayStackDemo` and `demo.LinkedStackDemo` — one demo per implementation, each on the undo example from the notes.
