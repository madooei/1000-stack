# Stack

The `Stack` ADT with its array and linked implementations, the chapter's two worked problems (valid parentheses and Reverse Polish Notation), and a JUnit contract-test suite.

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
        Stack.java               # the Stack ADT contract
        ArrayStack.java          # array-backed Stack
        LinkedStack.java         # node-backed Stack
        ValidParentheses.java    # worked problem: balanced brackets
        EvaluateRPN.java         # worked problem: postfix evaluation
        Main.java                # demo entry point (the undo example)
    test/
      stack/
        StackTest.java                       # abstract: the Stack contract suite
        ArrayStackTest.java                  # runs the suite against ArrayStack
        LinkedStackTest.java                 # runs the suite against LinkedStack
        ValidParenthesesTest.java            # abstract: the valid-parentheses scenarios
        ValidParenthesesBruteForceTest.java  # runs them against the brute-force solution
        ValidParenthesesStackTest.java       # runs them against the stack solution
        EvaluateRPNTest.java                 # abstract: the RPN scenarios
        EvaluateRPNBruteForceTest.java       # runs them against the brute-force solution
        EvaluateRPNStackTest.java            # runs them against the stack solution
  scripts/
    run.sh                       # compile and run the Stack demo (stack.Main)
    test.sh                      # compile and run every JUnit test
```

## How to compile and run

- `scripts/test.sh` — compiles everything and runs the full JUnit suite.
- `scripts/test.sh stack.ValidParenthesesBruteForceTest` — compiles everything and runs only that test class. Use this while you are working on one class or one solution and the others are still empty. The class names are listed in the layout above.
- `scripts/run.sh` — compiles everything and runs the `Main` demo.

## What's here

- `stack.Stack<T>` — the Stack contract: `push`, `pop`, `top`, and `isEmpty`.
- `stack.ArrayStack<T>` and `stack.LinkedStack<T>` — the array-backed and node-backed implementations the suite runs against.
- `stack.ValidParentheses` and `stack.EvaluateRPN` — the chapter's two worked problems. Each has a brute-force solution and a stack solution. The stack solutions use the chapter's own `Stack` implementations, not `java.util` collections.
- `stack.ValidParenthesesTest` and `stack.EvaluateRPNTest` — the abstract scenario suites for the two problems. Each has one subclass per solution, so you can test one solution alone.
- `stack.Main` — a runnable demo of the undo example.
- `stack.StackTest` — the abstract contract suite. `ArrayStackTest` and `LinkedStackTest` each run it against one implementation.
