package Lab4.Functions;

public class LinkedStack implements Stack{
    private Node top;
    private int size;

    public LinkedStack() {
        top = null;
        size = 0;
    }

    @Override
    public void push(int element) {
        if (size == 5) {
            System.out.println("Stack is full. Cannot push element.");
            return;
        }
        Node newNode = new Node(element);
        newNode.next = top;
        top = newNode;
        size++;
    }

    @Override
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop element.");
            return -1;
        }
        int element = peek();
        top = top.next;
        size--;
        return element;
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot peek.");
            return -1;
        }
        return top.data;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
