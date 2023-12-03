package Lab4.Functions;


public class ArrayDownStack implements Stack {
    private int[] array;
    private int size;

    public ArrayDownStack() {
        array = new int[5];
        size = 5;
    }

    @Override
    public void push(int element) {
        if (size == 0) {
            System.out.println("Stack is full. Cannot push.");
            return;
        }
        array[--size] = element;
    }

    @Override
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop.");
            return -1;
        }
        int element = peek();
        array[size++] = 0;
        return element;
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot peek.");
            return -1;
        }
        return array[size];
    }

    @Override
    public boolean isEmpty() {
        return size == 5;
    }
}
