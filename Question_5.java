// Interface for Stack ADT
interface Stack {
    void push(int item) throws StackOverflowException; // Push an item onto the stack
    int pop() throws StackUnderflowException;          // Pop an item from the stack
    int peek() throws StackUnderflowException;         // Peek at the top item of the stack
    boolean isEmpty();                                 // Check if the stack is empty
    boolean isFull();                                  // Check if the stack is full
}

// Custom exception for stack overflow
class StackOverflowException extends Exception {
    public StackOverflowException(String message) {
        super(message);
    }
}

// Custom exception for stack underflow
class StackUnderflowException extends Exception {
    public StackUnderflowException(String message) {
        super(message);
    }
}

// Array-based implementation of the Stack interface
class ArrayStack implements Stack {
    private int[] stackArray; // Array to store stack elements
    private int top;          // Index of the top element
    private int capacity;     // Maximum capacity of the stack

    // Constructor to initialize the stack
    public ArrayStack(int capacity) {
        this.capacity = capacity;
        this.stackArray = new int[capacity];
        this.top = -1; // Stack is initially empty
    }

    // Push an item onto the stack
    @Override
    public void push(int item) throws StackOverflowException {
        if (isFull()) {
            throw new StackOverflowException("Stack is full. Cannot push item: " + item);
        }
        stackArray[++top] = item; // Increment top and insert the item
    }

    // Pop an item from the stack
    @Override
    public int pop() throws StackUnderflowException {
        if (isEmpty()) {
            throw new StackUnderflowException("Stack is empty. Cannot pop.");
        }
        return stackArray[top--]; // Return the top item and decrement top
    }

    // Peek at the top item of the stack
    @Override
    public int peek() throws StackUnderflowException {
        if (isEmpty()) {
            throw new StackUnderflowException("Stack is empty. Cannot peek.");
        }
        return stackArray[top]; // Return the top item without removing it
    }

    // Check if the stack is empty
    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    // Check if the stack is full
    @Override
    public boolean isFull() {
        return top == capacity - 1;
    }
}

// Main class to test the stack implementation
public class Question_5{
    public static void main(String[] args) {
        try {
            Stack stack = new ArrayStack(5); // Create a stack with capacity 5

            // Push elements onto the stack
            stack.push(10);
            stack.push(20);
            stack.push(30);
            stack.push(40);
            stack.push(50);

            // Try to push to a full stack (will throw an exception)
            // stack.push(60); // Uncomment to test StackOverflowException

            // Pop elements from the stack
            System.out.println("Popped: " + stack.pop());
            System.out.println("Popped: " + stack.pop());

            // Peek at the top element
            System.out.println("Top element: " + stack.peek());

            // Pop remaining elements
            System.out.println("Popped: " + stack.pop());
            System.out.println("Popped: " + stack.pop());
            System.out.println("Popped: " + stack.pop());

            // Try to pop from an empty stack (will throw an exception)
            // System.out.println("Popped: " + stack.pop()); // Uncomment to test StackUnderflowException

        } catch (StackOverflowException | StackUnderflowException e) {
            System.out.println(e.getMessage());
        }
    }
}